package ui.viewmodel;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import model.estudiante.AsignacionTarea;
import model.estudiante.Estudiante;

//TODO esta bien prescindir de este viewmode? porque la obtencion de la ultima nota (motivo por el cual estaba este view model) se hace en la asignacion tarea
@Observable
public class EstudianteViewModel {

	//en principio no se usa
	
	private Estudiante modelo;
	
	public EstudianteViewModel(Estudiante modelo) {
		this.modelo = modelo;
	}
	
	public List<AsignacionTarea> getAsignacionesTarea(){
		System.out.println("get asignaciones tarea");
		return modelo.getAsignaciones();
	}
	
	/*
	 * 
	 * .stream().
				map(asignacion -> asignacion.ultimaNota()).
				collect(Collectors.toList());
	 * */
	
	public String getNombre() {
		System.out.println("get nombre");
		return modelo.nombre;
	}

	public String getApellido() {
		return modelo.apellido;
	}

	public long getLegajo() {
		return modelo.legajo;
	}

	public String getGithubUser() {
		return modelo.githubUser;
	}
	
	public Estudiante getEstudiante() {
		return modelo;
	}
}
