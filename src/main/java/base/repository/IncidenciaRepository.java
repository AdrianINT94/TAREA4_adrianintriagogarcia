package base.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import base.incidencias.Incidencia;

public class IncidenciaRepository {
	
		private String urlServidor ="objectdb://localhost:6136/incidencias.odb;user=admin;password=admin";
		
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
}
