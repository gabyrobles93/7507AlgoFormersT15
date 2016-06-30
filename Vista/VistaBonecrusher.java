package Vista;

import java.io.File;

import Modelo.Bonecrusher;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.menuAccionesAlgoformerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaBonecrusher extends VistaAlgoformer {

	public VistaBonecrusher(Bonecrusher bone){
		this.algof=bone;
	}
	
	
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\decepticons\\humanoide\\bonecrusher.png");
		
		Image imagebonecrusher = new Image(file.toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setId("imagenBonecrusher");
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	   		
		VerEstadoAlgoformerController controller = new VerEstadoAlgoformerController(algof);
		
		picbonecrusher.setOnMouseClicked(controller);
		
		picbonecrusher.setImage(imagebonecrusher);
		tablero_tierra.add(picbonecrusher,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
	}	
	
	
}
