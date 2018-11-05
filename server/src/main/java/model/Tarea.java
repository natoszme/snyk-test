package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Tarea {
	
	@JsonIgnore
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;

	private Date fechaLimiteDeEntrega;
	
	@JsonProperty("title")
	private String enunciado;
	
	public Tarea(String nombre, String enunciado, Date fechaLimiteDeEntrega) {
		super();
		this.fechaLimiteDeEntrega = fechaLimiteDeEntrega;
		this.enunciado = enunciado;
		this.nombre = nombre;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Date getFechaLimiteDeEntrega() {
		return fechaLimiteDeEntrega;
	}

	public void setFechaLimiteDeEntrega(Date fechaLimiteDeEntrega) {
		this.fechaLimiteDeEntrega = fechaLimiteDeEntrega;
	}
	
	public String getNombre() {
		return nombre;
	}

}
