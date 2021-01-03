package br.com.alura.microservices.store.controller;

import br.com.alura.microservices.store.controller.dto.PurchaseDto;
import br.com.alura.microservices.store.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.RequestMatchResult;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> makePurchase(@RequestBody PurchaseDto request) {
        purchaseService.makePurchase(request);
        return ResponseEntity.ok(request);
    }
}
