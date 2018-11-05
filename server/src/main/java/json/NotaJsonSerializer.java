package json;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NotaJsonSerializer extends JsonSerializer<List<String>> {

	@Override
	public void serialize(List<String> notas, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException {
		List<String> notasParaJson = notas.stream().map(nota -> jsonDeNota(nota)).collect(Collectors.toList());
		
		try {
			jsonGenerator.writeString(notasParaJson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String jsonDeNota(String nota) {
		return "{value: '" + nota + "'}";
	}
}