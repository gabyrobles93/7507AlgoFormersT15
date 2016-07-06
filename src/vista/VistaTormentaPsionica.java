package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaTormentaPsionica extends VistaSuperficie {

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		File file;
		
		file = new File("src/vista/resources/imagenes/superficiecielo/02_tormentosa.gif");		
		
		Image imagesuptormentosa = new Image(file.toURI().toString());
		ImageView picsuptormentosa = new ImageView();
		picsuptormentosa.setFitWidth(75);
		picsuptormentosa.setFitHeight(75);
	    
		picsuptormentosa.setImage(imagesuptormentosa);

		vista_superficie = picsuptormentosa;			

	}

}
