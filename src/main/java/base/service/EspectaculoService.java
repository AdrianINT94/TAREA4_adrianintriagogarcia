package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Espectaculo;
import base.repository.EspectaculoRepository;

@Service
public class EspectaculoService {

    private final EspectaculoRepository espectaculoRepository;

    public EspectaculoService(EspectaculoRepository espectaculoRepository) {
        this.espectaculoRepository = espectaculoRepository;
    }

    public List<Espectaculo> findAll() {
        return espectaculoRepository.findAll();
    }

    public Espectaculo save(Espectaculo espectaculo) {
        return espectaculoRepository.save(espectaculo);
    }

    public void deleteById(Long id) {
        espectaculoRepository.deleteById(id);
    }
}