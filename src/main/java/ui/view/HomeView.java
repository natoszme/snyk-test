package ui.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import model.estudiante.AsignacionTarea;
import model.estudiante.EnumNotaConceptual;
import model.estudiante.Estudiante;
import model.estudiante.NotaConceptual;
import model.estudiante.NotaNumerica;
import model.estudiante.Tarea;
import repositorios.RepoEstudiantes;
import ui.viewmodel.HomeViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class HomeView extends MainWindow<HomeViewModel>{
	
	public HomeView(HomeViewModel homeViewModel) {
		super(homeViewModel);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Home");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Legajo");
		
		new TextBox(mainPanel).bindValueToProperty("legajo");
		
		new Label(mainPanel).setText("");
		
		//TODO por que funciona con los '::'? (cuando no se pasaba ningun parametro)
		new Button(mainPanel).setCaption("Ingresar").onClick(() -> {getModelObject().ingresarSiPuede(this);});
		
		new Button(mainPanel).setCaption("Salir").onClick(this::close);
	}
	
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("unAlumno", "suApellido", "lol125", 111111);
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
		
		RepoEstudiantes repo = RepoEstudiantes.getInstance();
		repo.agregarEstudiante(estudiante);
		
		HomeViewModel viewModel = new HomeViewModel();
		new HomeView(viewModel).startApplication();
	}
}