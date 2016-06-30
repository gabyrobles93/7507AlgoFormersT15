package Vista.Controlador;

import java.io.IOException;

import Vista.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class menuAccionesAlgoformerController implements EventHandler<MouseEvent> {

/*
	@FXML private Button boton_atacar;
	@FXML private Button boton_mover;
	@FXML private Button boton_transformar;
	@FXML private Button boton_combinar;
	@FXML private Button boton_ver_estado;
*/

	@Override
	public void handle(MouseEvent event){
		// TODO Auto-generated method stub

		try {
			FXMLLoader loadermenuacciones = new FXMLLoader(getClass().getResource("MenuAccionesAlgoformer.fxml"));
			Parent rootMenuAcciones;
			rootMenuAcciones = loadermenuacciones.load();
			
			menuAccionesAlgoformerController controllerMenuAcciones = loadermenuacciones.getController();
			Scene sceneMenuAcciones = new Scene(rootMenuAcciones);
			Stage st = new Stage();
			
			st.setScene(sceneMenuAcciones);
			st.setFullScreen(false);
			st.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
