package Vista;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	List<ImageView> listaReferencias;
	TableroController tableroController;
	
	
	public void inicializarTableroCielo(Tablero tablero, TableroController controladorTablero) {
		// TODO Auto-generated method stub
		this.tableroController=controladorTablero;
		listaReferencias = new ArrayList<ImageView>();
		inicializarSuperficies(tablero);
		ubicarChispa();
		ubicarAutobots();
		ubicarDecepticons();
	}

	private void ubicarAutobots() {
		VistaBumblebee vistaBumblebee=new VistaBumblebee(Bumblebee.getBumblebee(),tableroController);
		vistaBumblebee.dibujar();
		
		VistaOptimus vistaOptimus=new VistaOptimus(Optimus.getOptimus(),tableroController);
		vistaOptimus.dibujar();
			
		VistaRatchet vistaRatchet=new VistaRatchet(Ratchet.getRatchet(),tableroController);
		vistaRatchet.dibujar();
	}
	
	private void ubicarDecepticons() {
		VistaMegatron vistaMegatron=new VistaMegatron(Megatron.getMegatron(),tableroController);
		vistaMegatron.dibujar();
		
		VistaBonecrusher vistaBonecrusher=new VistaBonecrusher(Bonecrusher.getBonecrusher(),tableroController);
		vistaBonecrusher.dibujar();
		
		VistaFrenzy vistaFrenzy=new VistaFrenzy(Frenzy.getFrenzy(),tableroController);
		vistaFrenzy.dibujar();
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
	public void dibujarNodo(Node label, int columna, int fila) {
		// TODO Auto-generated method stub
		tablerocielo.add(label, columna, fila);
	}


	public void eliminarNodo(Node img) {
		// TODO Auto-generated method stub
		tablerocielo.getChildren().remove(img);
	}


	public void setReferenciasObjetivoMovimiento(List<ImageView> nuevaLista) {
		// TODO Auto-generated method stub
		listaReferencias.addAll(nuevaLista);	
	}
	
	public void borrarReferenciasObjetivoMovimiento(){
		
		Iterator iter = listaReferencias.iterator();
		
		while(iter.hasNext()){
			tablerocielo.getChildren().remove(iter.next());
		}
		listaReferencias.clear();
		
	}

	public void redibujarAlgoformers() {
		ubicarAutobots();
		ubicarDecepticons();		
	}
	
}


