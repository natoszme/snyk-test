package ui.view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import login.LoginHandler;

import org.uqbar.arena.windows.ErrorsPanel;

import model.estudiante.Estudiante;
import model.repositorios.LegajoInexistenteException;
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
			System.out.println("Legajo no identificado");
			//TODO puede ser que no deje crear un label aca?
			//tampoco deja hacer esto:
			legajoInexistenteError.setText("No se reconoce el legajo");
			//supuestamente, Aena deberia cachear la siguiente excepcion pero no lo hace...
			//throw new UserException("No se reconoce el legajo");
		}
	}
	
	public static void main(String[] args) {
		LoginHandler.getInstance().registrarToken(111222333, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		
		HomeViewModel viewModel = new HomeViewModel();
		new HomeView(viewModel).startApplication();
	}
}