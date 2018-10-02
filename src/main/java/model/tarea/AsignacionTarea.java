package model.tarea;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Observable
public class AsignacionTarea {	
	@JsonIgnore
	private Tarea tarea = new Tarea();
	
	@JsonProperty("grades")
	private List<Nota> notas = new ArrayList<>();
	
	//TODO revisar, queda acoplado
	@JsonProperty("title")
	public void setTituloTarea(String nombre) {
		tarea.setNombre(nombre);
	}
	
	@JsonProperty("description")
	public void setTituloDescripcion(String descripcion) {
		tarea.setDescripcion(descripcion);
	}
	
	public AsignacionTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	public AsignacionTarea() {}
	
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
		if(notas.size() == 0) {
			return null;
		}
		return notas.get(notas.size() - 1);
	}
	
	public boolean getAprobo() {
		return getUltimaNota().esAprobada();
	}
	
	public Tarea getTarea() {
		return tarea;
	}
}
