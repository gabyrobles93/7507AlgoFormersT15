package EJEMPLOS;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVerCieloController implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
	
    public BotonVerCieloController(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }
	
	@Override
	public void handle(ActionEvent arg0) {
		stage.setScene(proximaEscena);
		stage.setFullScreen(true);
		stage.show();
	}

}
