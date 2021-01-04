package br.com.alura.microservices.supplier.service;

import br.com.alura.microservices.supplier.model.InfoSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Autowired
    private InfoRepository infoRepository;

    public InfoSupplier getInfoByState(String state){
        return infoRepository.findByState(state);
    }
}
