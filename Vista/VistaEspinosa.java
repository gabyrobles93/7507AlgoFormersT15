package Vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaEspinosa extends VistaSuperficie {

	@Override
	public void dibujar(GridPane tablero, int fila, int columna) {
		// TODO Auto-generated method stub
File file = new File("C:\\imagenes\\superficietierra\\01_espinosa.jpg");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero.add(picbonecrusher,fila,columna);	
		
	}

}
