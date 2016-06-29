package Vista;

import java.io.File;
import java.util.ArrayList;

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
	public void inicializarTableroCielo(int[] posicionchispa) {
		// TODO Auto-generated method stub
		inicializarSuperficies();
		ubicarChispa(posicionchispa);
	}
	
	public void inicializarSuperficies() {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\imagenes\\superficiecielo");		
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
		tablerocielo.add(pic,posicionchispa[0],posicionchispa[1]);
		
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
