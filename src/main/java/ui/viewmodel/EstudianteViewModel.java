package ui.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.model.annotations.Observable;

import model.estudiante.Calificacion;
import model.estudiante.Estudiante;
import model.estudiante.Nota;
import model.estudiante.NotaNumerica;

@Observable
public class EstudianteViewModel {

	//en principio no se usa
	
	private Estudiante modelo;
	private String nombre;
	private String apellido;
	private long legajo;
	private String githubUser;
	
	//private List<Calificacion> calificaciones = new ArrayList<>();
	
	public EstudianteViewModel(Estudiante modelo) {
		this.modelo = modelo;
	}
	
	private List<Nota> obtenerUltimasNotas(){
		return modelo.getAsignaciones().stream().
				map(asignacion -> asignacion.ultimaNota()).
				collect(Collectors.toList());
	}
	
	public String getNombre() {
		System.out.println("get nombre");
		return modelo.nombre;
	}

	public void setNombre(String nombre) {
		System.out.println("set nombre");
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
	
	public List<Nota> getUltimasNotas(){
		return obtenerUltimasNotas();
	}
	
	public Estudiante getEstudiante() {
		return modelo;
	}
}
