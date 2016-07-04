package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Frenzy;
import modelo.Posicion;
import vista.controller.TableroController;
import vista.controller.VistaFrenzyController;

public class VistaFrenzy extends VistaAlgoformer {

	Posicion posicion;
	VistaFrenzyController controllervistafrenzy;
	TableroController tablerocontroller;
	
	public VistaFrenzy(Frenzy frenzy, TableroController tabcont){
		algoformer = frenzy;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Frenzy.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistafrenzy = loader.getController();
		controllervistafrenzy.setFrenzy(algoformer, this);
		controllervistafrenzy.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		
		return vistaalgoformer;	
	}
}


