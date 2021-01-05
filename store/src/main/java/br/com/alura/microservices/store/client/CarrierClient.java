package br.com.alura.microservices.store.client;

import br.com.alura.microservices.store.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("carrier")
public interface CarrierClient {

    @RequestMapping(method = RequestMethod.POST, path = "/delivery")
    VoucherDTO reserveDelivery(InfoDeliveryDTO deliveryDTO);
}
