package Vista;

import java.io.File;

import Modelo.Ratchet;
import Vista.menuAccionesAlgoformerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaRatchet extends VistaAlgoformer {

	public VistaRatchet(Ratchet ratchet) {
		this.algof=ratchet;
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\autobots\\humanoide\\ratchet.png");
		
		Image imageratchet = new Image(file.toURI().toString());
		ImageView picratchet = new ImageView();
		picratchet.setFitWidth(75);
		picratchet.setFitHeight(75);
		
		//menuAccionesAlgoformerController controller = new menuAccionesAlgoformerController(algof,tablero_tierra);
		
		//picratchet.setOnMouseClicked(controller);
	    
		picratchet.setImage(imageratchet);
		tablero_tierra.add(picratchet,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
