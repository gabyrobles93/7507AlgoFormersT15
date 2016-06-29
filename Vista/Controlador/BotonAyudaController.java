package Vista.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonAyudaController implements EventHandler<ActionEvent> {

	Stage ventanaPrincipal;
	@FXML private AnchorPane cartelayuda;

	
	
	public BotonAyudaController(Stage stage) {
			ventanaPrincipal = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		
		
	}

}
