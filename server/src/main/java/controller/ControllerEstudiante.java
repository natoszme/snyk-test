package controller;

import security.SecurityService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ControllerEstudiante {

	public static Route obtenerEstudiante(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Route obtenerAsignacionesEstudiante(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Route actualizarDatosEstudiante(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void autenticarAlumno(Request req, Response res) {
		String token = req.headers("Authorization").replace("Bearer ", "");
		Long id = SecurityService.user(token);
		
		res.cookie("idAlumno", id.toString());		
	}

}
