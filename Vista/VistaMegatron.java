package Vista;


import java.io.File;

import Modelo.Megatron;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.Controlador.menuAccionesAlgoformerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaMegatron extends VistaAlgoformer {

	public VistaMegatron(Megatron megatron) {
		
		this.algof=megatron;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void dibujar(GridPane tablero_tierra) {
		File file = new File("C:\\imagenes\\decepticons\\humanoide\\megatron.png");
		
		Image imagemegatron = new Image(file.toURI().toString());
		ImageView picmegatron = new ImageView();
		picmegatron.setFitWidth(75);
		picmegatron.setFitHeight(75);
		
		
		VerEstadoAlgoformerController controller = new VerEstadoAlgoformerController(algof);
		
		picmegatron.setOnMouseClicked(controller);
	    
		picmegatron.setImage(imagemegatron);
		tablero_tierra.add(picmegatron,algof.getPosicion().getColumna(),algof.getPosicion().getFila());		
		
	
		
	}
}
