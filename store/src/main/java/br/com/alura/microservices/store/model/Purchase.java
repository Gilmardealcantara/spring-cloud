package br.com.alura.microservices.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {
    @Id
    private Long oderId;
    private Integer preparationTime;
    private String destinyAddress;

    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDestinyAddress() {
        return destinyAddress;
    }

    public void setDestinyAddress(String destinyAddress) {
        this.destinyAddress = destinyAddress;
    }
}
