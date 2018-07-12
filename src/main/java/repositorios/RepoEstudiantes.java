package repositorios;

import java.util.ArrayList;

import model.estudiante.Estudiante;


public class RepoEstudiantes {
	
	private static RepoEstudiantes instancia;
	
	protected ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public static RepoEstudiantes getInstance() {
		if (instancia == null) {
			instancia = new RepoEstudiantes();
		}
		return instancia;
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	
	public Estudiante obtenerEstudiantePorLegajo(int legajo) {
		return estudiantes.stream()
				.filter(estudiante->estudiante.getLegajo() == legajo)
				.findFirst()
				.orElseThrow(() -> new LegajoInexistenteException());
	}
	
}
