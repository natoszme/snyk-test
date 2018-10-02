package notasService;

import httpClientService.HttpClient;
import json.JsonDeserializer;
import model.estudiante.Estudiante;

public class NotasService {
	
    public Estudiante dameEstudiante() {
    	return JsonDeserializer.deserializarCliente(HttpClient.getInstance().dameEstudiante());
    }
}
