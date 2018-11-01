package runner;

import router.Router;
import spark.Spark;
import spark.debug.DebugScreen;

public class Runner {
	public static void main(String[] args) {
		Spark.port(9500);
		DebugScreen.enableDebugScreen();
		new Router().configure();
	}
}
