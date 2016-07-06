package vista;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaEspinosa extends VistaSuperficie {

	@Override
	public void cargar(){
		// TODO Auto-generated method stub
		
				File file;
	
				file = new File("src/vista/resources/imagenes/superficietierra/01_espinosa.jpg");
				
				Image imagesupespinosa = new Image(file.toURI().toString());
				ImageView picsupespinosa = new ImageView();
				picsupespinosa.setFitWidth(75);
				picsupespinosa.setFitHeight(75);
				    
				picsupespinosa.setImage(imagesupespinosa);	
				vista_superficie = picsupespinosa;
				

	}

}
