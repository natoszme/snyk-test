package asignacionTarea;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fixture.Fixture;
import model.estudiante.NotaNumerica;

public class TestAsignacionTarea extends Fixture {
	@Test
	public void pruebaDeInglesEstaAprobada() {
		assertTrue(pruebaDeIngles.aprobo());
	}
	@Test
	public void pruebaDeInglesEstaDesprobadaSiCalificaUn3() {
		pruebaDeIngles.calificar(new NotaNumerica(3));
		assertFalse(pruebaDeIngles.aprobo());
	}
	
	@Test
	public void tpArenaEstaDesaprobada() {
		assertFalse(tpArena.aprobo());
	}
	@Test
	public void tpArenaEstaAprobadaDespuesDeCalificarBien() {
		tpArena.calificar(bien);
		assertTrue(tpArena.aprobo());
	}
	
}
