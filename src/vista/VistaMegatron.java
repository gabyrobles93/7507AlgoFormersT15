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
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistamegatron = loader.getController();
		controllervistamegatron.setMegatron(algoformer, this);
		controllervistamegatron.setTableroController(tablerocontroller);
		
	}
	@Override
	public void cargarAlterno() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("MegatronAlterno.fxml"));
		
		loader.setController(controllervistamegatron);
		
		vistaalgoformerAlterno = (ImageView) loader.load();
		
		
		
	}

	@Override
	public void cambiarModoActualizarRef(){
		algoformer=Megatron.getMegatron();
		controllervistamegatron.setMegatron(Megatron.getMegatron(), this);
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.imagenMegatron=this.getVista();
		
		
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
