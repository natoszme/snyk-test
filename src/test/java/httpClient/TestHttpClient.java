package httpClient;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import httpClientService.HttpClient;

public class TestHttpClient {
	
	public TestHttpClient() {
		HttpClient.getInstance().setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
	}
	
	@Test
	public void alBuscarUnClienteSeObiteneUnaRespuestaConPrimerNombre() {
		ClientResponse response = HttpClient.getInstance().dameEstudiante();
		String json = response.getEntity(String.class);
		Assert.assertTrue(json.contains("first_name"));
	}
	
	@Test
	public void elEstudianteDePruebaSeLlamaMatias() {
		ClientResponse response = HttpClient.getInstance().dameEstudiante();
		String json = response.getEntity(String.class);
		Assert.assertTrue(json.contains("Matias"));
	}
}
