package model.tarea;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import json.NotaJsonDeserializer;

@JsonDeserialize(using = NotaJsonDeserializer.class)
public abstract class Nota {
	public abstract boolean esAprobada();
	public abstract String getValor();
}
