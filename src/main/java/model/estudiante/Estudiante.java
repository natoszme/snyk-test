package model.estudiante;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Estudiante {
	private String nombre;
	private String apellido;
	private String githubUser;
	private long legajo;
	private List<AsignacionTarea> asignaciones = new ArrayList<>();
}
