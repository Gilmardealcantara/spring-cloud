package br.com.alura.microservices.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Purchase {
    @Id
    private Long oderId;
    private Integer preparationTime;
    private String destinyAddress;

    private LocalDate deliveryDate;
    private Long voucher;

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getVoucher() {
        return voucher;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

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
