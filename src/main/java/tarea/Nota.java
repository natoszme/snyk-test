package tarea;

import org.uqbar.commons.model.annotations.Observable;

//TODO por que es necesario?
@Observable
public abstract class Nota {
	public abstract boolean esAprobada();
	public abstract String getValor();
}
