package model.tarea;

public class NotaConceptual extends Nota{
	
	private EnumNotaConceptual nota;
	
	public NotaConceptual(EnumNotaConceptual notaConceptual) {
		nota = notaConceptual;
	}
	
	public NotaConceptual(String notaConceptual) {
		nota = EnumNotaConceptual.dameEquivalente(notaConceptual);
	}

	public boolean esAprobada() {
		return nota != EnumNotaConceptual.MAL;
	}
	
	//TODO esto es bastante feo
	public boolean esValidaPara(boolean esTipoNumerica) {
		return esTipoNumerica == true;
	}
	
	public EnumNotaConceptual valor() {
		return nota;
	}
	
	public String getValor() {
		return nota.name().toLowerCase();
	}
	
	public void setNota(EnumNotaConceptual nota) {
		this.nota = nota;
	}
	
}
