package base.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import base.model.LogOperacion;
import com.db4o.query.Predicate;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

@Repository
public class LogRepository {

    private final String RUTA_ARCHIVO = "ficheros/log.db4o";

    public void registrarAccion(LogOperacion historial) {
    	ObjectContainer canal = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), RUTA_ARCHIVO);
    	
    	try {
    		canal.store(historial);
    		canal.commit();
    		
    		System.out.println("historial actualizado. Registros totales: " + canal.query(LogOperacion.class).size());
    		
    	}catch(Exception e) {
    		System.err.println("Error al escribir en el archivo " + e.getMessage());
    		
    	}finally {
    		canal.close();
    	}
    		
    }
    
    public List<LogOperacion> filtrarUsuario(String nombreBuscado){
    	ObjectContainer lector = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),RUTA_ARCHIVO);
    	
    	try {
    		List<LogOperacion> encontrados = lector.query(new Predicate<LogOperacion>() {
    			@Override
    			public boolean match(LogOperacion reg) {
    				return reg.getUsuario().equalsIgnoreCase(nombreBuscado);
    			}
    		});
    		return new ArrayList<>(encontrados);
    		
    	}finally {
    		lector.close();
    	}
    }
    
    
    public List<LogOperacion> buscarAvanzado(String usuario,String tipo,LocalDate inicio,LocalDate fin ){
    	ObjectContainer lector = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),RUTA_ARCHIVO);
    	try {
    		List<LogOperacion> resultado = lector.query(new Predicate<LogOperacion>() {
    			@Override
    			public boolean match(LogOperacion log) {
    				boolean okUser = (usuario == null || usuario.isBlank()) || log.getUsuario().equalsIgnoreCase(usuario);
    				boolean okTipo = tipo.equals("TODOS") || log.getTipoOperacion().equals(tipo);
    				
    				LocalDate fecha = log.getFechaHora().toLocalDate();
    				boolean okInicio = (inicio == null) || !fecha.isBefore(inicio);
    				boolean okFin = (fin ==null) || !fecha.isAfter(fin);
    				
    				return okUser && okTipo &&okInicio &&okFin;
    			}
    		});
    		return new ArrayList<>(resultado);
    	}catch(Exception e) {
    		e.printStackTrace();
    		return new ArrayList<>();
    	}finally {
    		lector.close();
    	}
    }
    
    public List<LogOperacion> obtenerTodos(){
    	ObjectContainer lector = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), RUTA_ARCHIVO);
    	try {
    		ObjectSet<LogOperacion> todos = lector.query(LogOperacion.class);
    		return new ArrayList<>(todos);
    	}finally {
    		lector.close();
    	}
    }
}
  