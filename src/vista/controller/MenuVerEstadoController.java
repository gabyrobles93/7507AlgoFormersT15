package vista.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Posicion;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class MenuVerEstadoController {
	
	@FXML AnchorPane vista_menu_ver_estado;
	Algoformer algof;
	VistaAlgoformer vistaalgof;
	TableroController tablerocontroller;
	Stage ventana;

	
	
	public void mostrarEstado(){
		
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


	public Parent getVista() {
		// TODO Auto-generated method stub
		return vista_menu_ver_estado;
	}

	public void setAlgoformer(Algoformer algoformer, VistaAlgoformer vistaalgoformer) {
		// TODO Auto-generated method stub
		algof = algoformer;
		vistaalgof = vistaalgoformer;
	}
	
	public void setTableroController(TableroController tabcontroller){
		tablerocontroller = tabcontroller;
	}


	public void redibujarAlgoformers() {
		// TODO Auto-generated method stub
		tablerocontroller.redibujarAlgoformers();
	}


}
