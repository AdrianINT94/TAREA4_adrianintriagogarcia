package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Numero;
import base.repository.NumeroRepository;

@Service
public class NumeroService {

    private final NumeroRepository numeroRepository;

    public NumeroService(NumeroRepository numeroRepository) {
        this.numeroRepository = numeroRepository;
    }

    public List<Numero> findAll() {
        return numeroRepository.findAll();
    }

    public Numero save(Numero numero) {
        return numeroRepository.save(numero);
    }

    public void deleteById(Long id) {
        numeroRepository.deleteById(id);
    }
}