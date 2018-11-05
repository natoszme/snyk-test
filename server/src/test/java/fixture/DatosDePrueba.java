package fixture;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Asignacion;
import model.Estudiante;
import model.Tarea;
import security.SecurityService;

public class DatosDePrueba implements TransactionalOps, WithGlobalEntityManager{
	
	EntityManager em = entityManager();
	
	protected Estudiante pedrito = new Estudiante("1234567", "Pedro", "Sanchez", "elpepe@pepe.com", "dritoSanchez");
	protected Tarea tpNotitas = new Tarea("TP Notitas", "Hacer el tp de notitas", new Date());
	protected Asignacion notitasDePedrito = new Asignacion(tpNotitas);	
	
	protected Tarea tpPdep = new Tarea("TP Objetos PDEP", "En esta entrega modelaremos los personajes de lucha...", new Date());
	protected Asignacion tpPdepPedrito = new Asignacion(tpPdep);
		
	public void configurar() {
		
		notitasDePedrito.setNotas(Arrays.asList("R", "8", "B+"));
		pedrito.agregarAsignacion(notitasDePedrito);
		
		tpPdepPedrito.setNotas(Arrays.asList("M", "R", "9", "M"));
		pedrito.agregarAsignacion(tpPdepPedrito);
		
		withTransaction(() -> {	
			em.persist(tpNotitas);
			em.persist(notitasDePedrito);
			
			em.persist(tpPdep);
			em.persist(tpPdepPedrito);
			
			em.persist(pedrito);
		});
		
		System.out.println(SecurityService.generarTokenPara(pedrito.getId()));
	}
}
