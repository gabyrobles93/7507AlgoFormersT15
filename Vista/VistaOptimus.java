package Vista;

import java.io.File;

import Modelo.Optimus;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaOptimus extends VistaAlgoformer {

	public VistaOptimus(Optimus optimus) {
		this.algof=optimus;
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\Users\\juancruz\\Desktop\\AlgoritmosIII\\TP2\\7507AlgoFormersT15\\Vista\\imagenes\\autobots\\humanoide\\optimus.png");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero_tierra.add(picbonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
