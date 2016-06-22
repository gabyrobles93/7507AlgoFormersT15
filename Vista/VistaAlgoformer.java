package Vista;

import java.util.Iterator;

import Modelo.Algoformer;
import Modelo.Juego;
import Vista.eventos.BotonMoverHandler;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import src.modelo.Robot;

public class VistaAlgoformer {
	private Juego juego;
	private Algoformer algof;
	final GridPane tablero;
	String nombre;
	private final ContenedorPrincipal contenedor;
	private VistaTerreno vista;
	 public VistaAlgoformer(Algoformer algof, GridPane paneCentral,String nombre,ContenedorPrincipal contenedor,Juego juego,VistaTerreno vista) {
	        this.algof = algof;
	        this.tablero = paneCentral;
	        this.nombre=nombre;
	        this.contenedor=contenedor;
	        this.juego=juego;
	        this.vista=vista;
	    }
	public void dibujar() {
		
		MenuItem mi=new MenuItem("atacar");
		MenuItem mi2=new MenuItem("mover");
		MenuButton algo =new MenuButton(nombre,null,mi,mi2);
		algo.setTextFill(Color.AZURE);
		
		
		
		BotonMoverHandler boton=new BotonMoverHandler(vista,algof,contenedor, this);
		mi2.setOnAction(boton);
		
		
		GridPane.setConstraints(algo, algof.getPosicion().getColumna(), algof.getPosicion().getFila());
		tablero.getChildren().add(algo);
		
	}
	public void update() {
		tablero.getChildren().clear();
		vista.dibujar();
		
	}
	public void resaltar() {
		
		
	}
	public void resaltarZonaDeAtaque() {
		// TODO Auto-generated method stub
		
	}


}
