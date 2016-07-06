package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaRocosa extends VistaSuperficie {

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		File file;
		
		file = new File("src/vista/resources/imagenes/superficietierra/03_rocosa.jpg");		
		
		Image imagesuptierra = new Image(file.toURI().toString());
		ImageView picsuptierra = new ImageView();
		picsuptierra.setFitWidth(75);
		picsuptierra.setFitHeight(75);
	    
		picsuptierra.setImage(imagesuptierra);

		vista_superficie = picsuptierra;			

	}
}
