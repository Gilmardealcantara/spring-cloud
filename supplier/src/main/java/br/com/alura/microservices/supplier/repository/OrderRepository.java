package br.com.alura.microservices.supplier.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservices.supplier.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
