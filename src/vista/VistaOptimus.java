package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Optimus;
import modelo.Posicion;
import vista.controller.MenuAccionesAlgoformerController;
import vista.controller.TableroController;
import vista.controller.VistaOptimusController;

public class VistaOptimus extends VistaAlgoformer{

	Posicion posicion;
	VistaOptimusController controllervistaoptimus;
	TableroController tablerocontroller;
	
	public VistaOptimus(Optimus optimus, TableroController tabcont){
		algoformer = optimus;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Optimus.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistaoptimus = loader.getController();
		controllervistaoptimus.setOptimus(algoformer, this);
		controllervistaoptimus.setTableroController(tablerocontroller);
		
	}
	
	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vistaalgoformer;
	}
	

}
