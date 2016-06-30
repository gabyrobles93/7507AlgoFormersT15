package Vista.Controlador;

import Modelo.Algoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Vista.VistaTerreno;

public class BotonCapturarChispaHandler implements EventHandler<ActionEvent>{

	final Algoformer algof;
	VistaTerreno tab;
	 Scene proximaEscena;
	 Stage stage;
	
	public BotonCapturarChispaHandler(Stage stage,Algoformer algof,VistaTerreno tab,Scene proximaEscena){
		this.algof=algof;
		this.tab=tab;
		this.proximaEscena=proximaEscena;
		this.stage=stage;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		try{
			algof.capturarChispa();
			stage.setScene(proximaEscena);
		}catch(RuntimeException e){
			HBox hb=new HBox();
			Text txt=new Text("Error imposible capturar Chispa");
			hb.getChildren().add(txt);
			hb.setAlignment(Pos.CENTER);
			Scene sc=new Scene(hb,200,200);
			Stage st = new Stage();
			st.setTitle("Error");
			st.setScene(sc);
			st.setFullScreen(false);
			st.show();
		}
		
	}

}
