package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Ratchet;
import modelo.Bumblebee;
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
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistaratchet = loader.getController();
		controllervistaratchet.setRatchet(algoformer, this);
		controllervistaratchet.setTableroController(tablerocontroller);
		
	}
	@Override
	public void cargarAlterno() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("RatchetAlterno.fxml"));
		
		loader.setController(controllervistaratchet);
		
		vistaalgoformerAlterno = (ImageView) loader.load();
		
		
		
	}

	@Override
	public void cambiarModoActualizarRef(){
		algoformer=Ratchet.getRatchet();
		controllervistaratchet.setRatchet(Ratchet.getRatchet(), this);
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.imagenRatchet=this.getVista();
		
		
	}
	public ImageView getVista(){
		if(algoformer.getVelocidad()==8){
			return getVistaAlterno();
		}else{return getVistaHumanoide();}
		
	}
	
	public ImageView getVistaHumanoide() {
		// TODO Auto-generated method stub
		return vistaalgoformerHumanoide;
	}
	public ImageView getVistaAlterno(){
		return vistaalgoformerAlterno;
	}

}
