package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Bonecrusher;
import modelo.Posicion;
import vista.controller.TableroController;
import vista.controller.VistaBonecrusherController;

public class VistaBonecrusher extends VistaAlgoformer{

	Posicion posicion;
	VistaBonecrusherController controllervistabonecrusher;
	TableroController tablerocontroller;
	
	public VistaBonecrusher(Bonecrusher bone, TableroController tabcont){
		algoformer = bone;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Bonecrusher.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistabonecrusher = loader.getController();
		controllervistabonecrusher.setBonecrusher(algoformer, this);
		controllervistabonecrusher.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		
		return vistaalgoformer;	
	}
}

