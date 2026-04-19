package base.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import base.model.LogOperacion;
import base.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository repositorioLogs;
	
	
	public void Operacion(String nombreUsuario,String tipo,String detalle) {
		LogOperacion nuevoLog = new LogOperacion();
		
		
		nuevoLog.setUsuario(nombreUsuario);
		nuevoLog.setTipoOperacion(tipo);
		nuevoLog.setResumen(detalle);
		nuevoLog.setFechaHora(LocalDateTime.now());
		
		repositorioLogs.registrarAccion(nuevoLog);
	}
	
	public List<LogOperacion> buscarLogs(String usuario){
		return repositorioLogs.filtrarUsuario(usuario);
	}
	public List<LogOperacion> obtenerTodosLosLogs(){
		return repositorioLogs.obtenerTodos();
	}
	
	public List<LogOperacion> buscarLogsAvanzado(String usuario, String tipo, LocalDate inicio,LocalDate fin ){
		return repositorioLogs.buscarAvanzado(usuario,tipo,inicio,fin);
			
		}
	}
	

