package Vista;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import Modelo.Bonecrusher;
import Modelo.Bumblebee;
import Modelo.Frenzy;
import Modelo.Juego;
import Modelo.Megatron;
import Modelo.Optimus;
import Modelo.Ratchet;
import Modelo.Tablero;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class TableroTierraController implements Initializable{

	Stage stage;
	Scene proximaescena;
	List<ImageView> listaReferencias;
	
	@FXML private GridPane tablero_tierra;
	@FXML private ScrollPane scrollpane;
	private TableroController tableroController;
	@FXML
	public void TableroTierraControler(){
		
	}
	public void inicializarTableroTierra(Tablero tablero,TableroController tableroController){
		this.tableroController=tableroController;
		
		
		inicializarSuperficiesTierra(tablero);
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
		VistaBumblebee vistaBumblebee=new VistaBumblebee(Bumblebee.getBumblebee(),tableroController);
	
		vistaBumblebee.dibujar();
	//	VistaAlgoformer vistaRatchet=new VistaRatchet(Ratchet.getRatchet());
		//vistaRatchet.dibujar(tablero_tierra);
	}
	@FXML
	public void inicializarSuperficiesTierra(Tablero tablero) {
		// TODO Auto-generated method stub

tablero_tierra.getChildren().clear();
			
				for( int fila = 0; fila < 50; fila++){
					
					for( int columna = 0; columna < 50; columna ++){
					
					VistaSuperficie vista=VistaSuperficie.crearVista(tablero.getCasillero(fila, columna).getSuperficieTierra());
					vista.dibujar(tablero_tierra,fila,columna);
					
					}
				}
				
			
	}
	public void inicializarSuperficiesCielo(Tablero tablero) {
		// TODO Auto-generated method stub
		tablero_tierra.getChildren().clear();

			
				for( int fila = 0; fila < 50; fila++){
					
					for( int columna = 0; columna < 50; columna ++){
					
					VistaSuperficie vista=VistaSuperficie.crearVista(tablero.getCasillero(fila, columna).getSuperficieCielo());
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


	public void setReferenciasObjetivoMovimiento(List<ImageView> nuevaLista) {
		// TODO Auto-generated method stub
		listaReferencias.addAll(nuevaLista);	
	}
	
	public void borrarReferenciasObjetivoMovimiento(){
		
		Iterator iter = listaReferencias.iterator();
		
		while(iter.hasNext()){
			tablero_tierra.getChildren().remove(iter.next());
		}
		listaReferencias.clear();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listaReferencias = new ArrayList<ImageView>();
	}
	public void setListaRef(ArrayList<ImageView> lista){
		listaReferencias=lista;
	}
	
}
