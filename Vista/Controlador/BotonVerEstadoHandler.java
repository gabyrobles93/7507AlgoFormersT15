package Vista.Controlador;

import Modelo.Algoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonVerEstadoHandler implements EventHandler<ActionEvent> {
	
	private Algoformer algof;
	
	public BotonVerEstadoHandler(Algoformer algof){
		this.algof=algof;
	}

	@Override
	public void handle(ActionEvent event) {
		
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
