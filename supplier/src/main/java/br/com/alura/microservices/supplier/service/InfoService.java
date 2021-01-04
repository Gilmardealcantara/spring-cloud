package br.com.alura.microservices.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.supplier.model.InfoSupplier;
import br.com.alura.microservices.supplier.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoSupplier getInfoByState(String state) {
		return infoRepository.findByState(state);
	}
}
