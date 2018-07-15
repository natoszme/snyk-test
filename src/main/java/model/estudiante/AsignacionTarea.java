package model.estudiante;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AsignacionTarea {
	private Tarea tarea;
	private List<Nota> notas = new ArrayList<>();
	
	public AsignacionTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	public void calificar(Nota nota) {
		//TODO en principio lo validamos en la ui, pero... una buena forma de hacerlo por codigo?
		//tarea.validarTipoNota(nota);
		notas.add(nota);
	}
	
	public List<Nota> getNotas() {
		return notas;
	}
	
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	public Nota getUltimaNota() {
		return notas.get(notas.size() - 1);
	}
	
	public boolean getAprobo() {
		return getUltimaNota().esAprobada();
	}
	
	public Tarea getTarea() {
		return tarea;
	}
}
