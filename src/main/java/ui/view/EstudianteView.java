package ui.view;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tree.Tree;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;

import model.estudiante.Calificacion;
import model.estudiante.Estudiante;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends MainWindow<Estudiante>{

	public EstudianteView(Estudiante estudiante) {
		//TODO revisar esto, no hay viewModel
		super(estudiante);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Estudiante");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel perfilAlumnoPanel = new Panel(mainPanel).setLayout(new ColumnLayout(2));	
		Panel datosAlumnoPanel = new Panel(perfilAlumnoPanel).setLayout(new VerticalLayout());
		
		Panel panelNombre = new Panel(datosAlumnoPanel).setLayout(new HorizontalLayout());
		new Label(panelNombre).setText("Nombre: ");
		new Label(panelNombre).bindValueToProperty("nombre");
		
		Panel apeliidoPanel = new Panel(datosAlumnoPanel).setLayout(new HorizontalLayout());
		new Label(apeliidoPanel).setText("Apellido: ");
		new Label(apeliidoPanel).bindValueToProperty("apellido");
		
		Panel legajoPanel = new Panel(datosAlumnoPanel).setLayout(new HorizontalLayout());
		new Label(legajoPanel).setText("Legajo: ");
		new Label(legajoPanel).bindValueToProperty("legajo");
		
		Panel githubPanel = new Panel(datosAlumnoPanel).setLayout(new HorizontalLayout());
		new Label(githubPanel).setText("Github user: ");
		new Label(githubPanel).bindValueToProperty("githubUser");
		
		//TODO por algun motivo dejo de tomar este panel
		//Panel modificarDatosPanel = new Panel(perfilAlumnoPanel);
		new Button(mainPanel).setCaption("Modificar datos").onClick(this::modificarEstudiante);
		
		new Label(mainPanel).setText("Calificaciones");
		new Tree<Calificacion>(mainPanel).bindNodeToProperty("calificaciones");
		
		new Button(mainPanel).setCaption("Salir").onClick(this::close);
	}
	
	private void modificarEstudiante() {
		//TODO revisar si se puede evitar mandar el modelObject
		//TODO esta bien instanciado el ModificarEstudianteView? Es correcto instanciar el viewModel dede aca?
		Dialog<?> dialog = new ModificarEstudianteView(this, new ModificarEstudianteViewModel(getModelObject()));
		//en principio el accept no hace falta
		//dialog.onAccept(action);
		dialog.open();
	}

	//TODO vista intermedia que mande al estudiante a la vista actual
	public static void main(String[] args) {
		new EstudianteView(new Estudiante("unAlumno", "suApellido", "lol125", 115235)).startApplication();
	}

}
