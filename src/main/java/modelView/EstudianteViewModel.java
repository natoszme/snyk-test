package modelView;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import estudiante.Calificacion;
import estudiante.Estudiante;
import estudiante.NotaNumerica;

@Observable
public class EstudianteViewModel extends Estudiante {

	private Estudiante modelo;
	
	List<Calificacion> calificaciones = new ArrayList<>();
	
	public EstudianteViewModel(Estudiante modelo) {
		this.modelo = modelo;
		calificaciones.add(new Calificacion(new NotaNumerica(7)));
	}
	
}
