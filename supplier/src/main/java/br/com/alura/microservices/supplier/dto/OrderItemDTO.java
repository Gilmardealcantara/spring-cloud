package br.com.alura.microservices.supplier.dto;

public class OrderItemDTO {

	private long id;
	
	private int qnt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
}
