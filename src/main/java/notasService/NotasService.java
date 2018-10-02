package notasService;


import httpClientService.HttpClient;
import json.JsonDeserializer;
import model.estudiante.Estudiante;

public class NotasService {
	
    public Estudiante dameEstudiante() {
    	Estudiante estudianteConPerfil = obtenerPerfilEstudiante();
    	Estudiante estudianteConAsignaciones = obtenerEstudianteConAsignaciones();
    	estudianteConPerfil.setAsignaciones(estudianteConAsignaciones.getAsignaciones());
    	return estudianteConPerfil;
    }

	private Estudiante obtenerPerfilEstudiante() {
		return JsonDeserializer.deserializarEstudiante(HttpClient.getInstance().dameEstudiante());
	}

	private Estudiante obtenerEstudianteConAsignaciones() {
		return JsonDeserializer.deserializarAsignaciones(HttpClient.getInstance().dameAsignaciones());
	}
}
