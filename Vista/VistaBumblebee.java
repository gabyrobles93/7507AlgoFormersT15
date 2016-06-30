package Vista;

import java.io.File;

import Modelo.Bumblebee;
import Vista.Controlador.menuAccionesAlgoformerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaBumblebee extends VistaAlgoformer {

	public VistaBumblebee(Bumblebee bumblebee) {
		this.algof=bumblebee;
	}

	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\autobots\\humanoide\\bumblebee.png");
		
		Image imagebumblebee = new Image(file.toURI().toString());
		ImageView picbumblebee = new ImageView();
		picbumblebee.setFitWidth(75);
		picbumblebee.setFitHeight(75);
	    
		menuAccionesAlgoformerController controller = new menuAccionesAlgoformerController();
		
		picbumblebee.setOnMouseClicked(controller);
		
		picbumblebee.setImage(imagebumblebee);
		tablero_tierra.add(picbumblebee,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
