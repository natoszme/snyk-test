package tarea;

public class NotaConceptual extends Nota{
	private EnumNotaConceptual nota;
	
	public boolean esAprobada() {
		return nota != EnumNotaConceptual.MAL;
	}
	
	//TODO esto es bastante feo
	public boolean esValidaPara(boolean esTipoNumerica) {
		return esTipoNumerica == true;
	}
	
	public String getValor() {
		return nota.name().toLowerCase();
	}
	
	public void setNota(EnumNotaConceptual nota) {
		this.nota = nota;
	}
	
}
