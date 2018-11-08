package router.transformer;

import json.JsonParser;
import model.Estudiante;
import spark.ResponseTransformer;

public class EstudianteToJsonTransformer implements ResponseTransformer{

	@Override
	public String render(Object estudiante){
		return JsonParser.obtenerJsonEstudiante((Estudiante) estudiante);
	}

}
