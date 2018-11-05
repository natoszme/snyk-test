package fixture;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import model.Asignacion;
import model.Estudiante;
import model.Tarea;

public class DatosDePrueba implements TransactionalOps, WithGlobalEntityManager{
	
	EntityManager em = entityManager();
	
	protected Estudiante pedrito = new Estudiante("1234567", "Pedro", "Sanchez", "elpepe@pepe.com", "dritoSanchez");
	protected Tarea tpNotitas = new Tarea("TP Notitas", "Hacer el tp de notitas", new Date());
	protected Asignacion notitasDePedrito = new Asignacion(tpNotitas);	
	
	protected Tarea tpPdep = new Tarea("TP Objetos PDEP", "En esta entrega modelaremos los personajes de lucha...", new Date());
	protected Asignacion tpPdepPedrito = new Asignacion(tpPdep);
		
	public void configurar() {
		
		notitasDePedrito.setNotas(Arrays.asList("R", "8"));
		pedrito.agregarAsignacion(notitasDePedrito);
		
		tpPdepPedrito.setNotas(Arrays.asList("M", "R", "9"));
		pedrito.agregarAsignacion(tpPdepPedrito);
		
		withTransaction(() -> {	
			em.persist(tpNotitas);
			em.persist(notitasDePedrito);
			
			em.persist(tpPdep);
			em.persist(tpPdepPedrito);
			
			em.persist(pedrito);
		});
		
		generarTokenPara(pedrito);
	}
	
	public void generarTokenPara(Estudiante estudiante) {
		String secret = "god";
		Algorithm algorithm = Algorithm.HMAC256(secret);
		String token = JWT.create()
		    .withClaim("user", estudiante.getId())
		    .sign(algorithm);
		
		System.out.println(estudiante.getId());
		System.out.println(token);
	}
}
