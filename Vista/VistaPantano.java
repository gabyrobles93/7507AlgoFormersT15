package Vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaPantano extends VistaSuperficie {

	@Override
	public void dibujar(GridPane tablero, int fila, int columna) {
File file = new File("C:\\imagenes\\superficietierra\\02_pantanosa.jpg");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero.add(picbonecrusher,fila,columna);	
		
	}

	
	
	
	

}
