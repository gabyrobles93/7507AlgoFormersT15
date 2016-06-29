package Vista;

import java.io.File;
import java.util.ArrayList;

import Modelo.Bonecrusher;
import Modelo.Bumblebee;
import Modelo.Frenzy;
import Modelo.Juego;
import Modelo.Megatron;
import Modelo.Optimus;
import Modelo.Ratchet;
import Modelo.Tablero;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroCieloController {

	Stage stage;
	Scene proximaescena;
	@FXML private GridPane tablerocielo;
	@FXML private ScrollPane scrollpane;
	
	@FXML
	public void inicializarTableroCielo(Tablero tablero) {
		// TODO Auto-generated method stub
		inicializarSuperficies(tablero);
		ubicarChispa();
		ubicarAutobots();
		ubicarDecepticons();
	}

	private void ubicarAutobots() {
		VistaAlgoformer vistaOptimus=new VistaOptimus(Optimus.getOptimus());
		vistaOptimus.dibujar(tablerocielo);
		VistaAlgoformer vistaBumblebee=new VistaBumblebee(Bumblebee.getBumblebee());
		vistaBumblebee.dibujar(tablerocielo);
		VistaAlgoformer vistaRatchet=new VistaRatchet(Ratchet.getRatchet());
		vistaRatchet.dibujar(tablerocielo);
	}
private void ubicarDecepticons() {
	

		
		VistaAlgoformer vistaMegatron=new VistaMegatron(Megatron.getMegatron());
		vistaMegatron.dibujar(tablerocielo);
		VistaAlgoformer vistaBonecrusher=new VistaBonecrusher(Bonecrusher.getBonecrusher());
		vistaBonecrusher.dibujar(tablerocielo);
		VistaAlgoformer vistaFrenzy=new VistaFrenzy(Frenzy.getFrenzy());
		vistaFrenzy.dibujar(tablerocielo);
		

	}
	
	public void inicializarSuperficies(Tablero tablero) {
		// TODO Auto-generated method stub
		
	
	
		for( int fila = 0; fila < 50; fila++){
			
			for( int columna = 0; columna < 50; columna ++){
				VistaSuperficie vista=VistaSuperficie.crearVista(tablero.getCasillero(fila, columna).getSuperficieCielo());
				vista.dibujar(tablerocielo,fila,columna);
			}
		}
	
	}

	

	public void ubicarChispa() {

		VistaChispaSuprema vistaChispa=new VistaChispaSuprema();
		vistaChispa.dibujar(tablerocielo);

	
		
		
	}

	public void setProximaEscena(Scene vistaTierra) {
		// TODO Auto-generated method stub
		proximaescena = vistaTierra;
	}

	public void setStage(Stage mainStage) {
		
		stage = mainStage;
	}
	public ScrollPane getScrollPane(){
		return scrollpane;
	}
	
}
