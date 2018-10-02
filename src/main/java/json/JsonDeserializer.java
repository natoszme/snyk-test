package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.estudiante.Estudiante;

public class JsonDeserializer {

	public static Estudiante deserializarCliente(String json) {
		
		Estudiante estudiante = null;
		
		try {
			estudiante = new ObjectMapper().readValue(json, Estudiante.class);
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
