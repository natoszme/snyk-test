package model.tarea;

public enum EnumNotaConceptual {
	MAL, REGULAR_MENOS, REGULAR_MAS, BIEN_MENOS, BIEN, BIEN_MAS;

	//TODO esto tambien quedo feo
	public static EnumNotaConceptual dameEquivalente(String notaConceptual) {
		if(notaConceptual.equals("B+")) {
			return EnumNotaConceptual.BIEN_MAS;
		}
		
		if(notaConceptual.equals("B-")) {
			return  EnumNotaConceptual.BIEN_MENOS;
		}
		
		return null;
	}
}
