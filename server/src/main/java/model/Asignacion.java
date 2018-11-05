package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Asignacion {

	@Id @GeneratedValue
	@JsonIgnore
	private Long id;
	
	@Transient
	@JsonProperty("grades")
	private List<String> notas;	
	
	@ManyToOne
	@JsonIgnore
	private Tarea tarea;
	
	@JsonProperty("description")
	public void getTituloDescripcion() {
		tarea.getEnunciado();
	}	
	
	public Asignacion(Tarea tarea) {
		this.tarea = tarea;
		this.notas = new ArrayList<>();
	}

	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
