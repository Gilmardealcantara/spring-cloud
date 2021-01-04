package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.client.SupplierClient;
import br.com.alura.microservices.store.controller.dto.InfoSupplierDto;
import br.com.alura.microservices.store.controller.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private SupplierClient client;

    public void makePurchase(PurchaseDto purchase){
        InfoSupplierDto info = client.getInfoByState(purchase.getAddress().getState());
        System.out.println(info.getAddress());
    }
}
