package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Coordinador;
import base.repository.CoordinadorRepository;

@Service
public class CoordinadorService {

    private final CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository) {
        this.coordinadorRepository = coordinadorRepository;
    }

    public List<Coordinador> findAll() {
        return coordinadorRepository.findAll();
    }

    public Coordinador save(Coordinador coordinador) {
        return coordinadorRepository.save(coordinador);
    }

    public void deleteById(Long id) {
        coordinadorRepository.deleteById(id);
    }
}