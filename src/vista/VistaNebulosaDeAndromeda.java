package vista;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaNebulosaDeAndromeda extends VistaSuperficie {

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		File file = new File("C:\\imagenes\\superficiecielo\\03_tomerntadeandromeda.gif");
		
		Image imagesuptormentadeandromeda = new Image(file.toURI().toString());
		ImageView picsuptormentadeandromeda = new ImageView();
		picsuptormentadeandromeda.setFitWidth(75);
		picsuptormentadeandromeda.setFitHeight(75);
	    
		picsuptormentadeandromeda.setImage(imagesuptormentadeandromeda);
		
		vista_superficie = picsuptormentadeandromeda;			
	}

}
