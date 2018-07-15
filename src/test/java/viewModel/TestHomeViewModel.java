package viewModel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fixture.Fixture;

public class TestHomeViewModel extends Fixture {	
	
	@Test
	public void ElLegajo111111TraeAlEstudianteConNombrePrueba() {
		assertEquals("Pepe", repo.obtenerEstudiantePorLegajo(111111).getNombre());
	}
	
	@Test (expected = model.repositorios.LegajoInexistenteException.class)
	public void ElLegajo2345TiraErrorSiIntentoTraerEstudiante() {
		repo.obtenerEstudiantePorLegajo(2345);
	}
			
}