package login;

import java.util.HashMap;
import java.util.Map;

import httpClientService.HttpClient;
import model.estudiante.Estudiante;
import model.repositorios.LegajoInexistenteException;
import notasService.NotasService;

public class LoginHandler {
	private Map<Integer, String> tokens = new HashMap<>();
	
	private static LoginHandler instancia;
	
	public static LoginHandler getInstance() {
		if(instancia == null) {
			instancia = new LoginHandler();
		}
		return instancia;
	}
	
	public void registrarToken(int legajo, String token) {
		tokens.put(legajo, token);
	}
	
	public Estudiante intentarLoguearA(int legajo){
		String token = obtenerToken(legajo);
		HttpClient.getInstance().setToken(token);
		
		//suponiendo que existe un estudiante en el server, por tener el token asociado
		return NotasService.dameEstudiante();
	}
	
	public String obtenerToken(int legajo) {
		if(!tokens.containsKey(legajo)) {
			throw new LegajoInexistenteException();
		}
		return tokens.get(legajo);
	}
}
