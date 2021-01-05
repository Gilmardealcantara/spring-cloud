package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.client.CarrierClient;
import br.com.alura.microservices.store.client.SupplierClient;
import br.com.alura.microservices.store.dto.*;
import br.com.alura.microservices.store.model.Purchase;
import br.com.alura.microservices.store.repository.PurchaseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PurchaseService {
    private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private SupplierClient supplierClient;

    @Autowired
    private CarrierClient carrierClient;

    @Autowired
    private PurchaseRepository repository;

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Purchase getById(Long id) {
        return repository.findById(id).orElse(new Purchase());
    }

    // @HystrixCommand(fallbackMethod = "makePurchaseFallback", threadPoolKey = "makePurchaseThreadPool")
    public Purchase makePurchase(PurchaseDto purchase){

        String state = purchase.getAddress().getState();

        LOG.info("Getting information for supplier of {}", state);
        InfoSupplierDto info = supplierClient.getInfoByState(state);

        LOG.info("Placing a Order");
        InfoOrderDTO order = supplierClient.placeOrder(purchase.getItems());

        InfoDeliveryDTO deliveryDTO = new InfoDeliveryDTO();
        deliveryDTO.setOrderId(order.getId());
        deliveryDTO.setQuestForDate(LocalDate.now().plusDays(order.getPreparationTime()));
        deliveryDTO.setSourceAddress(info.getAddress());
        deliveryDTO.setTargetAddress(purchase.getAddress().toString());
        VoucherDTO voucher = carrierClient.reserveDelivery(deliveryDTO);

        Purchase savedPurchase = new Purchase();
        savedPurchase.setOderId(order.getId());
        savedPurchase.setPreparationTime(order.getPreparationTime());
        savedPurchase.setDestinyAddress(purchase.getAddress().toString());

        savedPurchase.setDeliveryDate(voucher.getDeliveryForecast());
        savedPurchase.setVoucher(voucher.getNumber());

        repository.save(savedPurchase);

        return savedPurchase;
    }

    public Purchase makePurchaseFallback(PurchaseDto purchase){
        Purchase purchaseFallback = new Purchase();
        purchaseFallback.setDestinyAddress(purchase.getAddress().toString());
        return purchaseFallback;
    }
}
