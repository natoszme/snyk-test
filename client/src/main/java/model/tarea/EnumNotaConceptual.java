package model.tarea;

public enum EnumNotaConceptual {
	MAL, REGULAR_MENOS, REGULAR_MAS, BIEN_MENOS, BIEN, BIEN_MAS;

	//TODO esto tambien quedo feo
	public static EnumNotaConceptual dameEquivalente(String notaConceptual) {
		
		if(notaConceptual.equals("M")) {
			return EnumNotaConceptual.MAL;
		}
		
		if(notaConceptual.equals("R-")) {
			return  EnumNotaConceptual.REGULAR_MENOS;
		}
		
		if(notaConceptual.equals("R+")) {
			return EnumNotaConceptual.REGULAR_MAS;
		}
		
		if(notaConceptual.equals("B-")) {
			return  EnumNotaConceptual.BIEN_MENOS;
		}
		
		if(notaConceptual.equals("B")) {
			return EnumNotaConceptual.BIEN;
		}
		
		if(notaConceptual.equals("B+")) {
			return  EnumNotaConceptual.BIEN_MAS;
		}
		
		return null;
	}
}
