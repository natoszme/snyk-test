package json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Estudiante;

public class JsonParser {

	public static String obtenerJsonEstudiante(Estudiante estudiante) {
		String jsonResult = "";
		try {
			Estudiante estudianteSinAsignaciones = new Estudiante();
			estudianteSinAsignaciones.actualizarDatos(estudiante);
			estudianteSinAsignaciones.setAsignaciones(null);
			jsonResult = new ObjectMapper().writeValueAsString(estudianteSinAsignaciones);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}

	public static String obtenerJsonAsignaciones(Estudiante estudiante) {
		String jsonResult = "";
		try {
			Estudiante estudianteConAsignaciones = new Estudiante();
			estudianteConAsignaciones.setAsignaciones(estudiante.getAsignaciones());
			jsonResult = new ObjectMapper().writeValueAsString(estudianteConAsignaciones);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}

	public static Estudiante obtenerEstudianteDeJson(String json) {
		Estudiante estudiante = null;
		try {
			estudiante = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(json, Estudiante.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estudiante;
	}

}
