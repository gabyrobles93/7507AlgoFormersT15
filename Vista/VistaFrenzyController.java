package Vista;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VistaFrenzyController extends VistaAlgoformerController{
//	ImageView img_bumblebee2;

	@FXML ImageView img_frenzy;
	
	public void VistaFrenzyController(){
		
	
	}
	
	@Override
	public void dibujar() {
		if(algof.getVida()==0){
			controllerTablero.eliminarNodo(img_frenzy);
			return;
		}	
		
		controllerTablero.dibujarNodo(img_frenzy,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
		//tablero_tierra.add(img_Frenzy,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	
	
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
		controllerTablero.eliminarNodo(img_frenzy);// TODO Auto-generated method stub
		controllerTablero.dibujarNodo(img_frenzy,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	}*/
	
	
}
