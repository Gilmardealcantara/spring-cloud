package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.client.SupplierClient;
import br.com.alura.microservices.store.dto.InfoOrderDTO;
import br.com.alura.microservices.store.dto.InfoSupplierDto;
import br.com.alura.microservices.store.dto.PurchaseDto;
import br.com.alura.microservices.store.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private SupplierClient client;

    public Purchase makePurchase(PurchaseDto purchase){
        InfoSupplierDto info = client.getInfoByState(purchase.getAddress().getState());
        InfoOrderDTO order = client.placeOrder(purchase.getItems());
        System.out.println(info.getAddress());

        Purchase savedPurchase = new Purchase();
        savedPurchase.setOderId(order.getId());
        savedPurchase.setPreparationTime(order.getPreparationTime());
        savedPurchase.setDestinyAddress(purchase.getAddress().toString());

        return savedPurchase;
    }
}
