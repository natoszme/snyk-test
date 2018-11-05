package httpClient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import httpClientService.HttpClient;

public class TestHttpClient {
	
	@Before
	public void before() {
		HttpClient.getInstance().setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZEVzdHVkaWFudGUiOjF9.lRklsdMeqKxqO-mrmL487_c_f25f00AOb8tPmZhjMYE");
	}
	
	@Test
	public void alBuscarUnClienteSeObiteneUnaRespuestaConPrimerNombre() {
		String jsonResponse = HttpClient.getInstance().dameEstudiante();
		Assert.assertTrue(jsonResponse.contains("first_name"));
	}
	
	@Test
	public void elJsonDevueltoContieneNombre() {
		String jsonResponse = HttpClient.getInstance().dameEstudiante();
		
		System.out.println(jsonResponse);
		
		Assert.assertTrue(jsonResponse.contains("first_name"));
	}
	
	@Test
	public void elJsonDevuelveLasAsignaciones() {
		String jsonResponse = HttpClient.getInstance().dameAsignaciones();
		
		System.out.println(jsonResponse);
		
		Assert.assertTrue(jsonResponse.contains("assignments"));
	}
}
