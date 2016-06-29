package EJEMPLOS;

import java.awt.event.MouseAdapter;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Vista.Controlador.menuAccionesAlgoformerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroTierraController implements Initializable {

	Stage stage;
	Scene proximaescena;
	@FXML private GridPane tablerotierra;
	@FXML private Button boton_ver_cielo;
	
	menuAccionesAlgoformerController menuacciones;

    public void updateGridPane() {
        Label newLabel = new Label("GORDO GAY");
        tablerotierra.add(newLabel, 10, 10);
    }
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public int[] inicializarTableroTierra(){
		
		menuacciones = new menuAccionesAlgoformerController();
		
		inicializarSuperficies();
		ubicarAutobots();
		ubicarDecepticons();
		inicializarBotones();
		
		return ubicarChispa();
	}

	public void inicializarSuperficies() {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\Gabriel\\workspace\\Algoformers\\src\\images\\superficietierra");
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
				tablerotierra.add(pic,fila,columna);
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
				    tablerotierra.add(pic,fila,columna);
				}
				
				if(randomNum == 5 || randomNum == 15){
					Image image = new Image(filelist2.get(0).toURI().toString());
					ImageView pic = new ImageView();
				    pic.setFitWidth(75);
				    pic.setFitHeight(75);
				    
				    pic.setImage(image);
				    tablerotierra.add(pic,fila,columna);
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
					tablerotierra.add(pic,fila,columna);
				}
				
				if(randomNum == 5){
					Image image = new Image(filelist2.get(1).toURI().toString());
					ImageView pic = new ImageView();
				    pic.setFitWidth(75);
				    pic.setFitHeight(75);
				    
				    pic.setImage(image);
				    tablerotierra.add(pic,fila,columna);
				}

			}
		}
		
		

	}



	int[] ubicarChispa() {
		int[] posicionchispa = new int[2];
		
		int posFila = 20 + (int)(Math.random() * 10);
		int posColumna = 20 + (int)(Math.random() * 10);
		
		posicionchispa[0] = posFila;
		posicionchispa[1] = posColumna;
		
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
		tablerotierra.add(pic,posFila,posColumna);
		
		return posicionchispa;
	}



	public void ubicarAutobots() {
		
		
		File file = new File("C:\\Users\\Gabriel\\workspace\\Algoformers\\src\\images\\autobots\\humanoide");
		File[] filelist1 = file.listFiles();
		ArrayList<File> filelist2 = new ArrayList<>();
		
		for (File file1 : filelist1) {
		     filelist2.add(file1);
		}
		
		Image imagebumblebee = new Image(filelist2.get(0).toURI().toString());
		ImageView picbumblebee = new ImageView();
		picbumblebee.setFitWidth(75);
		picbumblebee.setFitHeight(75);
	    
		picbumblebee.setImage(imagebumblebee);
		picbumblebee.setOnMouseClicked(menuacciones);
		tablerotierra.add(picbumblebee,49,49);

		
		Image imageoptimus = new Image(filelist2.get(1).toURI().toString());
		ImageView picoptimus = new ImageView();
		picoptimus.setFitWidth(75);
		picoptimus.setFitHeight(75);
	    
		picoptimus.setImage(imageoptimus);
		picoptimus.setOnMouseClicked(menuacciones);
		tablerotierra.add(picoptimus,47,49);

		
		Image imageratchet = new Image(filelist2.get(2).toURI().toString());
		ImageView picratchet = new ImageView();
		picratchet.setFitWidth(75);
		picratchet.setFitHeight(75);
	    
		picratchet.setImage(imageratchet);
		picratchet.setOnMouseClicked(menuacciones);
		tablerotierra.add(picratchet,49,47);
	}
	
	public void ubicarDecepticons() {
		
		File file = new File("C:\\Users\\Gabriel\\workspace\\Algoformers\\src\\images\\decepticons\\humanoide");
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
		picbonecrusher.setOnMouseClicked(menuacciones);
		tablerotierra.add(picbonecrusher,0,0);		
		
		Image imagefrenzy = new Image(filelist2.get(1).toURI().toString());
		ImageView picfrenzy = new ImageView();
		picfrenzy.setFitWidth(75);
		picfrenzy.setFitHeight(75);
	    
		picfrenzy.setImage(imagefrenzy);
		picfrenzy.setOnMouseClicked(menuacciones);
		tablerotierra.add(picfrenzy,0,2);
	
		Image imagemegatron = new Image(filelist2.get(2).toURI().toString());
		ImageView picmegatron = new ImageView();
		picmegatron.setFitWidth(75);
		picmegatron.setFitHeight(75);
	    
		picmegatron.setImage(imagemegatron);
		picmegatron.setOnMouseClicked(menuacciones);
		tablerotierra.add(picmegatron,2,0);
	}

	public void inicializarBotones() {
		
		boton_ver_cielo.setVisible(true);	
		
		BotonVerCieloController botoncielocontroller = new BotonVerCieloController(stage, proximaescena);
		
		boton_ver_cielo.setOnAction(botoncielocontroller);

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
