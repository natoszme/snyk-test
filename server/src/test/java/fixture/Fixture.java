package fixture;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;

import model.Asignacion;
import model.Estudiante;
import model.Tarea;

public class Fixture {
	protected Estudiante pedrito = new Estudiante("1234567", "Pedro", "Sanchez", "elpepe@pepe.com", "dritoSanchez");
	protected Tarea tpNotitas = new Tarea("TP Notitas", "Hacer el tp de notitas", new Date());
	protected Asignacion notitasDePedrito = new Asignacion(tpNotitas);	
	
	protected Tarea tpPdep = new Tarea("TP Objetos PDEP", "En esta entrega modelaremos los personajes de lucha...", new Date());
	protected Asignacion tpPdepPedrito = new Asignacion(tpPdep);
	
	@Before
	public void before() {
		estudianteDePrueba();
	}
	
	public Estudiante estudianteDePrueba() {
		notitasDePedrito.setNotas(Arrays.asList("R", "8"));
		pedrito.agregarAsignacion(notitasDePedrito);
		
		tpPdepPedrito.setNotas(Arrays.asList("M", "R", "9"));
		pedrito.agregarAsignacion(tpPdepPedrito);
		
		return pedrito;
	}
}
