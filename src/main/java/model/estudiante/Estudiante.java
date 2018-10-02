package model.estudiante;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;

import model.tarea.AsignacionTarea;

@Observable
public class Estudiante {
	@JsonProperty("first_name")
	public String nombre;
	
	@JsonProperty("last_name")
	public String apellido;
	
	@JsonProperty("github_user")
	public String githubUser;
	
	@JsonProperty("code")
	public long legajo;
	
	private List<AsignacionTarea> asignaciones = new ArrayList<>();
	
	public Estudiante(String nombre, String apellido, String githubUser, long legajo) {
		actualizarDatos(nombre, apellido, githubUser, legajo);	
	}
	
	public Estudiante() {}
	
	public List<AsignacionTarea> getAsignaciones(){
		return asignaciones;
	}
	
	//TODO sin esto rompe: por que?
	public void setAsignaciones(List<AsignacionTarea> asignaciones){
		this.asignaciones = asignaciones;
	}
	
	public void asignarTarea(AsignacionTarea asignacion) {
		asignaciones.add(asignacion);
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

	public void actualizarDatos(String nombre, String apellido, String githubUser, long legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.githubUser = githubUser;
		this.legajo = legajo;		
	}
}
