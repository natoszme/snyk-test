package model;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

public class RepoEstudiantes implements TransactionalOps, WithGlobalEntityManager{

	private static RepoEstudiantes instancia;
	private EntityManager em = entityManager();
	
	public static RepoEstudiantes getInstance() {
		if(instancia == null){
			instancia = new RepoEstudiantes();
		}
		return instancia;
	}
	
	public Estudiante estudiante(long id) {
		return em.find(Estudiante.class, id);
	}

}
