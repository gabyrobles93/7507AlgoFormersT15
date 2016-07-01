package Vista;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VistaBonecrusherController extends VistaAlgoformerController{
//	ImageView img_bumblebee2;

	@FXML ImageView img_bonecrusher;
	
	public void VistaBonecrusherController(){
		
	
	}
	
	@Override
	public void dibujar() {
		if(algof.getVida()==0){
			System.out.println("eliminando nodo");
			controllerTablero.eliminarNodo(img_bonecrusher);
			return;
		}	
		System.out.println("dibujano nodo");

		controllerTablero.dibujarNodo(img_bonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
		//tablero_tierra.add(img_Bonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	
	
	}
	@Override
	public void mostrarMenuAcciones(){
		try {
			FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
			AnchorPane rootMenuAcciones;
			rootMenuAcciones = loadermenuacciones.load();
			
			menuAccionesAlgoformerController controller=loadermenuacciones.getController();
			controller.setAlgoformer(algof);
		
			controller.setVistaAlgoformer(this);
			controller.setTablero(controllerTablero);
			Scene sceneMenuAcciones = new Scene(rootMenuAcciones);
			ventana_acciones = new Stage();
			
			ventana_acciones.setScene(sceneMenuAcciones);
			ventana_acciones.setFullScreen(false);
			ventana_acciones.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	    

	public void inicializar(){
	}

/*	@Override
	public void update() {
		controllerTablero.eliminarNodo(img_bonecrusher);// TODO Auto-generated method stub
		controllerTablero.dibujarNodo(img_bonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	}
	
	*/
}


