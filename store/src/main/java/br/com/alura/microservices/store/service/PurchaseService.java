package br.com.alura.microservices.store.service;

import br.com.alura.microservices.store.controller.dto.InfoSupplier;
import br.com.alura.microservices.store.controller.dto.PurchaseDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService {
    public void makePurchase(PurchaseDto purchase){
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoSupplier> exchange = client.exchange("http://localhost:8081/info/" + purchase.getAddress().getState(), HttpMethod.GET, null, InfoSupplier.class);
        System.out.printf(exchange.getBody().getAddress());
    }
}
