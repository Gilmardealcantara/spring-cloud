package br.com.alura.microservices.store.controller;

import br.com.alura.microservices.store.controller.dto.PurchaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.RequestMatchResult;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> makePurchase(@RequestBody PurchaseDto request) {
        return ResponseEntity.ok(request);
    }
}
