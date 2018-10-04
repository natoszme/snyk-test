package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

import json.JsonParser;
import model.estudiante.Estudiante;
import notasService.NotasService;

@Observable
public class ModificarEstudianteViewModel {
	private String nombre;
	private String apellido;
	private long legajo;
	private String githubUser;
	private Estudiante modelo;
	
	//TODO se puede evitar la asignacion default? extendiendo a estudiante?
	public ModificarEstudianteViewModel(Estudiante estudiante) {
		modelo = estudiante;
		nombre = modelo.getNombre();
		apellido = modelo.getApellido();
		githubUser = modelo.getGithubUser();
		legajo = modelo.getLegajo();
	}
	
	//TODO revisar esto
	public void actualizarDatosEstudiante() {
		modelo.actualizarDatos(nombre, apellido, githubUser, legajo);
		//System.out.println(JsonParser.serializarEstudiante(new Estudiante("a", "a", "a", 11)));
		//System.out.println(JsonParser.serializarEstudiante(modelo));
		Estudiante estudianteSinDecorar = new Estudiante(modelo.getNombre(), modelo.getApellido(), modelo.getGithubUser(), modelo.getLegajo());
		NotasService.actualizarPerfil(estudianteSinDecorar);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
}
