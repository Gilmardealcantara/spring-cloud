package br.com.alura.microservices.store.client;

import br.com.alura.microservices.store.controller.dto.InfoSupplierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("supplier")
public interface SupplierClient {
    @RequestMapping("/info/{state}")
    InfoSupplierDto getInfoByState(@PathVariable String state);
}
