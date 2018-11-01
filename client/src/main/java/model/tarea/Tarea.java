package model.tarea;


public class Tarea {
	private String nombre;
	
	private String descripcion;
	
	private boolean notaTipoNumerica;
	
	public Tarea(String nombre) {
		this.nombre = nombre;
	}
	
	public Tarea() {}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	//TODO ver esto
	/*public void validarTipoNota(Nota nota) {
		nota.esValidaPara(notaTipoNumerica);
		throw new NotaInvalidaException();
	}*/
	
}
