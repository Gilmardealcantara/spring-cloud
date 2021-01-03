package br.com.alura.microservices.store.controller.dto;

import java.util.List;

public class PurchaseDto {
     private List<PurchaseItemDto> items;
     private AddressDto address;

     public List<PurchaseItemDto> getItems() {
          return items;
     }

     public void setItems(List<PurchaseItemDto> items) {
          this.items = items;
     }

     public AddressDto getAddress() {
          return address;
     }

     public void setAddress(AddressDto address) {
          this.address = address;
     }
}
