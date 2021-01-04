package br.com.alura.microservices.supplier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.supplier.dto.OrderItemDTO;
import br.com.alura.microservices.supplier.model.Order;
import br.com.alura.microservices.supplier.model.OrderItem;
import br.com.alura.microservices.supplier.model.Product;
import br.com.alura.microservices.supplier.repository.OrderRepository;
import br.com.alura.microservices.supplier.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public Order placeOrder(List<OrderItemDTO> items) {
		
		if(items == null) {
			return null;
		}
		
		List<OrderItem> orderItems = toOrderItem(items);
		Order order = new Order(orderItems);
		order.setPreparationTime(items.size());
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) {
		return this.orderRepository.findById(id).orElse(new Order());
	}

	private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {
		
		List<Long> idsProducts = items
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> productsOfOrder = productRepository.findByIdIn(idsProducts);
		
		List<OrderItem> orderItems = items
			.stream()
			.map(item -> {
				Product product = productsOfOrder
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				OrderItem orderItem = new OrderItem();
				orderItem.setProduct(product);
				orderItem.setQnt(item.getQnt());
				return orderItem;
			})
			.collect(Collectors.toList());
		return orderItems;
	}
}
