package ui.view;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.estudiante.AsignacionTarea;
import model.estudiante.Estudiante;
import ui.viewmodel.ModificarEstudianteViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends SimpleWindow<Estudiante>{

	public EstudianteView(WindowOwner parent, Estudiante estudiante) {
		super(parent, estudiante);
	}
	
	private void modificarEstudiante() {
		Dialog<?> dialog = new ModificarEstudianteView(this, new ModificarEstudianteViewModel(getModelObject()));
		//TODO Como hacer sin fireProperty? edit: aca esta el fireOnPropertyChanged. Lo sacamos y funca pero queremos entender bien que pasaba
		dialog.open();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
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
		
		new Label(mainPanel).setText("Notas").alignLeft();
		Table<AsignacionTarea> tablaAsignacionesTarea = new Table<AsignacionTarea>(mainPanel, AsignacionTarea.class).
				setNumberVisibleRows(6);
		tablaAsignacionesTarea.bindItemsToProperty("asignaciones");
	
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Tarea")
	    .bindContentsToProperty("nombreTarea");
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Nota")
	    .bindContentsToProperty("ultimaNota");
		
		//TODO aca hubo algo raro: se estaba llamando al metodo aprobo pero no estaba definido getAprbo y andaba igual...
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Aprobo")
	    .bindContentsToProperty("aprobo");
	}

	//TODO y que pasa si quiero usar un panel de los de arriba?
	@Override
	protected void addActions(Panel mainPanel) {
		new Button(mainPanel).setCaption("Salir").onClick(this::close);		
	}
}
