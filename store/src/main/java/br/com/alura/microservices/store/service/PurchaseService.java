package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.client.SupplierClient;
import br.com.alura.microservices.store.dto.InfoOrderDTO;
import br.com.alura.microservices.store.dto.InfoSupplierDto;
import br.com.alura.microservices.store.dto.PurchaseDto;
import br.com.alura.microservices.store.model.Purchase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private SupplierClient client;

    @HystrixCommand(fallbackMethod = "makePurchaseFallback")
    public Purchase makePurchase(PurchaseDto purchase){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String state = purchase.getAddress().getState();

        LOG.info("Getting information for supplier of {}", state);
        InfoSupplierDto info = client.getInfoByState(state);

        LOG.info("Placing a Order");
        InfoOrderDTO order = client.placeOrder(purchase.getItems());
        System.out.println(info.getAddress());

        Purchase savedPurchase = new Purchase();
        savedPurchase.setOderId(order.getId());
        savedPurchase.setPreparationTime(order.getPreparationTime());
        savedPurchase.setDestinyAddress(purchase.getAddress().toString());

        return savedPurchase;
    }

    public Purchase makePurchaseFallback(PurchaseDto purchase){
        Purchase purchaseFallback = new Purchase();
        purchaseFallback.setDestinyAddress(purchase.getAddress().toString());
        return purchaseFallback;
    }
}
