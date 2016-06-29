package Vista;

import java.io.File;
import java.util.ArrayList;

import Modelo.Bonecrusher;
import Modelo.Bumblebee;
import Modelo.Frenzy;
import Modelo.Megatron;
import Modelo.Optimus;
import Modelo.Ratchet;
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
	public int[] inicializarTableroTierra(){
		
		inicializarSuperficies();
		ubicarAutobots();
		ubicarDecepticons();
		
		
		return ubicarChispa();
	}

	
	@FXML
	private int[] ubicarChispa() {
		
		int[] posicionchispa = new int[2];
		
		int posFila = 20 + (int)(Math.random() * 10);
		int posColumna = 20 + (int)(Math.random() * 10);
		
		posicionchispa[0] = posFila;
		posicionchispa[1] = posColumna;
		
		File file = new File("C:\\Users\\juancruz\\Desktop\\AlgoritmosIII\\TP2\\7507AlgoFormersT15\\Vista\\imagenes\\superficietierra");
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
		
		return posicionchispa;
	}
	
	private void ubicarDecepticons() {
		
		VistaAlgoformer vistaMegatron=new VistaMegatron(Megatron.getMegatron());
		vistaMegatron.dibujar(tablero_tierra);
		VistaAlgoformer vistaBonecrusher=new VistaBonecrusher(Bonecrusher.getBonecrusher());
		vistaBonecrusher.dibujar(tablero_tierra);
		VistaAlgoformer vistaFrenzy=new VistaFrenzy(Frenzy.getFrenzy());
		vistaFrenzy.dibujar(tablero_tierra);
		
	/*	
		File[] filelist1 = file.listFiles();
		ArrayList<File> filelist2 = new ArrayList<>();
		
		for (File file1 : filelist1) {
		     filelist2.add(file1);
		}
		
		
		Image imagebonecrusher = new Image(filelist2.get(0).toURI().toString());
		ImageView picbonecrusher = new ImageView();
		picbonecrusher.setFitWidth(75);
		picbonecrusher.setFitHeight(75);
	    
		picbonecrusher.setImage(imagebonecrusher);
		tablero_tierra.add(picbonecrusher,0,0);		
		
		Image imagefrenzy = new Image(filelist2.get(1).toURI().toString());
		ImageView picfrenzy = new ImageView();
		picfrenzy.setFitWidth(75);
		picfrenzy.setFitHeight(75);
	    
		picfrenzy.setImage(imagefrenzy);
		tablero_tierra.add(picfrenzy,0,2);
	
		Image imagemegatron = new Image(filelist2.get(2).toURI().toString());
		ImageView picmegatron = new ImageView();
		picmegatron.setFitWidth(75);
		picmegatron.setFitHeight(75);
	    
		picmegatron.setImage(imagemegatron);
		tablero_tierra.add(picmegatron,2,0);
	*/	
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
	private void inicializarSuperficies() {
		// TODO Auto-generated method stub

				File file = new File("C:\\Users\\juancruz\\Desktop\\AlgoritmosIII\\TP2\\7507AlgoFormersT15\\Vista\\imagenes\\superficietierra");
				File[] filelist1 = file.listFiles();
				ArrayList<File> filelist2 = new ArrayList<>();
				
				for (File file1 : filelist1) {
				     filelist2.add(file1);
				}

				int imageCol = 0;
				int imageRow = 0;
			
				for( int fila = 0; fila < 50; fila++){
					
					for( int columna = 0; columna < 50; columna ++){
						
						int randomNum = 0 + (int)(Math.random() * 3); 
						Image image = new Image(filelist2.get(2).toURI().toString());
						ImageView pic = new ImageView();
					    pic.setFitWidth(75);
					    pic.setFitHeight(75);
					    
					    pic.setImage(image);
						tablero_tierra.add(pic,fila,columna);
					}
				}
				
				imageCol = 0;
				imageRow = 0;
			
				for( int fila = 0; fila < 50; fila++){
					
					for( int columna = 0; columna < 50; columna ++){
						
						int randomNum = 0 + (int)(Math.random() * 30);
						
						if(randomNum == 4 || randomNum == 8){
							Image image = new Image(filelist2.get(1).toURI().toString());
							ImageView pic = new ImageView();
						    pic.setFitWidth(75);
						    pic.setFitHeight(75);
						    
						    pic.setImage(image);
						    tablero_tierra.add(pic,fila,columna);
						}
						
						if(randomNum == 5 || randomNum == 15){
							Image image = new Image(filelist2.get(0).toURI().toString());
							ImageView pic = new ImageView();
						    pic.setFitWidth(75);
						    pic.setFitHeight(75);
						    
						    pic.setImage(image);
						    tablero_tierra.add(pic,fila,columna);
						}

					}
				}
				
				for( int fila = 20; fila < 31; fila++){
					
					for( int columna = 20; columna < 31; columna ++){
						
						int randomNum = 0 + (int)(Math.random() * 10);
						
						if(randomNum == 4 || randomNum == 8){
							Image image = new Image(filelist2.get(0).toURI().toString());
							ImageView pic = new ImageView();
						    pic.setFitWidth(75);
						    pic.setFitHeight(75);
						    
						    pic.setImage(image);
							tablero_tierra.add(pic,fila,columna);
						}
						
						if(randomNum == 5){
							Image image = new Image(filelist2.get(1).toURI().toString());
							ImageView pic = new ImageView();
						    pic.setFitWidth(75);
						    pic.setFitHeight(75);
						    
						    pic.setImage(image);
						    tablero_tierra.add(pic,fila,columna);
						}

					}
				}
	
	}
	public ScrollPane getScrollPane(){
		return scrollpane;
	}
	
}
