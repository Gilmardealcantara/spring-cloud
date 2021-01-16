package br.com.alura.microservices.store.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class PurchaseDto {
     @JsonIgnore
     private Long PurchaseId;
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

     public Long getPurchaseId() {
          return PurchaseId;
     }

     public void setPurchaseId(Long purchaseId) {
          PurchaseId = purchaseId;
     }
}
