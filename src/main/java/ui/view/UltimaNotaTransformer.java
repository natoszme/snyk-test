package ui.view;

import org.apache.commons.collections15.Transformer;

import model.estudiante.Nota;

public class UltimaNotaTransformer implements Transformer<Nota, String> {

	@Override
	public String transform(Nota nota) {
		return nota.getValor();
	}
}
