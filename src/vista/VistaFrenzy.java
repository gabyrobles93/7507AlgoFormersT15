package vista;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Bumblebee;
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
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistafrenzy = loader.getController();
		controllervistafrenzy.setFrenzy(algoformer, this);
		controllervistafrenzy.setTableroController(tablerocontroller);
		
	}
	@Override
	public void cargarAlterno() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("FrenzyAlterno.fxml"));
		
		loader.setController(controllervistafrenzy);
		
		vistaalgoformerAlterno = (ImageView) loader.load();
		
		
		
	}

	@Override
	public void cambiarModoActualizarRef(){
		algoformer=Frenzy.getFrenzy();
		controllervistafrenzy.setFrenzy(Frenzy.getFrenzy(), this);
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.imagenFrenzy=this.getVista();
		
		
	}
	public ImageView getVista(){
		if(algoformer.getVelocidad()==6){
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


