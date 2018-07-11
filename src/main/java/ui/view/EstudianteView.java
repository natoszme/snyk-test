package ui.view;

import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.utils.ObservableUtils;

import model.estudiante.AsignacionTarea;
import model.estudiante.Estudiante;
import model.estudiante.Nota;
import model.estudiante.NotaNumerica;
import model.estudiante.Tarea;
import ui.viewmodel.EstudianteViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends MainWindow<EstudianteViewModel>{

	public EstudianteView(EstudianteViewModel estudianteViewModel) {
		super(estudianteViewModel);
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
		new Table<Nota>(mainPanel, Nota.class).
			bindItemsToProperty("ultimasNotas").
			setAdapter(new PropertyAdapter(NotaNumerica.class, "valor"));
		
		new Button(mainPanel).setCaption("Salir").onClick(this::close);
	}
	
	private void modificarEstudiante() {
		Dialog<?> dialog = new ModificarEstudianteView(this, new ModificarEstudianteViewModel(getModelObject().getEstudiante()));
		dialog.onAccept(() -> {
			ObservableUtils.firePropertyChanged(this.getModelObject(), "nombre");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "apellido");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "legajo");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "githubUser");
		});
		dialog.open();
	}

	//TODO vista intermedia que mande al estudiante a la vista actual
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("unAlumno", "suApellido", "lol125", 115235);
		AsignacionTarea pruebaDeIngles = new AsignacionTarea(new Tarea("Prueba de ingles"));
		pruebaDeIngles.calificar(new NotaNumerica(8));
		estudiante.asignarTarea(pruebaDeIngles);
		new EstudianteView(new EstudianteViewModel(estudiante)).startApplication();
	}

}
