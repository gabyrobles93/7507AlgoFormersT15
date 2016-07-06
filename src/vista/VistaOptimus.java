package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Bumblebee;
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
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistaoptimus = loader.getController();
		controllervistaoptimus.setOptimus(algoformer, this);
		controllervistaoptimus.setTableroController(tablerocontroller);
		
	}
	@Override
	public void cargarAlterno() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("OptimusAlterno.fxml"));
		
		loader.setController(controllervistaoptimus);
		
		vistaalgoformerAlterno = (ImageView) loader.load();
		
		
		
	}
	
	@Override
	public void cambiarModoActualizarRef(){
		algoformer=Optimus.getOptimus();
		controllervistaoptimus.setOptimus(Optimus.getOptimus(), this);
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.imagenOptimus=this.getVista();
		
		
	}
	public ImageView getVista(){
		if(algoformer.getVelocidad()==5){
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
