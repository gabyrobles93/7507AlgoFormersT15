package Vista.Controlador;

import Modelo.Algoformer;
import Modelo.Casillero;
import Modelo.ErrorAlgoformerInexistente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.Juego;
import Modelo.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Vista.VistaAlgoformer;
import Vista.VistaAlgoformerController;
import Vista.VistaBumblebeeController;
import Vista.VistaTerreno;
import Vista.menuAccionesAlgoformerController;
import Vista.Aplicacion;

public class BotonObjetivoAtacarHandler implements EventHandler<MouseEvent>{

	Algoformer algof;
	VistaAlgoformerController vista;
	int fila;
	int columna;
	Scene escenaFinal;
	Stage stage;
	menuAccionesAlgoformerController menuAccionesController;
	
	public BotonObjetivoAtacarHandler(Algoformer algof, int row, int column, VistaAlgoformerController vistaAlgof, menuAccionesAlgoformerController menuAccionesController) {
		this.fila=row;
		this.columna=column;
		this.algof=algof;
		this.vista=vistaAlgof;
	
		this.stage=stage;
		this.escenaFinal=escenaFinal;
		this.menuAccionesController=menuAccionesController;
	}

	@Override
	public void handle(MouseEvent event) {
		
		Casillero casAux;
		casAux=Aplicacion.juego.getTablero().getCasillero(fila, columna);
		
		try{
		algof.atacar((Algoformer)(casAux.getMovilOcupa()));
		vista.update();
		menuAccionesController.borrarZonaObjetivoMovimiento();
		
		/*if(juego.getGanador()!=null){
			stage.setScene(escenaFinal);
		}*/
		//juego.jugarTurno();
		}catch(ErrorAlgoformerInexistente e){
			
			HBox hb=new HBox();
			Text txt=new Text("Error, no hay ninguna victima en ese casillero");
			hb.getChildren().add(txt);
			hb.setAlignment(Pos.CENTER);
			Scene sc=new Scene(hb,200,200);
			Stage st = new Stage();
			st.setTitle("Error");
			st.setScene(sc);
			st.setFullScreen(false);
			st.show();
			
		}catch(ErrorNoSePuedeAtacarIntegranteDeEquipo e){
			HBox hb=new HBox();
			Text txt=new Text("Error, no puedes atacar otro algoformer de tu mismo equipo");
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
