package ui.viewmodel;

import org.uqbar.commons.model.annotations.Observable;

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
	
	//TODO revisar esto. aparentemente esta ok porque arena crea una subclase de estudiante y este estudiante es de esa clase. Podriamos crear una
	//intermedia para pasarle a arena, y nosotros quedarnos con el estudiante posta.
	//El tema es que esta asignacion al estudiante posta tambien tendriamos que hacerla con ese modelo...
	public void actualizarDatosEstudiante() {
		modelo.actualizarDatos(nombre, apellido, githubUser, legajo);
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
