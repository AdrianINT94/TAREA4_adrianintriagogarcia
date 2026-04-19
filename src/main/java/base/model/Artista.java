package base.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
@PrimaryKeyJoinColumn(name = "id")
public class Artista extends Persona { 

    private String apodo;

    @ElementCollection(targetClass = Especialidad.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "artista_especialidades", joinColumns = @JoinColumn(name = "id"))
    private List<Especialidad> especialidades;

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
    
    
}