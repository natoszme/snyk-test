package estudiante;

public class NotaConceptual implements Nota{
	private EnumNotaConceptual nota;
	
	public boolean esAprobada() {
		return nota == EnumNotaConceptual.BIEN_MENOS || nota == EnumNotaConceptual.BIEN;
	}
	
	//TODO esto es bastante feo
	public boolean esValidaPara(boolean esTipoNumerica) {
		return esTipoNumerica == true;
	}
}
