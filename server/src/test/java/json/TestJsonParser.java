package json;

import org.junit.Test;

import org.junit.Assert;
import model.Estudiante;

public class TestJsonParser {
	
	private Estudiante pedrito = new Estudiante("1234567", "Pedro", "Sanchez", "elpepe@pepe.com", "dritoSanchez");
	
	@Test
	public void elJsonDeEstudianteTieneCode() {
		String pedritoEnJson = JsonParser.obtenerJsonEstudiante(pedrito);
		Assert.assertTrue(pedritoEnJson.contains("code"));
		System.out.println(pedritoEnJson);
	}
}
