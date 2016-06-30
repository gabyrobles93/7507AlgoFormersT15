package Vista.Controlador;

import java.io.IOException;

import Modelo.Algoformer;
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
import Vista.Aplicacion;

public class menuAccionesAlgoformerController implements EventHandler<MouseEvent> {

	Algoformer algof;
	
	public menuAccionesAlgoformerController(Algoformer algoformer) {
		// TODO Auto-generated constructor stub
		algof = algoformer;
	}


	@Override
	public void handle(MouseEvent event){
		// TODO Auto-generated method stub
		
		try {
			FXMLLoader loadermenuacciones = new FXMLLoader(getClass().getResource("MenuAccionesAlgoformer.fxml"));
			Parent rootMenuAcciones;
			rootMenuAcciones = loadermenuacciones.load();
			
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
