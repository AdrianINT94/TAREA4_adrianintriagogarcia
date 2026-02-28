package base.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "coordinadores")
public class Coordinador{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private boolean senior = false;
	private LocalDate fechaSenior;
	
	
	@OneToOne
	@JoinColumn(name ="persona_id",nullable = false,unique=true)
	private Persona persona;
	
	
	public Coordinador() {}
	
	public Coordinador(Persona persona) {
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public LocalDate getFechaSenior() {
		return fechaSenior;
	}

	public void setFechaSenior(LocalDate fechaSenior) {
		this.fechaSenior = fechaSenior;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return persona != null? persona.getNombre(): "Coordinador";
		
	}

	
}