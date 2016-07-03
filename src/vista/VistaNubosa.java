package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaNubosa extends VistaSuperficie {

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		File file = new File("C:\\imagenes\\superficiecielo\\01_nubosa.png");
		
		Image imagesupnubosa = new Image(file.toURI().toString());
		ImageView picsupnubosa = new ImageView();
		picsupnubosa.setFitWidth(75);
		picsupnubosa.setFitHeight(75);
	    
		
		picsupnubosa.setImage(imagesupnubosa);
	
		vista_superficie = picsupnubosa;
		
	}

}
