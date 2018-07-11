package ui.view;

import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.utils.ObservableUtils;

import model.estudiante.AsignacionTarea;
import model.estudiante.EnumNotaConceptual;
import model.estudiante.Estudiante;
import model.estudiante.Nota;
import model.estudiante.NotaConceptual;
import model.estudiante.NotaNumerica;
import model.estudiante.Tarea;
import ui.viewmodel.EstudianteViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends MainWindow<Estudiante>{

	public EstudianteView(Estudiante estudiante) {
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
		
		new Label(mainPanel).setText("Notas");
		Table<AsignacionTarea> tablaAsignacionesTarea = new Table<AsignacionTarea>(mainPanel, AsignacionTarea.class);
		tablaAsignacionesTarea.bindItemsToProperty("asignacionesTarea");
	
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Tarea")
	    .bindContentsToProperty("nombreTarea");
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Nota")
	    .bindContentsToProperty("ultimaNota");
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Aprobo")
	    .bindContentsToProperty("aprobo");
		
		new Button(mainPanel).setCaption("Salir").onClick(this::close);
	}
	
	private void modificarEstudiante() {
		Dialog<?> dialog = new ModificarEstudianteView(this, new ModificarEstudianteViewModel(getModelObject()));
		dialog.onAccept(() -> {
			ObservableUtils.firePropertyChanged(this.getModelObject(), "nombre");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "apellido");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "legajo");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "githubUser"); //TODO Como hacer sin fireProperty?
		});
		dialog.open();
	}

	//TODO vista intermedia que mande al estudiante a la vista actual
	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("unAlumno", "suApellido", "lol125", 115235);
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
		new EstudianteView(estudiante).startApplication();
	}

}
