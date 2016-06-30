package Vista;

import java.io.File;

import Modelo.Frenzy;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.menuAccionesAlgoformerController;
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
		
		Image imagefrenzy = new Image(file.toURI().toString());
		ImageView picfrenzy = new ImageView();
		picfrenzy.setFitWidth(75);
		picfrenzy.setFitHeight(75);
		
		VerEstadoAlgoformerController controller = new VerEstadoAlgoformerController(algof);
		
		picfrenzy.setOnMouseClicked(controller);
	    
		picfrenzy.setImage(imagefrenzy);
		tablero_tierra.add(picfrenzy,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}
}
