package br.com.alura.microservices.store.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long oderId;
    private Integer preparationTime;
    private String destinyAddress;

    private LocalDate deliveryDate;
    private Long voucher;

    @Enumerated(EnumType.STRING)
    private PurchaseState state;

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

    public void setState(PurchaseState state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public PurchaseState getState() {
        return state;
    }
}
