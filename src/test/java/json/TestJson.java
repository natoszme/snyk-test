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
	
	@Test
	public void alPasarUnJsonDevuelveBienElNombreDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarCliente(jsonDeMatias);
		Assert.assertEquals("Matias", matias.getNombre());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElApellidoDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarCliente(jsonDeMatias);
		Assert.assertEquals("Kranevitter", matias.getApellido());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElGithubUserDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarCliente(jsonDeMatias);
		Assert.assertEquals("kranevictor", matias.getGithubUser());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElLegajoDelEstudiante() {
		Estudiante matias = JsonDeserializer.deserializarCliente(jsonDeMatias);
		Assert.assertEquals(111222333, matias.getLegajo());
	}
}
