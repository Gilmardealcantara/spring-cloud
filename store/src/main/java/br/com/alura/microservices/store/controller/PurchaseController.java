package br.com.alura.microservices.store.controller;

import br.com.alura.microservices.store.dto.PurchaseDto;
import br.com.alura.microservices.store.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> makePurchase(@RequestBody PurchaseDto request) {
        var result = purchaseService.makePurchase(request);
        return ResponseEntity.ok(result);
    }
}
