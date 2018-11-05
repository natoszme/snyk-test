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
import org.uqbar.arena.windows.MainWindow;

import httpClientService.HttpClient;
import model.estudiante.Estudiante;
import model.tarea.AsignacionTarea;
import notasService.NotasService;
import ui.viewmodel.ModificarEstudianteViewModel;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends MainWindow<Estudiante>{

	public EstudianteView(Estudiante estudiante) {
		super(estudiante);
	}
	
	private void modificarEstudiante() {
		Dialog<?> dialog = new ModificarEstudianteView(this, new ModificarEstudianteViewModel(getModelObject()));
		//TODO Como hacer sin fireProperty? edit: aca esta el fireOnPropertyChanged. Lo sacamos y funca pero queremos entender bien que pasaba
		dialog.open();
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
		
		new Label(mainPanel).setText("Notas").alignLeft();
		Table<AsignacionTarea> tablaAsignacionesTarea = new Table<AsignacionTarea>(mainPanel, AsignacionTarea.class).
				setNumberVisibleRows(6);
		tablaAsignacionesTarea.bindItemsToProperty("asignaciones");
	
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Tarea")
	    .bindContentsToProperty("tarea")
	    .setTransformer(new NombreTareaToStringTransformer());
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea)
		.setTitle("Descripcion")
		.bindContentsToProperty("tarea")
	    .setTransformer(new DescripcionTareaToStringTransformer());
		
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Ultima nota")
	    .bindContentsToProperty("ultimaNota")
	    .setTransformer(new NotaToStringTransformer());
		
		//TODO aca hubo algo raro: se estaba llamando al metodo aprobo pero no estaba definido getAprbo y andaba igual...
		new Column<AsignacionTarea>(tablaAsignacionesTarea) 
	    .setTitle("Aprobo")
	    .bindContentsToProperty("aprobo")
	    .setTransformer(new BooleanToSiNoTransformer());
	}

	//TODO y que pasa si quiero usar un panel de los de arriba?
	protected void addActions(Panel mainPanel) {
		new Button(mainPanel).setCaption("Salir").onClick(this::close);		
	}
	
	public static void main(String[] args) {
		HttpClient.getInstance().setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoxfQ.GDCk-9yZwlADFew9jI551Izq9Dj3SYsCfEL5qcUZYlM");
		new EstudianteView(NotasService.dameEstudiante()).startApplication();
	}
}
