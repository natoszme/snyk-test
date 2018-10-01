package notasService;

import com.sun.jersey.api.client.Client;

import httpClientService.HttpClient;
import model.estudiante.Estudiante;

public class NotasService {
	
    public Estudiante dameEstudiante() {
    	return JsonDeserializer.deserializarCliente(HttpClient.getInstance().dameEstudiante());
    }
}
