package json;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;

import model.Asignacion;
import model.Estudiante;
import model.Tarea;

public class TestJsonParser {
	
	private Estudiante pedrito = new Estudiante("1234567", "Pedro", "Sanchez", "elpepe@pepe.com", "dritoSanchez");
	
	@Before
	public void before() {
		Tarea tpNotitas = new Tarea("TP Notitas", "Hacer el tp de notitas", new Date());
		Asignacion notitasDePedrito = new Asignacion(tpNotitas);
		notitasDePedrito.setNotas(Arrays.asList("R", "8"));
		pedrito.agregarAsignacion(notitasDePedrito);
		
		Tarea tpPdep = new Tarea("TP Objetos PDEP", "En esta entrega modelaremos los personajes de lucha...", new Date());
		Asignacion tpPdepPedrito = new Asignacion(tpPdep);
		tpPdepPedrito.setNotas(Arrays.asList("M", "R", "9"));
		pedrito.agregarAsignacion(tpPdepPedrito);
	}
	
	@Test
	public void elJsonDeEstudianteTieneCode() {
		String pedritoEnJson = JsonParser.obtenerJsonEstudiante(pedrito);
		Assert.assertTrue(pedritoEnJson.contains("code"));
		System.out.println(pedritoEnJson);
	}
	
	@Test
	public void elJsonDeEstudianteTieneNombre() {
		String pedritoEnJson = JsonParser.obtenerJsonEstudiante(pedrito);
		Assert.assertTrue(pedritoEnJson.contains("first_name"));
	}
	
	@Test
	public void elJsonDeAsignacionesTieneUnRegular() {
		String jsonAsignaciones = JsonParser.obtenerJsonAsignaciones(pedrito);
		System.out.println(jsonAsignaciones);
		Assert.assertTrue(jsonAsignaciones.contains("R"));		
	}
}
