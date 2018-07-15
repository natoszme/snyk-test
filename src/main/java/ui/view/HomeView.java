package ui.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.exceptions.UserException;

import fixture.Fixture;

import org.uqbar.arena.windows.ErrorsPanel;

import model.estudiante.Estudiante;
import model.repositorios.LegajoInexistenteException;
import model.repositorios.RepoEstudiantes;
import model.tarea.AsignacionTarea;
import model.tarea.EnumNotaConceptual;
import model.tarea.NotaConceptual;
import model.tarea.NotaNumerica;
import model.tarea.Tarea;
import ui.viewmodel.HomeViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class HomeView extends MainWindow<HomeViewModel>{
	
	private Label legajoInexistenteError;
	
	public HomeView(HomeViewModel homeViewModel) {
		super(homeViewModel);
	}

	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Home");
		mainPanel.setLayout(new VerticalLayout());
		
		new ErrorsPanel(mainPanel, "", 1);
		
		new Label(mainPanel).setText("Legajo");
		
		new TextBox(mainPanel).bindValueToProperty("legajo");
		
		legajoInexistenteError = new Label(mainPanel).setText(" ");
		
		//TODO por que funciona con los '::'? (cuando no se pasaba ningun parametro)
		new Button(mainPanel).setCaption("Ingresar").onClick(this::intentarAbrirEstudianteView);
		
		new Button(mainPanel).setCaption("Salir").onClick(this::close);
	}
	
	private void intentarAbrirEstudianteView() {
		try{
			Estudiante estudianteLogueado = getModelObject().obtenerEstudiante();
			this.close();
			new EstudianteView(this, estudianteLogueado).open();
		}
		catch(LegajoInexistenteException e){
			System.out.println("Tiro la excepcion de legajo");
			//TODO puede ser que no deje crear un label aca?
			//tampoco deja hacer esto:
			legajoInexistenteError.setText("No se reconoce el legajo");
			throw new UserException("No se reconoce el legajo");	
		}
	}
	
	public static void main(String[] args) {
		Estudiante estudiante;
		AsignacionTarea pruebaDeIngles;
		AsignacionTarea tpOperativos;
		AsignacionTarea tpArena;
		NotaConceptual mal;
		NotaConceptual bien;
		
		RepoEstudiantes repo = RepoEstudiantes.getInstance();
		
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
		
		HomeViewModel viewModel = new HomeViewModel();
		new HomeView(viewModel).startApplication();
	}
}