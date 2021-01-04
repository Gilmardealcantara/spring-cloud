package br.com.alura.microservices.supplier.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="\"Order\"")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer preparationTime;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<OrderItem> items;
	
	public Order(List<OrderItem> items) {
		this.items = items;
		this.status = OrderStatus.RECEIVED;
	}
	
	public Order() {
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Integer getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
}
