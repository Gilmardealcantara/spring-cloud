package br.com.alura.microservices.supplier.servive;

import br.com.alura.microservices.supplier.model.InfoSupplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplier, Long> {
    InfoSupplier findByState(String state);
}
