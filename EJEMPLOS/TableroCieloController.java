package EJEMPLOS;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroCieloController {

	Stage stage;
	Scene proximaescena;
	@FXML private GridPane tablerocielo;
	@FXML private Button boton_ver_tierra;
	
	  public void updateGridPane() {
	        Label newLabel = new Label("GORDO GAY");
	        tablerocielo.add(newLabel, 10, 10);
	    }
		
		
		
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	
		public void inicializarTableroCielo(int[] posicionchispa) {
			// TODO Auto-generated method stub
			inicializarSuperficies();
			ubicarChispa(posicionchispa);
			inicializarBotones();
		}
		
		public void inicializarSuperficies() {
			// TODO Auto-generated method stub
			
			File file = new File("C:\\Users\\Gabriel\\workspace\\Algoformers\\src\\images\\superficiecielo");
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
					Image image = new Image(filelist2.get(0).toURI().toString());
					ImageView pic = new ImageView();
				    pic.setFitWidth(75);
				    pic.setFitHeight(75);
				    
				    pic.setImage(image);
					tablerocielo.add(pic,fila,columna);
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
						tablerocielo.add(pic,fila,columna);
					}
					
					if(randomNum == 5){
						Image image = new Image(filelist2.get(2).toURI().toString());
						ImageView pic = new ImageView();
					    pic.setFitWidth(75);
					    pic.setFitHeight(75);
					    
					    pic.setImage(image);
						tablerocielo.add(pic,fila,columna);
					}

				}
			}
			
			for( int fila = 20; fila < 31; fila++){
				
				for( int columna = 20; columna < 31; columna ++){
					
					int randomNum = 0 + (int)(Math.random() * 10);
					
					if(randomNum == 4 || randomNum == 8){
						Image image = new Image(filelist2.get(1).toURI().toString());
						ImageView pic = new ImageView();
					    pic.setFitWidth(75);
					    pic.setFitHeight(75);
					    
					    pic.setImage(image);
						tablerocielo.add(pic,fila,columna);
					}
					
					if(randomNum == 5){
						Image image = new Image(filelist2.get(2).toURI().toString());
						ImageView pic = new ImageView();
					    pic.setFitWidth(75);
					    pic.setFitHeight(75);
					    
					    pic.setImage(image);
						tablerocielo.add(pic,fila,columna);
					}

				}
			}
		}



		public void ubicarChispa(int[] posicionchispa) {
			// TODO Auto-generated method stub
			
			File file = new File("C:\\Users\\Gabriel\\workspace\\Algoformers\\src\\images\\chispapoder");
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
			tablerocielo.add(pic,posicionchispa[0],posicionchispa[1]);
			
		}

		private void inicializarBotones() {
			// TODO Auto-generated method stub
			boton_ver_tierra.setVisible(true);
			
			boton_ver_tierra.setVisible(true);	
			
			BotonVerTierraController botontierracontroller = new BotonVerTierraController(stage, proximaescena);
			
			boton_ver_tierra.setOnAction(botontierracontroller);
		}



		public void setStage(Stage primaryStage) {
			// TODO Auto-generated method stub
			stage = primaryStage;
		}



		public void setProximaEscena(Scene scene) {
			// TODO Auto-generated method stub
			proximaescena = scene;
		}

		
}
