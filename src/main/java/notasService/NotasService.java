package notasService;


import httpClientService.HttpClient;
import json.JsonDeserializerCustom;
import model.estudiante.Estudiante;

public class NotasService {
	
    public Estudiante dameEstudiante() {
    	Estudiante estudianteConPerfil = obtenerPerfilEstudiante();
    	Estudiante estudianteConAsignaciones = obtenerEstudianteConAsignaciones();
    	estudianteConPerfil.setAsignaciones(estudianteConAsignaciones.getAsignaciones());
    	return estudianteConPerfil;
    }

	private Estudiante obtenerPerfilEstudiante() {
		return JsonDeserializerCustom.deserializarEstudiante(HttpClient.getInstance().dameEstudiante());
	}

	private Estudiante obtenerEstudianteConAsignaciones() {
		return JsonDeserializerCustom.deserializarAsignaciones(HttpClient.getInstance().dameAsignaciones());
	}
}
