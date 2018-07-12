package viewModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;


import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.uqbar.arena.windows.WindowOwner;

import fixture.Fixture;
import model.estudiante.Estudiante;
import repositorios.RepoEstudiantes;

public class TestHomeViewModel extends Fixture {	
	
	@Test
	public void ElLegajo111111TraeAlEstudianteConNombrePrueba() {
		assertEquals("Prueba",repo.obtenerEstudiantePorLegajo(111111).getNombre());
	}
	
	@Test (expected = repositorios.LegajoInexistenteException.class)
	public void ElLegajo2345TiraErrorSiIntentoTraerEstudiante() {
		repo.obtenerEstudiantePorLegajo(2345);
	}
	
	
			
			
}