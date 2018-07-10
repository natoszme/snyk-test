package ui.view;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.estudiante.Estudiante;
import ui.viewmodel.EstudianteViewModel;

//TODO por que rompe con un @Observable?
@SuppressWarnings("serial")
public class ModificarEstudianteView extends Dialog<ModificarEstudianteViewModel>{
	
	public ModificarEstudianteView(WindowOwner parent, ModificarEstudianteViewModel modificarEstudianteViewModel) {
		super(parent, modificarEstudianteViewModel);
	}

	@Override
	protected void addActions(Panel mainPanel) {
		new Button(mainPanel).setCaption("Guardar").onClick(this::actualizarDatos).setAsDefault();		
		new Button(mainPanel).setCaption("Descartar").onClick(this::cancel);
	}

	//TODO alguna forma de que la ventana principal herede de esta? Para no repetir los labels
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Modificar estudiante");
		
		Panel panelNombre = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(panelNombre).setText("Nombre: ");
		new TextBox(panelNombre).bindValueToProperty("nombre");
		
		Panel apeliidoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(apeliidoPanel).setText("Apellido: ");
		new TextBox(apeliidoPanel).bindValueToProperty("apellido");
		
		Panel legajoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(legajoPanel).setText("Legajo: ");
		new NumericField(legajoPanel).bindValueToProperty("legajo");
		
		Panel githubPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(githubPanel).setText("Github user: ");
		new TextBox(githubPanel).bindValueToProperty("githubUser");
	}
	
	public void actualizarDatos() {
		this.getModelObject().actualizarDatosEstudiante();
		this.close();
	}

}
