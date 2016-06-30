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
			mostrarMenuEstado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
		
	private void mostrarMenuEstado() throws Exception{
		
		//BotonAyudaController ayudacontroller = new BotonAyudaController(stage);
		
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(Aplicacion.class.getResource("Menu_Estado_Algoformer.fxml"));
	   // loader.setController(ayudacontroller);
	    
	    Parent vistaayuda =  loader.load();
	    
	    Scene nuevascene = new Scene(vistaayuda);
		
	    Stage stage = new Stage();
	    stage.setScene(nuevascene);
	    stage.setFullScreen(false);
	    stage.setResizable(false);
	    stage.show();
		
	}
}
