package model.estudiante;

import java.util.ArrayList;
import java.util.List;

public class AsignacionTarea {
	private Tarea tarea;
	private List<Calificacion> calificaciones = new ArrayList<>();
	
	public void calificar(Nota nota) {
		//TODO en principio lo validamos en la ui, pero... una buena forma de hacerlo por codigo?
		//tarea.validarTipoNota(nota);
		calificaciones.add(new Calificacion(nota));
	}
	
	public boolean aprobo() {
		return calificaciones.stream().anyMatch(Calificacion::esAprobada);
	}
}
