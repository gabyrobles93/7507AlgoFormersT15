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
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub

		try {
			FXMLLoader loadermenuverestado = new FXMLLoader(getClass().getResource("Menu_Estado_Algoformer.fxml"));
			Parent rootEstado;
			rootEstado = loadermenuverestado.load();
			
			
			Scene sceneMenuEstado = new Scene(rootEstado);
			Stage st = new Stage();
			
			st.setScene(sceneMenuEstado);
			st.setFullScreen(false);
			st.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void mostrarEstado() {
		
		VBox hb=new VBox();
		
		Text txt1=new Text("Vida "+String.valueOf(algof.getVida()));
		Text txt2=new Text("Ataque "+String.valueOf(algof.getAtaque()));
		Text txt3=new Text("Velocidad "+String.valueOf(algof.getVelocidad()));
		Text txt4=new Text("Espera Turnos "+String.valueOf(algof.getEfecto().esperaturnos));
		hb.getChildren().addAll(txt1,txt2,txt3,txt4);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Estado del Algoformer");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
		
	}

}
