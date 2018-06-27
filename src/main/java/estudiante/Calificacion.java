package estudiante;

import java.time.LocalDate;

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
}
