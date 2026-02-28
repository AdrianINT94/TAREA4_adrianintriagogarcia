package base.service;

import org.springframework.stereotype.Service;

import base.model.Credencial;
import base.repository.CredencialRepository;

@Service
public class CredencialService {

    private final CredencialRepository credencialRepository;

    public CredencialService(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    public Credencial getByUsername(String username) {
        return credencialRepository.findByNombreusuario(username);
    }

    public Credencial save(Credencial credencial) {
        return credencialRepository.save(credencial);
    }

    public void deleteById(Long id) {
        credencialRepository.deleteById(id);
    }
}