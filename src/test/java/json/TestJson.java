package json;


import org.junit.Assert;
import org.junit.Test;

import fixture.Fixture;
import model.estudiante.Estudiante;
import model.tarea.EnumNotaConceptual;
import model.tarea.NotaConceptual;
import model.tarea.NotaNumerica;

public class TestJson extends Fixture{
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
	
	private String jsonAsignacionesConNotas = "{\r\n" + 
			"  \"assignments\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 1,\r\n" + 
			"      \"title\": \"Primer Parcial\",\r\n" + 
			"      \"description\": null,\r\n" + 
			"      \"grades\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 1,\r\n" + 
			"          \"value\": 2,\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.526Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.526Z\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 2,\r\n" + 
			"          \"value\": 7,\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.595Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.595Z\"\r\n" + 
			"        }\r\n" + 
			"      ]\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}";
	
	private String jsonConNotasConceptualesYNumericas = "{\r\n" + 
			"  \"assignments\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 1,\r\n" + 
			"      \"title\": \"Primer Parcial\",\r\n" + 
			"      \"description\": null,\r\n" + 
			"      \"grades\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 1,\r\n" + 
			"          \"value\": 2,\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.526Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.526Z\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 2,\r\n" + 
			"          \"value\": \"B+\",\r\n" +
			"          \"created_at\": \"2017-03-25T13:56:07.595Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.595Z\"\r\n" + 
			"        }\r\n" + 
			"      ]\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 3,\r\n" + 
			"      \"title\": \"TPA1\",\r\n" + 
			"      \"description\": \"Primera Entrega del TP Anual\",\r\n" + 
			"      \"grades\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 4,\r\n" + 
			"          \"value\": \"B+\",\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.649Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.649Z\"\r\n" + 
			"        }\r\n" + 
			"      ]\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}\r\n" + 
			"";
	
	@Test
	public void alPasarUnJsonDevuelveBienElNombreDelEstudiante() {
		Estudiante matias = JsonParser.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("Matias", matias.getNombre());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElApellidoDelEstudiante() {
		Estudiante matias = JsonParser.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("Kranevitter", matias.getApellido());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElGithubUserDelEstudiante() {
		Estudiante matias = JsonParser.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals("kranevictor", matias.getGithubUser());
	}
	
	@Test
	public void alPasarUnJsonDevuelveBienElLegajoDelEstudiante() {
		Estudiante matias = JsonParser.deserializarEstudiante(jsonDeMatias);
		Assert.assertEquals(111222333, matias.getLegajo());
	}
	
	@Test
	public void alPasarUnJsonDeAsignacionesDevuelveBienElNombreDeLaAsignacion() {
		//List<AsignacionTarea> asignacionesMatias = JsonDeserializer.deserializarAsignaciones(jsonAsignacionesMatias);
		Estudiante matiasConAsignaciones = JsonParser.deserializarAsignaciones(jsonAsignacionesMatias);
		Assert.assertEquals("TPA1", matiasConAsignaciones.getAsignaciones().get(0).getTarea().getNombre());
	}
	
	@Test
	public void lasNotasNumericasDeUnaAsignacionSeLevantanBien() {
		Estudiante matiasConAsignaciones = JsonParser.deserializarAsignaciones(jsonAsignacionesConNotas);
		Assert.assertEquals(7.0, ((NotaNumerica)matiasConAsignaciones.getAsignaciones().get(0).getUltimaNota()).valor(), 0);
	}
	
	@Test
	public void lasNotasConceptualesDeUnaAsignacionSeLevantanBien() {
		Estudiante matiasConAsignaciones = JsonParser.deserializarAsignaciones(jsonConNotasConceptualesYNumericas);
		Assert.assertEquals(EnumNotaConceptual.BIEN_MAS, ((NotaConceptual)matiasConAsignaciones.getAsignaciones().get(0).getUltimaNota()).valor());
	}
	
	@Test
	public void alSerializarEstudianteElJsonContieneSuNombre() {
		Assert.assertTrue(JsonParser.serializarEstudiante(estudiante).contains("Pepe"));
	}
}
