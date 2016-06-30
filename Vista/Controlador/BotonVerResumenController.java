package Vista.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BotonVerResumenController implements EventHandler<ActionEvent> {

	Stage ventanaPrincipal;
	@FXML private AnchorPane cartelresumen;
	
	public BotonVerResumenController(Stage stage) {
		// TODO Auto-generated constructor stub
		ventanaPrincipal = stage;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
