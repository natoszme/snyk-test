package notasService;


import httpClientService.HttpClient;
import json.JsonParser;
import model.estudiante.Estudiante;

public class NotasService {
	
    public static Estudiante dameEstudiante()  throws EstudianteNoIdentificadoException{
    	Estudiante estudianteConPerfil = obtenerPerfilEstudiante();
    	
    	if(estudianteConPerfil.getLegajo() == 0) {
			throw new EstudianteNoIdentificadoException();
		}    	
    	
    	Estudiante estudianteConAsignaciones = obtenerEstudianteConAsignaciones();
    	estudianteConPerfil.setAsignaciones(estudianteConAsignaciones.getAsignaciones());
    	return estudianteConPerfil;
    }

	private static Estudiante obtenerPerfilEstudiante() {
		return JsonParser.deserializarEstudiante(HttpClient.getInstance().dameEstudiante());		
	}

	private static Estudiante obtenerEstudianteConAsignaciones() {
		return JsonParser.deserializarAsignaciones(HttpClient.getInstance().dameAsignaciones());
	}

	public static void actualizarPerfil(Estudiante modelo) {
		System.out.println(JsonParser.serializarEstudiante(modelo));
		HttpClient.getInstance().actualizarPerfilEstudiante(JsonParser.serializarEstudiante(modelo));		
	}
}
