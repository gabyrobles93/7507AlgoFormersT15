package Vista;

import java.io.File;
import java.io.IOException;

import Modelo.Algoformer;
import Modelo.Bumblebee;
import Vista.Controlador.BotonMoverHandler;
import Vista.menuAccionesAlgoformerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaBumblebee {
@FXML ImageView img_bumblebee;
private Algoformer algof;
private GridPane tablero;
	public VistaBumblebee(Bumblebee bumblebee,GridPane tablero) {
		this.algof=bumblebee;
		this.tablero=tablero;
	}

	public void dibujar(GridPane tablero_tierra) {
		/*File file = new File("C:\\imagenes\\autobots\\humanoide\\bumblebee.png");
		
		Image imagebumblebee = new Image(file.toURI().toString());
		ImageView picbumblebee = new ImageView();
		picbumblebee.setFitWidth(75);
		picbumblebee.setFitHeight(75);
	    
		menuAccionesAlgoformerController controller = new menuAccionesAlgoformerController(algof,tablero_tierra);
		
		picbumblebee.setOnMouseClicked(controller);
		
		picbumblebee.setImage(imagebumblebee);
		tablero_tierra.add(picbumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());	*/
		tablero_tierra.add(img_bumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());
	}
	public void mostrarMenuAcciones(){
	try {
		FXMLLoader loadermenuacciones = new FXMLLoader(getClass().getResource("MenuAccionesAlgoformer.fxml"));
		Parent rootMenuAcciones;
		rootMenuAcciones = loadermenuacciones.load();
		
		
		Scene sceneMenuAcciones = new Scene(rootMenuAcciones);
		Stage st = new Stage();
		
		st.setScene(sceneMenuAcciones);
		st.setFullScreen(false);
		st.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
    
}
