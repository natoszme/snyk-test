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

	public static String obtenerEstudiante(Request req, Response res) {
		Estudiante estudiante = RepoEstudiantes.getInstance().estudiante(idEstudiante(req));
		return JsonParser.obtenerJsonEstudiante(estudiante);
	}

	public static String obtenerAsignacionesEstudiante(Request req, Response res) {
		Estudiante estudiante = RepoEstudiantes.getInstance().estudiante(idEstudiante(req));		
		return JsonParser.obtenerJsonAsignaciones(estudiante);
	}
	
	public static Route actualizarDatosEstudiante(Request req, Response res) {
		Estudiante estudiante = JsonParser.obtenerEstudianteDeJson(req.body());
		estudiante.actualizarDatos(estudiante);
		return null;
	}

}
