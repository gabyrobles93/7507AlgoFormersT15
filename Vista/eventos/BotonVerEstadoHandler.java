package Vista.eventos;

import Modelo.Algoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonVerEstadoHandler implements EventHandler<ActionEvent> {
	private Algoformer algof;
	public BotonVerEstadoHandler(Algoformer algof){
		this.algof=algof;
	}

	@Override
	public void handle(ActionEvent event) {
		HBox hb=new HBox();
		Text txt=new Text(String.valueOf(algof.getVida()));
		
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Estado del Algoformer");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
		
		
	}

}
