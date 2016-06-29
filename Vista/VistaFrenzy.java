package Vista;

import java.io.File;

import Modelo.Frenzy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaFrenzy extends VistaAlgoformer {

	
	public VistaFrenzy(Frenzy frenzy){
		this.algof=frenzy;
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\decepticons\\humanoide\\frenzy.png");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero_tierra.add(picbonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
