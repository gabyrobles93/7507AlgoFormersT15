package Vista.eventos;

import Modelo.Algoformer;
import Modelo.Casillero;
import Modelo.ErrorAlgoformerInexistente;
import Modelo.Juego;
import Modelo.Posicion;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonObjetivoAtacarHandler implements EventHandler<ActionEvent>{

	Juego juego;
	Algoformer algof;
	VistaAlgoformer vista;
	int fila;
	int columna;
	
	public BotonObjetivoAtacarHandler(Juego juego, Algoformer algof, int row, int column, VistaAlgoformer vista) {
		this.fila=row;
		this.columna=column;
		this.algof=algof;
		this.vista=vista;
		this.juego=juego;
	}

	@Override
	public void handle(ActionEvent event) {
		
		Casillero casAux;
		casAux=juego.getTablero().getCasillero(fila, columna);
		
		try{
		algof.atacar((Algoformer)(casAux.getMovilOcupa()));
		juego.jugarTurno();
		}catch(ErrorAlgoformerInexistente e){
			
			HBox hb=new HBox();
			Text txt=new Text("Error ataque imposible");
			hb.getChildren().add(txt);
			hb.setAlignment(Pos.CENTER);
			Scene sc=new Scene(hb,200,200);
			Stage st = new Stage();
			st.setTitle("Error");
			st.setScene(sc);
			st.setFullScreen(false);
			st.show();
			
		}
		
		vista.update();
	}
		
	

}
