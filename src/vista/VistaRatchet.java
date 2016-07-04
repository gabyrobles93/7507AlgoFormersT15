package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Ratchet;
import modelo.Posicion;
import vista.controller.TableroController;
import vista.controller.VistaRatchetController;

public class VistaRatchet extends VistaAlgoformer{

	
	Posicion posicion;
	VistaRatchetController controllervistaratchet;
	TableroController tablerocontroller;
	
	public VistaRatchet(Ratchet rat, TableroController tabcont){
		algoformer = rat;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Ratchet.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistaratchet = loader.getController();
		controllervistaratchet.setRatchet(algoformer, this);
		controllervistaratchet.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vistaalgoformer;
	}
}
