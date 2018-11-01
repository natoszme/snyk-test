package login;

import org.junit.Test;

import fixture.Fixture;
import login.LoginHandler;

public class TestLogin extends Fixture {
	
	@Test (expected = model.repositorios.LegajoInexistenteException.class)
	public void ElLegajo12345TiraErrorSiIntentoTraerEstudiante() {
		LoginHandler.getInstance().intentarLoguearA(12345);
	}
	
	//TODO test de integracion para ver que se traiga bien al estudiante
			
}