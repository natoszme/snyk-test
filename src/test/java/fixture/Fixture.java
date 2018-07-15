package fixture;

import model.estudiante.Estudiante;
import model.repositorios.RepoEstudiantes;
import tarea.AsignacionTarea;
import tarea.EnumNotaConceptual;
import tarea.NotaConceptual;
import tarea.NotaNumerica;
import tarea.Tarea;

public class Fixture {
	
	static Fixture instancia = null;
	protected RepoEstudiantes repo;
	protected Estudiante estudiante;
	protected AsignacionTarea pruebaDeIngles;
	protected AsignacionTarea tpOperativos;
	protected AsignacionTarea tpArena;
	protected NotaConceptual mal;
	protected NotaConceptual bien;
	
	public static Fixture getInstance() {
		if(instancia==null)
			return new Fixture();
		
		return instancia;
	}
	public Fixture() {
		fixture();
	}
	
	public void fixture() {
		repo = RepoEstudiantes.getInstance();
		
		estudiante = new Estudiante("Pepe", "Sanchez", "pepeCapo123", 111111);
		pruebaDeIngles = new AsignacionTarea(new Tarea("Prueba de ingles"));
		pruebaDeIngles.calificar(new NotaNumerica(8));
		bien = new NotaConceptual();
		bien.setNota(EnumNotaConceptual.BIEN);
	    tpOperativos = new AsignacionTarea(new Tarea("TP Operativos"));
		tpOperativos.calificar(bien);
		
		AsignacionTarea pruebaDeLegislacion = new AsignacionTarea(new Tarea("Legislacion"));
		pruebaDeLegislacion.calificar(new NotaNumerica(3));
	    mal = new NotaConceptual();
		mal.setNota(EnumNotaConceptual.MAL);
	    tpArena = new AsignacionTarea(new Tarea("TP Arena"));
		tpArena.calificar(mal);
		
		estudiante.asignarTarea(pruebaDeLegislacion);
		estudiante.asignarTarea(tpOperativos);
		estudiante.asignarTarea(pruebaDeIngles);
		estudiante.asignarTarea(tpArena);		
		
		repo.agregarEstudiante(estudiante);
	}
	
}
