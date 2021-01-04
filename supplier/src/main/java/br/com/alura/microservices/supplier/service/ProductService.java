package br.com.alura.microservices.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.supplier.model.Product;
import br.com.alura.microservices.supplier.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductsByState(String state) {
		return productRepository.findByState(state);
	}

}
