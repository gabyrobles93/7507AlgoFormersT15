package vista.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class VistaTableroController {

	@FXML ScrollPane vista_tablero;
	@FXML GridPane tablero;
	
	public GridPane getTablero() {
		// TODO Auto-generated method stub
		return tablero;
	}
	
	public ScrollPane getVistaTablero() {
		// TODO Auto-generated method stub
		return vista_tablero;
	}
}
