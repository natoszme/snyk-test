package model.estudiante;

public class Tarea {
	private String nombre;
	private boolean notaTipoNumerica;
	
	public Tarea(String nombre) {
		this.nombre = nombre;
	}

	public String nombre() {
		return nombre;
	}
	
	//TODO ver esto
	/*public void validarTipoNota(Nota nota) {
		nota.esValidaPara(notaTipoNumerica);
		throw new NotaInvalidaException();
	}*/
	
}
