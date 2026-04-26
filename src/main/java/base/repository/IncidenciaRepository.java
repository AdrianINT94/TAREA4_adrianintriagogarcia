package base.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import base.incidencias.Incidencia;
import base.incidencias.ResolucionIncidencia;

public class IncidenciaRepository {
	
		private String urlServidor ="ficheros/incidencias.odb;user=admin;password=admin";
		
		public void guardar(Incidencia incidencia) {
			EntityManagerFactory fabrica =Persistence.createEntityManagerFactory(urlServidor);
			EntityManager manejador = fabrica.createEntityManager();
			
			try {
				manejador.getTransaction().begin();
				manejador.persist(incidencia);
				manejador.getTransaction().commit();
				System.out.println("Incidencia guardada con exito en ObjectDB");
			}catch(Exception e) {
				if(manejador.getTransaction().isActive()) {
					manejador.getTransaction().rollback();
				}
				e.printStackTrace();
			}finally {
				manejador.close();
				fabrica.close();
			}
		}
		
		public List<Incidencia> obtenerTodas(){
			EntityManagerFactory fabrica =Persistence.createEntityManagerFactory(urlServidor);
			EntityManager manejador = fabrica.createEntityManager();
			try {
				TypedQuery<Incidencia> consulta = manejador.createQuery("SELECT i FROM Incidencia i",Incidencia.class);
				return consulta.getResultList();
			}finally {
				manejador.close();
				fabrica.close();
			}
		}

		
		public List<Incidencia> buscarPorTipo(String tipoSeleccionado){
			EntityManagerFactory fabrica =Persistence.createEntityManagerFactory(urlServidor);
			EntityManager manejador = fabrica.createEntityManager();
			try {
				TypedQuery<Incidencia> query = manejador.createQuery("SELECT i FROM Incidencia i WHERE i.tipo = :valor",Incidencia.class);
				query.setParameter("valor",tipoSeleccionado);
				return query.getResultList();
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				manejador.close();
				fabrica.close();
			}
		}
		public void resolver (Incidencia incidencia,ResolucionIncidencia resolucion) {
			EntityManagerFactory fabrica= Persistence.createEntityManagerFactory(urlServidor);
			EntityManager manejador = fabrica.createEntityManager();
			
			try {
					manejador.getTransaction().begin();
					
					incidencia.setResuelta(true);
					manejador.merge(incidencia);
					
					resolucion.setIncidencia(incidencia);
					manejador.persist(resolucion);
					manejador.getTransaction().commit();
					System.out.println("Resolucion guardada correctamente");
					
			}catch(Exception e) {
				manejador.getTransaction().rollback();
			}
		}
		
}
