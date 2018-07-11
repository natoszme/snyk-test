package ui.view;

import org.uqbar.commons.model.annotations.Observable;

import model.estudiante.Estudiante;

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
		nombre = modelo.nombre;
		apellido = modelo.apellido;
		legajo = modelo.legajo;
		githubUser = modelo.githubUser;
	}
	
	//TODO revisar esto
	public void actualizarDatosEstudiante() {
		modelo.nombre = nombre;
		modelo.apellido = apellido;
		modelo.legajo = legajo;
		modelo.githubUser = githubUser;
	}

	public String getNombre() {
		return modelo.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return modelo.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public long getLegajo() {
		return modelo.legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getGithubUser() {
		return modelo.githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
}
