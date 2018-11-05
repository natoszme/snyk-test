package json;

import org.junit.Test;

import fixture.Fixture;

import org.junit.Assert;

public class TestJsonParser extends Fixture{
	
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
