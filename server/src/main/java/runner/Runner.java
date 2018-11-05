package runner;

import fixture.DatosDePrueba;
import router.Router;
import spark.Spark;
import spark.debug.DebugScreen;

public class Runner {
	public static void main(String[] args) {
		Spark.port(9500);
		DebugScreen.enableDebugScreen();
		
		new DatosDePrueba().configurar();
		new Router().configure();
	}
}
