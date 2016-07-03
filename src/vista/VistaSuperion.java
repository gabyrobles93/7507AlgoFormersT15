package vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import modelo.Posicion;
import modelo.Superion;
import vista.controller.TableroController;
import vista.controller.VistaSuperionController;

public class VistaSuperion extends VistaAlgoformer {

	Posicion posicion;
	VistaSuperionController controllervistasuperion;
	TableroController tablerocontroller;
	
	public VistaSuperion(Superion sup, TableroController tabcont){
		algoformer = sup;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Superion.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistasuperion = loader.getController();
		controllervistasuperion.setSuperion(algoformer, this);
		controllervistasuperion.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vistaalgoformer;
	}
}


