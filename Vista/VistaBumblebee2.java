package Vista;

import java.io.IOException;

import Modelo.Algoformer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaBumblebee2 {
	Algoformer algof;
	@FXML ImageView img_bumblebee;
	TableroTierraController controllerTablero_tierra;
	Stage ventana_acciones;
	public void dibujar() {
		
		controllerTablero_tierra.dibujarNodo(img_bumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
		//tablero_tierra.add(img_bumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	
	
	}
	public void setAlgoformer(Algoformer algof2) {
		// TODO Auto-generated method stub
		this.algof=algof2;
	}
	public void mostrarMenuAcciones(){
		try {
			FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
			AnchorPane rootMenuAcciones;
			rootMenuAcciones = loadermenuacciones.load();
			
			menuAccionesAlgoformerController controller=loadermenuacciones.getController();
			controller.setAlgoformer(algof);
		
			controller.setVistaAlgoformer(this);
			controller.setTablero(controllerTablero_tierra);
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
	public void update() {
		controllerTablero_tierra.eliminarNodo(img_bumblebee);// TODO Auto-generated method stub
		controllerTablero_tierra.dibujarNodo(img_bumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	}
	public void cerrarMenu(){
		ventana_acciones.close();
	}
	public void setControllerTableroTierra(TableroTierraController tab){
		this.controllerTablero_tierra=tab;
	}
}
