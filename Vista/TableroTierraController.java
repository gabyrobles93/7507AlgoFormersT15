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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
<<<<<<< HEAD
	public void ubicarChispa() {

		VistaChispaSuprema vistaChispa=new VistaChispaSuprema();
		vistaChispa.dibujar(tablero_tierra);
=======
	private int[] ubicarChispa() {
		
		int[] posicionchispa = new int[2];
		
		int posFila = 20 + (int)(Math.random() * 10);
		int posColumna = 20 + (int)(Math.random() * 10);
		
		posicionchispa[0] = posFila;
		posicionchispa[1] = posColumna;
		
		File file = new File("C:\\imagenes\\chispapoder");
		File[] filelist1 = file.listFiles();
		ArrayList<File> filelist2 = new ArrayList<>();
		
		for (File file1 : filelist1) {
		     filelist2.add(file1);
		}
		
		Image image = new Image(filelist2.get(0).toURI().toString());
		ImageView pic = new ImageView();
	    pic.setFitWidth(75);
	    pic.setFitHeight(75);
	    
	    pic.setImage(image);
		tablero_tierra.add(pic,posFila,posColumna);
>>>>>>> e3f7fc3db9f93e4284a7e5b78d16a63d454ec8df
		
	}
	
	private void ubicarDecepticons() {
		
		VistaAlgoformer vistaMegatron=new VistaMegatron(Megatron.getMegatron());
		vistaMegatron.dibujar(tablero_tierra);
		VistaAlgoformer vistaBonecrusher=new VistaBonecrusher(Bonecrusher.getBonecrusher());
		vistaBonecrusher.dibujar(tablero_tierra);
		VistaAlgoformer vistaFrenzy=new VistaFrenzy(Frenzy.getFrenzy());
		vistaFrenzy.dibujar(tablero_tierra);
		

	}
	@FXML
	private void ubicarAutobots() {
		VistaAlgoformer vistaOptimus=new VistaOptimus(Optimus.getOptimus());
		vistaOptimus.dibujar(tablero_tierra);
		VistaAlgoformer vistaBumblebee=new VistaBumblebee(Bumblebee.getBumblebee());
		vistaBumblebee.dibujar(tablero_tierra);
		VistaAlgoformer vistaRatchet=new VistaRatchet(Ratchet.getRatchet());
		vistaRatchet.dibujar(tablero_tierra);
	}
	@FXML
	private void inicializarSuperficies(Tablero tablero) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
=======

				File file = new File("C:\\imagenes\\superficietierra");
				File[] filelist1 = file.listFiles();
				ArrayList<File> filelist2 = new ArrayList<>();
				
				for (File file1 : filelist1) {
				     filelist2.add(file1);
				}

				int imageCol = 0;
				int imageRow = 0;
>>>>>>> e3f7fc3db9f93e4284a7e5b78d16a63d454ec8df
			
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
	
}
