package Vista.Controlador;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroController {
	Stage stage;
	Scene proximaescena;
	
	@FXML private BorderPane tableroGeneral;
	@FXML private MenuItem ver_resumen;
	@FXML private MenuItem ver_tierra;
	@FXML private MenuItem ver_cielo;
	@FXML private MenuItem ayuda;
	@FXML private MenuItem acerca_de;



public void setCenter(ScrollPane tablero){
	tableroGeneral.setCenter(tablero);
}

}