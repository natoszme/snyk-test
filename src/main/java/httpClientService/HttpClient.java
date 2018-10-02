package httpClientService;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class HttpClient {
	private Client cliente;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String PRE_TOKEN = "Bearer";
    private String token;
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
        this.cliente = Client.create();        
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }
    
    public void setToken(String token) {
		this.token = token;		
	}
    
    public String getToken() {
		return token;
	}
    
    public String dameEstudiante() {
    	 ClientResponse response = this.cliente.resource(API_NOTAS).path(RECURSO_ESTUDIANTE)
                 .accept(MediaType.APPLICATION_JSON)
                 .header("Authorization", PRE_TOKEN + " " + token)
                 .get(ClientResponse.class);
         return response.getEntity(String.class);
    }
    
    public String dameAsignaciones() {
    	 ClientResponse response = this.cliente.resource(API_NOTAS).path(RECURSO_ESTUDIANTE + "/" + RECURSO_TAREAS)
                 .accept(MediaType.APPLICATION_JSON)
                 .header("Authorization", PRE_TOKEN + " " + token)
                 .get(ClientResponse.class);
         //return response.getEntity(String.class);
    	 return "{\r\n" + 
			"  \"assignments\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 1,\r\n" + 
			"      \"title\": \"Primer Parcial\",\r\n" + 
			"      \"description\": null,\r\n" + 
			"      \"grades\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 1,\r\n" + 
			"          \"value\": 2,\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.526Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.526Z\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 2,\r\n" + 
			"          \"value\": \"B+\",\r\n" +
			"          \"created_at\": \"2017-03-25T13:56:07.595Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.595Z\"\r\n" + 
			"        }\r\n" + 
			"      ]\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 3,\r\n" + 
			"      \"title\": \"TPA1\",\r\n" + 
			"      \"description\": \"Primera Entrega del TP Anual\",\r\n" + 
			"      \"grades\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 4,\r\n" + 
			"          \"value\": \"B+\",\r\n" + 
			"          \"created_at\": \"2017-03-25T13:56:07.649Z\",\r\n" + 
			"          \"updated_at\": \"2017-03-25T13:56:07.649Z\"\r\n" + 
			"        }\r\n" + 
			"      ]\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}\r\n" + 
			"";
    }
}
