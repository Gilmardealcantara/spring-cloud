package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.client.CarrierClient;
import br.com.alura.microservices.store.client.SupplierClient;
import br.com.alura.microservices.store.dto.*;
import br.com.alura.microservices.store.model.Purchase;
import br.com.alura.microservices.store.model.PurchaseState;
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

    @HystrixCommand(fallbackMethod = "makePurchaseFallback", threadPoolKey = "makePurchaseThreadPool")
    public Purchase makePurchase(PurchaseDto purchase){

        Purchase savedPurchase = new Purchase();
        savedPurchase.setDestinyAddress(purchase.getAddress().toString());

        savedPurchase.setState(PurchaseState.RECEIVED);
        repository.save(savedPurchase);
        purchase.setPurchaseId(savedPurchase.getId());
        // --

        InfoOrderDTO order = supplierClient.placeOrder(purchase.getItems());
        savedPurchase.setOderId(order.getId());
        savedPurchase.setPreparationTime(order.getPreparationTime());

        savedPurchase.setState(PurchaseState.ORDER_PLACED);
        repository.save(savedPurchase);
        // --
        String state = purchase.getAddress().getState();
        InfoSupplierDto info = supplierClient.getInfoByState(state);

        InfoDeliveryDTO deliveryDTO = new InfoDeliveryDTO();
        deliveryDTO.setOrderId(order.getId());
        deliveryDTO.setQuestForDate(LocalDate.now().plusDays(order.getPreparationTime()));
        deliveryDTO.setSourceAddress(info.getAddress());
        deliveryDTO.setTargetAddress(purchase.getAddress().toString());

        VoucherDTO voucher = carrierClient.reserveDelivery(deliveryDTO);

        savedPurchase.setDeliveryDate(voucher.getDeliveryForecast());
        savedPurchase.setVoucher(voucher.getNumber());

        savedPurchase.setState(PurchaseState.DELIVERY_RESERVED);
        repository.save(savedPurchase);

        return savedPurchase;
    }

    public Purchase makePurchaseFallback(PurchaseDto purchase){
        Purchase purchaseFallback = new Purchase();
        if(purchase.getPurchaseId() != null) {
            return this.getById(purchase.getPurchaseId());
        }
        purchaseFallback.setDestinyAddress(purchase.getAddress().toString());
        return purchaseFallback;
    }
}
