package br.alura.microrservice.carrier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.alura.microrservice.carrier.model.Delivery;

@Repository
public interface EntregaRepository extends CrudRepository<Delivery, Long>{

}
