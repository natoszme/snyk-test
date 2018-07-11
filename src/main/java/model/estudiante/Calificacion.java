package model.estudiante;

import java.time.LocalDate;
import java.util.List;

public class Calificacion {
	
	private LocalDate fecha;
	private Nota nota;
	
	public Calificacion(Nota nota) {
		this.nota = nota;
		this.fecha = LocalDate.now();
	}
	
	public boolean esAprobada() {
		return nota.esAprobada();
	}

	public Nota nota() {
		return nota;
	}
}
