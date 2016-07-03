package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaPantano extends VistaSuperficie{

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		File file = new File("C:\\imagenes\\superficietierra\\02_pantanosa.jpg");
		
		Image imagesuppantanosa = new Image(file.toURI().toString());
		ImageView picsuppantanosa = new ImageView();
		picsuppantanosa.setFitWidth(75);
		picsuppantanosa.setFitHeight(75);
	    
		picsuppantanosa.setImage(imagesuppantanosa);

		vista_superficie = picsuppantanosa;			

	}

}
