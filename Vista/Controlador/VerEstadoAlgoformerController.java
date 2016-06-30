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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VerEstadoAlgoformerController implements EventHandler<MouseEvent> {

	Algoformer algof;
	
	public VerEstadoAlgoformerController(Algoformer algoformer) {
		// TODO Auto-generated constructor stub
		algof = algoformer;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub

		try {
			
			BotonVerEstadoHandler botonestadohandler = new BotonVerEstadoHandler(algof);
			
			FXMLLoader loadermenuverestado = new FXMLLoader(getClass().getResource("Menu_Estado_Algoformer.fxml"));
			loadermenuverestado.setController(botonestadohandler);
			Parent rootEstado;
			
			rootEstado = loadermenuverestado.load();
						
					
			Scene sceneMenuAcciones = new Scene(rootEstado);
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
