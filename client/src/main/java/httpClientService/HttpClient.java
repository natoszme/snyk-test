package httpClientService;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class HttpClient {
	private static Client cliente;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String PRE_TOKEN = "Bearer";
    private static String token;
    private static final String RECURSO_ESTUDIANTE = "student";
    private static final String RECURSO_TAREAS = "assignments";
    
    private static HttpClient instancia;
    
    public static HttpClient getInstance(){
    	if(instancia == null) {
    		instancia = new HttpClient();
    	}
    	return instancia;
    }

    public HttpClient() {
        cliente = Client.create();        
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }
    
    public static void setToken(String nuevoToken) {
    	token = nuevoToken;
    }
    
    public static String getToken() {
		return token;
	}
    
    public String dameEstudiante() {
    	 ClientResponse response = cliente.resource(API_NOTAS).path(RECURSO_ESTUDIANTE)
                 .accept(MediaType.APPLICATION_JSON)
                 .header("Authorization", PRE_TOKEN + " " + token)
                 .get(ClientResponse.class);
         return response.getEntity(String.class);
    }
    
    public String dameAsignaciones() {
    	 ClientResponse response = cliente.resource(API_NOTAS).path(RECURSO_ESTUDIANTE + "/" + RECURSO_TAREAS)
                 .accept(MediaType.APPLICATION_JSON)
                 .header("Authorization", PRE_TOKEN + " " + token)
                 .get(ClientResponse.class);
         return response.getEntity(String.class);
    }

	public void actualizarPerfilEstudiante(String estudianteSerializado) {
		cliente.resource(API_NOTAS).path(RECURSO_ESTUDIANTE)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", PRE_TOKEN + " " + token)
                .put(ClientResponse.class, estudianteSerializado);
	}
}
