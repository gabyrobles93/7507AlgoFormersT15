package vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import modelo.Algoformer;
import modelo.Megatron;
import modelo.Posicion;
import vista.controller.TableroController;
import vista.controller.VistaMegatronController;

public class VistaChispa {
	Posicion posicion;
//	TableroController tablerocontroller;
	ImageView vistachispa;

	public VistaChispa(){}
	

	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Chispa.fxml"));
		vistachispa = (ImageView) loader.load();
	/*	
		controllervistamegatron = loader.getController();
		controllervistamegatron.setMegatron(algoformer, this);
		controllervistamegatron.setTableroController(tablerocontroller);*/
		
	}

	public ImageView getVista() {
		
		return vistachispa;	
	}
}


