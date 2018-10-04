package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import model.tarea.Nota;
import model.tarea.NotaConceptual;
import model.tarea.NotaNumerica;

public class NotaJsonDeserializer extends JsonDeserializer<Nota>{
	
	@Override
	public Nota deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		
		//TODO esto quedo muy feo
		Double notaNumerica = node.get("value").asDouble(-1.0);
		
		if(notaNumerica == -1.0) {
			String notaConceptual = node.get("value").asText();
			return new NotaConceptual(notaConceptual);
		}
		
		return new NotaNumerica(notaNumerica);
	}
}
