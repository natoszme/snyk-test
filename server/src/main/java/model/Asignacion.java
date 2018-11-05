package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import json.NotaJsonSerializer;

@Entity
@JsonPropertyOrder({ "title", "description", "grades" })
public class Asignacion {

	@Id @GeneratedValue
	@JsonIgnore
	private Long id;
	
	@ElementCollection
	@JsonProperty("grades")
	@JsonSerialize(using = NotaJsonSerializer.class)
	private List<String> notas;	
	
	@ManyToOne
	@JsonIgnore
	private Tarea tarea;
	
	@JsonProperty("description")
	public String getDescripcionTarea() {
		return tarea.getEnunciado();
	}
	
	@JsonProperty("title")
	public String getTituloTarea() {
		return tarea.getNombre();
	}
	
	public Asignacion(Tarea tarea) {
		this.tarea = tarea;
		this.notas = new ArrayList<>();
	}
	
	public Asignacion() {}

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
