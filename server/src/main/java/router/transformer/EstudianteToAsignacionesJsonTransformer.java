package router.transformer;

import json.JsonParser;
import model.Estudiante;
import spark.ResponseTransformer;

public class EstudianteToAsignacionesJsonTransformer implements ResponseTransformer{

	@Override
	public String render(Object estudiante) {
		return JsonParser.obtenerJsonAsignaciones((Estudiante) estudiante);
	}

}
