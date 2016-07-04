package vista;


import vista.Aplicacion;
import vista.controller.TableroController;
import vista.controller.VistaBumblebeeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
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
		vistaalgoformer = (ImageView) loader.load();
		
		controllervistabumblebee = loader.getController();
		controllervistabumblebee.setBumblebee(algoformer, this);
		controllervistabumblebee.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vistaalgoformer;
	}


}
