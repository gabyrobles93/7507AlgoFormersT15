package Vista;

import java.io.File;

import Modelo.Optimus;
import Vista.Controlador.menuAccionesAlgoformerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaOptimus extends VistaAlgoformer {

	public VistaOptimus(Optimus optimus) {
		this.algof=optimus;
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\autobots\\humanoide\\optimus.png");
		
		Image imageoptimus = new Image(file.toURI().toString());
		ImageView picoptimus = new ImageView();
		picoptimus.setFitWidth(75);
		picoptimus.setFitHeight(75);
		
		menuAccionesAlgoformerController controller = new menuAccionesAlgoformerController(algof);
		
		picoptimus.setOnMouseClicked(controller);
	    
		picoptimus.setImage(imageoptimus);
		tablero_tierra.add(picoptimus,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
