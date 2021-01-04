package br.com.alura.microservices.store.client;

import br.com.alura.microservices.store.dto.InfoOrderDTO;
import br.com.alura.microservices.store.dto.InfoSupplierDto;
import br.com.alura.microservices.store.dto.PurchaseItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("supplier")
public interface SupplierClient {
    @RequestMapping("/info/{state}")
    InfoSupplierDto getInfoByState(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    InfoOrderDTO placeOrder(List<PurchaseItemDto> items);
}
