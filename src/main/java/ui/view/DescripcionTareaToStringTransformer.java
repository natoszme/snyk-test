package ui.view;

import org.apache.commons.collections15.Transformer;

import model.tarea.Tarea;

public class DescripcionTareaToStringTransformer implements Transformer<Tarea, String>{
	@Override
	public String transform(Tarea tarea) {
		return tarea.getDescripcion();
	}
}
