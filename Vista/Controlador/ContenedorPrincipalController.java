package Vista.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContenedorPrincipalController implements Initializable {

	@FXML private BorderPane contenedor_principal;
	@FXML private MenuBar barra_de_menu;
	
	public ContenedorPrincipalController(){
		

	}

	public BorderPane getContenedorPrincipal(){		
		return contenedor_principal;
	}
	
	public Scene configurar() {
		return null;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
