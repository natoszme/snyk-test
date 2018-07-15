package ui.view;

import org.apache.commons.collections15.Transformer;

import model.tarea.Tarea;

public class NombreTareaToStringTransformer implements Transformer<Tarea, String> {

	@Override
	public String transform(Tarea tarea) {
		return tarea.nombre();
	}

}
