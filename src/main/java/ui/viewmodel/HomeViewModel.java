package ui.viewmodel;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.exceptions.UserException;

import model.estudiante.Estudiante;
import model.estudiante.LegajoInexistenteException;
import repositorios.RepoEstudiantes;
import ui.view.EstudianteView;

@Observable
public class HomeViewModel {
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public void ingresarSiPuede(WindowOwner homeView) {
		RepoEstudiantes repo = RepoEstudiantes.getInstance();
		try{
			Estudiante estudiante = repo.obtenerEstudiantePorLegajo(this.getLegajo());
			loginEstudiante(homeView, estudiante);
		}catch(LegajoInexistenteException e) {
			throw new UserException("Legajo inexistente");
		}
	}	 
	
	//TODO chequear esto: se puede evitar el homeView?
	private void loginEstudiante(WindowOwner homeView, Estudiante estudiante) {
		new EstudianteView(homeView, estudiante).open();
		//TODO por alguno motivo no se puede hacer el close aca...
		//homeView.close();
	}
}
