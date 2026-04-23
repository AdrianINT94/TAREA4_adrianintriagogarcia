package base.incidencias;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class ResolucionIncidencia {
		@Id	@GeneratedValue
		private Long id;
		private LocalDateTime fechahoraResolucion = LocalDateTime.now();
		private String accionesRealizadas;
		private Long idPersonaResuelve;
		
		@OneToOne
		private Incidencia incidencia;
		
		public ResolucionIncidencia() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getFechahoraResolucion() {
			return fechahoraResolucion;
		}

		public void setFechahoraResolucion(LocalDateTime fechahoraResolucion) {
			this.fechahoraResolucion = fechahoraResolucion;
		}

		public String getAccionesRealizadas() {
			return accionesRealizadas;
		}

		public void setAccionesRealizadas(String accionesRealizadas) {
			this.accionesRealizadas = accionesRealizadas;
		}

		public Long getIdPersonaResuelve() {
			return idPersonaResuelve;
		}

		public void setIdPersonaResuelve(Long idPersonaResuelve) {
			this.idPersonaResuelve = idPersonaResuelve;
		}

		public Incidencia getIncidencia() {
			return incidencia;
		}

		public void setIncidencia(Incidencia incidencia) {
			this.incidencia = incidencia;
		}
		
		
		
		
		
}
