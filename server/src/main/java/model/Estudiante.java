package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonPropertyOrder({ "code", "first_name", "last_name", "github_user" })
@JsonInclude(Include.NON_NULL)
public class Estudiante {

	@Id @GeneratedValue
	@JsonIgnore
	private Long id;
	
	@JsonProperty("code")
	private String legajo;
	
	@JsonProperty("first_name")
	private String nombre;
	
	@JsonProperty("last_name")
	private String apellido;
	
	@JsonIgnore
	private String secretCode;
	
	@JsonIgnore
	private String email;
	
	@JsonProperty("github_user")
	private String githubUser;
	
	@OneToMany
	@JoinColumn(name = "alumno_id")
	@JsonProperty(access = Access.READ_ONLY, value = "assignments")
	private List<Asignacion> asignaciones = new ArrayList<>();
	
	@SuppressWarnings("unused")
	public Estudiante() {}
	
	public Estudiante(String legajo, String nombre, String apellido, String email, String githubUser) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.email = email;
		this.githubUser = githubUser;
		this.apellido = apellido;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
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

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void actualizarDatos(Estudiante estudiante) {
		nombre = estudiante.getNombre();
		apellido = estudiante.getApellido();
		legajo = estudiante.getLegajo();
		githubUser = estudiante.getGithubUser();
	}

	public void agregarAsignacion(Asignacion asignacion) {
		asignaciones.add(asignacion);		
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public long getId() {
		return id;
	}

}
