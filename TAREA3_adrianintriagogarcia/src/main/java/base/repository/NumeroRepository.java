package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import base.model.Numero;


public interface NumeroRepository extends JpaRepository<Numero,Long> {
	
	

}
