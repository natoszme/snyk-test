package fixture;

import model.estudiante.Estudiante;
import model.tarea.AsignacionTarea;
import model.tarea.EnumNotaConceptual;
import model.tarea.NotaConceptual;
import model.tarea.NotaNumerica;
import model.tarea.Tarea;

public abstract class Fixture {
	
	protected Estudiante estudiante;
	protected AsignacionTarea pruebaDeIngles;
	protected AsignacionTarea tpOperativos;
	protected AsignacionTarea tpArena;
	protected NotaConceptual mal;
	protected NotaConceptual bien;
	
	public Fixture() {		
		estudiante = new Estudiante("Pepe", "Sanchez", "pepeCapo123", 111111);
		pruebaDeIngles = new AsignacionTarea(new Tarea("Prueba de ingles"));
		pruebaDeIngles.calificar(new NotaNumerica(8));
		bien = new NotaConceptual(EnumNotaConceptual.BIEN);
	    tpOperativos = new AsignacionTarea(new Tarea("TP Operativos"));
		tpOperativos.calificar(bien);
		
		AsignacionTarea pruebaDeLegislacion = new AsignacionTarea(new Tarea("Legislacion"));
		pruebaDeLegislacion.calificar(new NotaNumerica(3));
	    mal = new NotaConceptual(EnumNotaConceptual.MAL);
	    tpArena = new AsignacionTarea(new Tarea("TP Arena"));
		tpArena.calificar(mal);
		
		estudiante.asignarTarea(pruebaDeLegislacion);
		estudiante.asignarTarea(tpOperativos);
		estudiante.asignarTarea(pruebaDeIngles);
		estudiante.asignarTarea(tpArena);
	}
	
}
