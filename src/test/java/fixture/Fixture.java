package fixture;

import org.mockito.Mock;

import model.estudiante.AsignacionTarea;
import model.estudiante.EnumNotaConceptual;
import model.estudiante.Estudiante;
import model.estudiante.NotaConceptual;
import model.estudiante.NotaNumerica;
import model.estudiante.Tarea;
import repositorios.RepoEstudiantes;

public class Fixture {
	
	static Fixture instancia = null;
	protected RepoEstudiantes repo;
	protected Estudiante estudiante;
	public static Fixture getInstance() {
		if(instancia==null)
			return new Fixture();
		
		return instancia;
	}
	public  Fixture() {
		
		repo = RepoEstudiantes.getInstance();

		
		estudiante = new Estudiante("Prueba", "suApellido", "lol125", 111111);
		AsignacionTarea pruebaDeIngles = new AsignacionTarea(new Tarea("Prueba de ingles"));
		pruebaDeIngles.calificar(new NotaNumerica(8));
		NotaConceptual bien = new NotaConceptual();
		bien.setNota(EnumNotaConceptual.BIEN);
		AsignacionTarea tpOperativos = new AsignacionTarea(new Tarea("TP Operativos"));
		tpOperativos.calificar(bien);
		
		AsignacionTarea pruebaDeLegislacion = new AsignacionTarea(new Tarea("Legislacion"));
		pruebaDeLegislacion.calificar(new NotaNumerica(3));
		NotaConceptual mal = new NotaConceptual();
		mal.setNota(EnumNotaConceptual.MAL);
		AsignacionTarea tpArena = new AsignacionTarea(new Tarea("TP Arena"));
		tpArena.calificar(mal);
		
		estudiante.asignarTarea(pruebaDeLegislacion);
		estudiante.asignarTarea(tpOperativos);
		estudiante.asignarTarea(pruebaDeIngles);
		estudiante.asignarTarea(tpArena);
		
		
		repo.agregarEstudiante(estudiante);
		
		
		
	}
	
}
