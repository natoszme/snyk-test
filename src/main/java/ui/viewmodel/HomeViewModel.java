package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

import model.estudiante.Estudiante;
import repositorios.RepoEstudiantes;

@Observable
public class HomeViewModel {
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Estudiante obtenerEstudiante() {
		RepoEstudiantes repo = RepoEstudiantes.getInstance();
		return repo.obtenerEstudiantePorLegajo(legajo);
	}
}
