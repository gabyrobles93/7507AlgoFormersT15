package vista;


import vista.Aplicacion;
import vista.controller.TableroController;
import vista.controller.VistaBumblebeeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import modelo.Bonecrusher;
import modelo.Bumblebee;
import modelo.Posicion;

public class VistaBumblebee extends VistaAlgoformer {
	
	Posicion posicion;
	VistaBumblebeeController controllervistabumblebee;
	TableroController tablerocontroller;
	
	public VistaBumblebee(Bumblebee bumb, TableroController tabcont){
		algoformer = bumb;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Bumblebee.fxml"));
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistabumblebee = loader.getController();
		controllervistabumblebee.setBumblebee(algoformer, this);
		controllervistabumblebee.setTableroController(tablerocontroller);
		
	}
	@Override
	public void cargarAlterno() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("BumblebeeAlterno.fxml"));
		
		loader.setController(controllervistabumblebee);
		
		vistaalgoformerAlterno = (ImageView) loader.load();
		
		
		
	}
	@Override
	public void cambiarModoActualizarRef(){
		algoformer=Bumblebee.getBumblebee();
		controllervistabumblebee.setBumblebee(Bumblebee.getBumblebee(), this);
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.imagenBumblebee=this.getVista();
		
		
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
