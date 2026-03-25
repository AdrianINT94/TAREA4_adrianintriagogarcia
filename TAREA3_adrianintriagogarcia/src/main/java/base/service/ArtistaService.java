package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Artista;
import base.repository.ArtistaRepository;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void deleteById(Long id) {
        artistaRepository.deleteById(id);
    }
}