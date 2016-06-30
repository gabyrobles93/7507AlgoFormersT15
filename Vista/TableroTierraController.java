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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableroTierraController {

	Stage stage;
	Scene proximaescena;
	
	@FXML private GridPane tablero_tierra;
	@FXML private ScrollPane scrollpane;

	
	@FXML
	public void inicializarTableroTierra(Tablero tablero){
		
		
		
		inicializarSuperficies(tablero);
		ubicarAutobots();
		ubicarDecepticons();
		ubicarChispa();
		
	}

	
	@FXML

	public void ubicarChispa() {

		VistaChispaSuprema vistaChispa=new VistaChispaSuprema();
		vistaChispa.dibujar(tablero_tierra);

	}
	
	private void ubicarDecepticons() {
		
		//VistaAlgoformer vistaMegatron=new VistaMegatron(Megatron.getMegatron());
	//	vistaMegatron.dibujar(tablero_tierra);
	//	VistaAlgoformer vistaBonecrusher=new VistaBonecrusher(Bonecrusher.getBonecrusher());
	//	vistaBonecrusher.dibujar(tablero_tierra);
	//	VistaAlgoformer vistaFrenzy=new VistaFrenzy(Frenzy.getFrenzy());
		//vistaFrenzy.dibujar(tablero_tierra);
		

	}
	@FXML
	private void ubicarAutobots() {
	//	VistaAlgoformer vistaOptimus=new VistaOptimus(Optimus.getOptimus());
		//vistaOptimus.dibujar(tablero_tierra);
		VistaAlgoformer vistaBumblebee=new VistaAlgoformer(this);
	
		vistaBumblebee.dibujar(tablero_tierra);
	//	VistaAlgoformer vistaRatchet=new VistaRatchet(Ratchet.getRatchet());
		//vistaRatchet.dibujar(tablero_tierra);
	}
	@FXML
	private void inicializarSuperficies(Tablero tablero) {
		// TODO Auto-generated method stub


			
				for( int fila = 0; fila < 50; fila++){
					
					for( int columna = 0; columna < 50; columna ++){
					
					VistaSuperficie vista=VistaSuperficie.crearVista(tablero.getCasillero(fila, columna).getSuperficieTierra());
					vista.dibujar(tablero_tierra,fila,columna);
					
					}
				}
				
			
	}
	public ScrollPane getScrollPane(){
		return scrollpane;
	}


	public void dibujarNodo(Node label, int columna, int fila) {
		// TODO Auto-generated method stub
		tablero_tierra.add(label, columna, fila);
	}


	public void eliminarNodo(Node img) {
		// TODO Auto-generated method stub
		tablero_tierra.getChildren().remove(img);
	}
	
}
