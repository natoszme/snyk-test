package ui.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import estudiante.Calificacion;
import estudiante.Estudiante;
import estudiante.NotaNumerica;

@Observable
public class EstudianteViewModel extends Estudiante {

	private Estudiante modelo;
	private String nombre;
	private String apellido;
	private long legajo;
	private String githubUser;
	
	private List<Calificacion> calificaciones = new ArrayList<>();
	
	public void actualizarDatosEstudiante() {
		/*modelo.nombre = nombre;
		modelo.apellido = apellido;
		modelo.legajo = legajo;
		modelo.githubUser = githubUser;*/
	}
	
	public EstudianteViewModel(Estudiante modelo) {
		//TODO reveer esto
		super("", "", "", 0);
		this.modelo = modelo;
	}
	
	public String getNombre() {
		return this.nombre;
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
