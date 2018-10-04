package ui.view;

import org.apache.commons.collections15.Transformer;

import model.tarea.Nota;

public class NotaToStringTransformer implements Transformer<Nota, String> {

	@Override
	public String transform(Nota nota) {
		if(nota == null) {
			return "N/D";
		}
		return nota.getValor();
	}
}
