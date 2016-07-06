package vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import modelo.Posicion;
import modelo.Algoformer;
import modelo.Menasor;
import vista.controller.TableroController;
import vista.controller.VistaMenasorController;

public class VistaMenasor extends VistaAlgoformer{

	Posicion posicion;
	VistaMenasorController controllervistamenasor;
	TableroController tablerocontroller;
	
	public VistaMenasor(Menasor menasor, TableroController tabcont){
		algoformer = menasor;
		tablerocontroller = tabcont;
	}
	
	@Override
	public void cargar() throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Menasor.fxml"));
		vistaalgoformerHumanoide = (ImageView) loader.load();
		
		controllervistamenasor = loader.getController();
		controllervistamenasor.setMenasor(algoformer, this);
		controllervistamenasor.setTableroController(tablerocontroller);
		
	}

	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vistaalgoformerHumanoide;
	}

	public void setAlgoformer(Algoformer algof) {
		// TODO Auto-generated method stub
		this.algoformer=algof;
		controllervistamenasor.setMenasor(algoformer, this);
	}

	public Algoformer getSuperion() {
		// TODO Auto-generated method stub
		return algoformer;
	}
}


