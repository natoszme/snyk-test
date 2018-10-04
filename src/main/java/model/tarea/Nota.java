package model.tarea;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import json.NotaJsonDeserializer;

@JsonDeserialize(using = NotaJsonDeserializer.class)
//TODO por que es necesario?
@Observable
public abstract class Nota {
	public abstract boolean esAprobada();
	public abstract String getValor();
}
