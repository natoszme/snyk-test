package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

import login.LoginHandler;
import model.estudiante.Estudiante;

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
		return LoginHandler.getInstance().intentarLoguearA(legajo);
	}
}
