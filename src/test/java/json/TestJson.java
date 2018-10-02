package json;


import org.junit.Assert;
import org.junit.Test;

import model.estudiante.Estudiante;

public class TestJson {
	private String jsonDeMatias = "{\r\n" + 
			"    \"code\": \"111222333\",\r\n" + 
			"    \"first_name\": \"Matias\",\r\n" + 
			"    \"last_name\": \"Kranevitter\",\r\n" + 
			"    \"github_user\": \"kranevictor\"\r\n" + 
			"}";
	
	private String jsonAsignacionesMatias = "{\r\n" + 
			"    \"assignments\": [\r\n" + 
			"        {\r\n" + 
			"            \"id\": 1,\r\n" + 
			"            \"title\": \"TPA1\",\r\n" + 
			"            \"description\": \"Entrega 1 del TP Anual\",\r\n" + 
			"            \"grades\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"id\": 2,\r\n" + 
			"            \"title\": \"TPA2\",\r\n" + 
			"            \"description\": \"Entrega 2 del TP Anual\",\r\n" + 
			"            \"grades\": []\r\n" + 
			"        }\r\n" + 
			"    ]\r\n" + 
			"}";
	
	@Test
	public void alPasarUnJsonDevuelveBienElNombreDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("Matias", matias.getNombre());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElApellidoDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("Kranevitter", matias.getApellido());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElGithubUserDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("kranevictor", matias.getGithubUser());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElLegajoDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals(111222333, matias.getLegajo());
	}
	
	@Test
	public void alPasarUnJsonDeAsignacionesDevuelveBienElNombreDeLaAsignacion() {
		//List<AsignacionTarea> asignacionesMatias = JsonDeserializer.deserializarAsignaciones(jsonAsignacionesMatias);
		Estudiante matiasConAsignaciones = JsonDeserializer.deserializarAsignaciones(jsonAsignacionesMatias);
		Assert.assertEquals("TPA1", matiasConAsignaciones.getAsignaciones().get(0).getTarea().getNombre());
	}
}
