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
		Tarea tpNotitas = new Tarea(new Date(), "Hacer el tp de notitas");
		Asignacion notitasDePedrito = new Asignacion(tpNotitas);
		notitasDePedrito.setNotas(Arrays.asList("R", "8"));
		pedrito.agregarAsignacion(notitasDePedrito);
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
