package Vista;

import Modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorJuegoFinalizado extends BorderPane{
private Canvas canvas;
private VBox contenedorCentral;
	
	public ContenedorJuegoFinalizado(Stage stage,Juego juego){
		this.setFinal(stage);
		
	}

	private void setFinal(Stage stage) {
	canvas=new Canvas(200,200);
	contenedorCentral=new VBox(canvas);
	
	Text txt1=new Text("Ganaste");
	contenedorCentral.getChildren().add(txt1);
    this.setCenter(contenedorCentral);
    
		
	}
	
}
