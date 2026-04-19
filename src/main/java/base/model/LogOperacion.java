package base.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LogOperacion  implements Serializable{
	
	private Long id;
	
	private LocalDateTime fechaHora;
	private String usuario;
	private String tipoOperacion;  
	private String resumen;
	
	public LogOperacion() {}

	public LogOperacion(LocalDateTime fechaHora, String usuario, String tipoOperacion, String resumen) {
		super();
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.tipoOperacion = tipoOperacion;
		this.resumen = resumen;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
