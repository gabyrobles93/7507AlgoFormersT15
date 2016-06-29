package Vista;

import java.io.File;

import Modelo.Ratchet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaRatchet extends VistaAlgoformer {

	public VistaRatchet(Ratchet ratchet) {
		this.algof=ratchet;
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\Users\\juancruz\\Desktop\\AlgoritmosIII\\TP2\\7507AlgoFormersT15\\Vista\\imagenes\\autobots\\humanoide\\ratchet.png");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero_tierra.add(picbonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
