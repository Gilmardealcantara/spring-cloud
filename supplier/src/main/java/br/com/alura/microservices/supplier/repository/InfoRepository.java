package br.com.alura.microservices.supplier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.supplier.model.InfoSupplier;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplier, Long>{

	InfoSupplier findByState(String state);
}
