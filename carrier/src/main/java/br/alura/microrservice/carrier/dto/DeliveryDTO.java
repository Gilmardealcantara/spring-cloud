package br.alura.microrservice.carrier.dto;

import java.time.LocalDate;

public class DeliveryDTO {

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

	public String getTargetAddress() {
		return targetAddress;
	}

	public void setTargetAddress(String targetAddress) {
		this.targetAddress = targetAddress;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	
}
