package router;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import controller.ControllerEstudiante;
import security.InvalidTokenException;
import spark.Spark;

public class Router implements TransactionalOps, WithGlobalEntityManager{

	public void configure() {
		
		EntityManager em = entityManager();
		
		Spark.before("/*", (req, res) -> {
			
			try	{
				ControllerEstudiante.autenticarAlumno(req, res);			
			}
			catch (InvalidTokenException e) {
				//TODO devolver un json vacio, que el cliente sepa manejar
				//con halt, para que no siga ejecutando lo de abajo
			}
			
			if(req.requestMethod() != "GET") {
				beginTransaction();
			}
		});
		
		Spark.get("/student", ControllerEstudiante::obtenerEstudiante);
		Spark.get("/student/assignments", ControllerEstudiante::obtenerAsignacionesEstudiante);
		Spark.put("/student", ControllerEstudiante::actualizarDatosEstudiante);
		
		Spark.after("/*", (req, res) -> {
			
			ControllerEstudiante.limpiarSession(req);
			
			if(req.requestMethod() != "GET") {
				try {
					commitTransaction();
					em.clear();
				}
				catch (RollbackException e) {
					rollbackTransaction();
				}
				
			}
		});
	}

}
