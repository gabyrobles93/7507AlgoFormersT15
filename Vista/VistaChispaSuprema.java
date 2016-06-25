package Vista;

import Modelo.ChispaSuprema;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VistaChispaSuprema {
	
	final GridPane tablero;
	private VistaTerreno vista;
	private final ChispaSuprema chispa;
	
	public VistaChispaSuprema(ChispaSuprema chispa,GridPane tablero,VistaTerreno vista){
		this.tablero=tablero;
		this.vista=vista;
		this.chispa=chispa;
	}
	public void dibujar(){
		Button botonChispa=new Button("C");
		botonChispa.setTextFill(Color.YELLOW);
		GridPane.setConstraints(botonChispa, chispa.getPosicion().getColumna(), chispa.getPosicion().getFila());
		tablero.getChildren().add(botonChispa);
		
	}

}
