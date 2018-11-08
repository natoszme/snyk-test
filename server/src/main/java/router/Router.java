package router;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import controller.ControllerEstudiante;
import router.transformer.EstudianteToAsignacionesJsonTransformer;
import router.transformer.EstudianteToJsonTransformer;
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
				Spark.halt(401, "{}");
			}
			
			if(req.requestMethod() != "GET") {
				beginTransaction();
			}
		});
		
		Spark.get("/student", ControllerEstudiante::obtenerEstudiante, new EstudianteToJsonTransformer());
		Spark.get("/student/assignments", ControllerEstudiante::obtenerEstudiante, new EstudianteToAsignacionesJsonTransformer());
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
