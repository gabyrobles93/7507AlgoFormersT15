package Vista.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVerTierraController implements EventHandler<ActionEvent> {
	Scene tierra;
	Stage nuevostage;

	
	public BotonVerTierraController(Stage stage,Scene tablerotierra){
		tierra = tablerotierra;
		nuevostage = new Stage();	
		nuevostage = stage;
	}
	@Override
	public void handle(ActionEvent event) {
		nuevostage.setScene(tierra);
		nuevostage.setFullScreen(false);
		nuevostage.show();
		
	}

}
