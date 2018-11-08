package controller;

import json.JsonParser;
import model.Estudiante;
import model.RepoEstudiantes;
import security.SecurityService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ControllerEstudiante {
	
	private static String nombreIdSession = "idEstudiante";
	
	public static void autenticarAlumno(Request req, Response res) {
		String token = req.headers("Authorization").replace("Bearer ", "");
		
		long id = SecurityService.user(token);
		
		req.session().attribute(nombreIdSession, id);
	}
	
	private static long idEstudiante(Request req) {
		return req.session().attribute(nombreIdSession);
	}
	
	public static void limpiarSession(Request req) {
		req.session().removeAttribute(nombreIdSession);
	}
	
	private static Estudiante obtenerEstudianteDeRepo(Request req) {
		return RepoEstudiantes.getInstance().estudiante(idEstudiante(req));
	}

	public static Estudiante obtenerEstudiante(Request req, Response res) {
		return obtenerEstudianteDeRepo(req);
	}

	public static Estudiante obtenerAsignacionesEstudiante(Request req, Response res) {
		return RepoEstudiantes.getInstance().estudiante(idEstudiante(req));
	}
	
	public static Route actualizarDatosEstudiante(Request req, Response res) {
		Estudiante estudiante = JsonParser.obtenerEstudianteDeJson(req.body());
		obtenerEstudianteDeRepo(req).actualizarDatos(estudiante);
		return null;
	}

}
