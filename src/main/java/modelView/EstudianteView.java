package modelView;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tree.Tree;
import org.uqbar.arena.windows.MainWindow;

import estudiante.Calificacion;
import estudiante.Estudiante;

//TODO que hace?
@SuppressWarnings("serial")
public class EstudianteView extends MainWindow<Estudiante>{

	public EstudianteView() {
		super(new EstudianteViewModel(new Estudiante()));
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Detalle estudiante");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Nombre");
		new Label(mainPanel).setText("Apellido");
		new Label(mainPanel).setText("Legajo");
		new Label(mainPanel).setText("Legajo");
		
		new Button(mainPanel).setCaption("Modificar datos");
		
		new Tree<Calificacion>(mainPanel).bindNodeToProperty("calificaciones");
		
		new Button(mainPanel).setCaption("Salir");
	}
	
	public static void main(String[] args) {
		new EstudianteView().startApplication();
	}

}
