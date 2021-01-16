package br.com.alura.microservices.store.dto;

import java.time.LocalDate;

public class InfoDeliveryDTO {
    private Long orderId;

    private LocalDate questForDate;

    private String sourceAddress;

    private String targetAddress;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getQuestForDate() {
        return questForDate;
    }

    public void setQuestForDate(LocalDate questForDate) {
        this.questForDate = questForDate;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

}
