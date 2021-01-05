package br.com.alura.microservices.store.repository;

import br.com.alura.microservices.store.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long > {

}
