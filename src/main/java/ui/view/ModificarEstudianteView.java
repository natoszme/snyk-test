package ui.view;

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
		
		new Label(mainPanel).setText("Nombre");
		new TextBox(mainPanel).bindValueToProperty("nombre");
		
		new Label(mainPanel).setText("Apellido");
		new TextBox(mainPanel).bindValueToProperty("apellido");
		
		new Label(mainPanel).setText("Legajo");
		new NumericField(mainPanel).bindValueToProperty("legajo");
		
		new Label(mainPanel).setText("Github user");
		new TextBox(mainPanel).bindValueToProperty("githubUser");
	}
	
	public void actualizarDatos() {
		this.getModelObject().actualizarDatosEstudiante();
		this.close();
	}

}
