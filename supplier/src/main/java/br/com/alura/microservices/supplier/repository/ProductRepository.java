package br.com.alura.microservices.supplier.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservices.supplier.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findByState(String state);
	
	List<Product> findByIdIn(List<Long> ids);
}
