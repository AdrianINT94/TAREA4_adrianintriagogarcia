package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.model.Artista;

public interface ArtistaRepository  extends JpaRepository<Artista,Long> {
	


}
