package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Bumblebee;
import modelo.Megatron;
import modelo.Posicion;
import vista.controller.TableroController;
import vista.controller.VistaBumblebeeController;
import vista.controller.VistaMegatronController;

public class VistaMegatron extends VistaAlgoformer {

	Posicion posicion;
	VistaMegatronController controllervistamegatron;
	TableroController tablerocontroller;
	
	public VistaMegatron(Megatron mega, TableroController tabcont){
		algoformer = mega;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Megatron.fxml"));
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistamegatron = loader.getController();
		controllervistamegatron.setMegatron(algoformer, this);
		controllervistamegatron.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		
		return vistaalgoformer;	
	}
}
