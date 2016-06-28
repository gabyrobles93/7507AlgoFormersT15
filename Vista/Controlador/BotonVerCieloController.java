package Vista.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVerCieloController implements EventHandler<ActionEvent>  {

	Scene cielo;
	Stage nuevostage;
	
	public BotonVerCieloController(Stage stage, Scene tablerocielo) {
		cielo = tablerocielo;
		nuevostage = new Stage();	
		nuevostage = stage;
	}

	@Override
	public void handle(ActionEvent arg0) {	
		nuevostage.setScene(cielo);
		nuevostage.setFullScreen(false);
		nuevostage.show();
	}

}
