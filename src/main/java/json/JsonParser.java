package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.estudiante.Estudiante;

public class JsonDeserializerCustom {
	
	public static <Type> Type deserialize(String json, TypeReference<Type> type){
		Type deserialized = null;
		try {
			deserialized = new ObjectMapper().readValue(json, type);
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
		return deserialized;
	}

	public static Estudiante deserializarEstudiante(String json) {
		return deserialize(json, new TypeReference<Estudiante>() {});
	}
	
	public static Estudiante deserializarAsignaciones(String json){
		return deserialize(json, new TypeReference<Estudiante>() {});
	}
}
