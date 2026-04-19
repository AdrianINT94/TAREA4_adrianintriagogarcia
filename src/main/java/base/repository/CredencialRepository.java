package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.model.Credencial;

public interface CredencialRepository extends JpaRepository<Credencial,Long>{
	
		Credencial findByNombreusuario(String nombreusuario);
	
}
