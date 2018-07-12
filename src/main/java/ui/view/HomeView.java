package ui.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import fixture.Fixture;
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
		Fixture.getInstance();
		
		HomeViewModel viewModel = new HomeViewModel();
		new HomeView(viewModel).startApplication();
	}
}