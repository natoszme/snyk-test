package estudiante;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Estudiante {
	public String nombre;
	public String apellido;
	public String githubUser;
	public long legajo;
	public List<AsignacionTarea> asignaciones = new ArrayList<>();
}
