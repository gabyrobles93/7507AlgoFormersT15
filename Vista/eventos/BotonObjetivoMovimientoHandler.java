package Vista.eventos;

import Modelo.Algoformer;
import Modelo.Posicion;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BotonObjetivoMovimientoHandler implements EventHandler<ActionEvent>{
private final int fila;
private final int columna;
private Algoformer algof;
private final VistaAlgoformer tab;
	
	public BotonObjetivoMovimientoHandler(Algoformer algof,int fila,int columna,VistaAlgoformer tab){
		this.fila=fila;
		this.columna=columna;
		this.algof=algof;
		this.tab=tab;
	}
	@Override
	public void handle(ActionEvent arg0) {
		Posicion pos= new Posicion(fila,columna);
		try{
		algof.mover(pos);
		}catch(RuntimeException e){
			
			HBox hb=new HBox();
			Text txt=new Text("Los Casilleros deben estar desocupados y conectados por una linea recta");
			hb.getChildren().add(txt);
			hb.setAlignment(Pos.CENTER);
			Scene sc=new Scene(hb,200,200);
			Stage st = new Stage();
			st.setTitle("Error");
			st.setScene(sc);
			st.setFullScreen(false);
			st.show();
			
		}
		tab.update();
		
		
		
	}

}
