package Vista;

import java.io.File;

import Modelo.ChispaSuprema;
import Modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VistaChispaSuprema {
	
	
	
	public VistaChispaSuprema(){
		
	}
	public void dibujar(GridPane tablero){

		File file = new File("C:\\imagenes\\chispapoder\\chispapoder.png");
	
		Image image = new Image(file.toURI().toString());
		ImageView pic = new ImageView();
	    pic.setFitWidth(75);
	    pic.setFitHeight(75);
	    
	    pic.setImage(image);
		tablero.add(pic,Juego.chispa.getPosicion().getColumna(),Juego.chispa.getPosicion().getFila());
		
	}

}
