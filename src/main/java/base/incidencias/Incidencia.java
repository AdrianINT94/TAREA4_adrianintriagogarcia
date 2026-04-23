package base.incidencias;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Incidencia {
	
	@Id 
	@GeneratedValue
	private Long id;
	private LocalDateTime fechaHora =LocalDateTime.now();
	private String tipo;
	private String descripcion;
	private boolean resuelta = false;
	private Long IdPersonaReporta;
	private Long IdNumero;
	private Long IdEspectaculo;
	
	public Incidencia() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isResuelta() {
		return resuelta;
	}

	public void setResuelta(boolean resuelta) {
		this.resuelta = resuelta;
	}

	public Long getIdPersonaReporta() {
		return IdPersonaReporta;
	}

	public void setIdPersonaReporta(Long idPersonaReporta) {
		IdPersonaReporta = idPersonaReporta;
	}

	public Long getIdNumero() {
		return IdNumero;
	}

	public void setIdNumero(Long idNumero) {
		IdNumero = idNumero;
	}

	public Long getIdEspectaculo() {
		return IdEspectaculo;
	}

	public void setIdEspectaculo(Long idEspectaculo) {
		IdEspectaculo = idEspectaculo;
	}
	
}
