package Vista;

import Modelo.Algoformer;
import Modelo.Juego;
import Modelo.Tablero;
import Vista.eventos.BotonObjetivoMovimientoHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaTerreno {
	
	private final GridPane tab;
	private final Juego juego;
	
	private final ContenedorPrincipal contenedor;
	//private Tablero tablero;
	

	public VistaTerreno(Juego juego, GridPane paneCentral,ContenedorPrincipal contenedor) {
		this.tab=paneCentral;
		this.juego=juego;
		this.contenedor=contenedor;
		//this.tablero=tablero;
	}


	 public void dibujar() {
		 this.clean();
		 contenedor.ModoSeleccionar(true);
	        this.dibujarFormas();
	        VistaAlgoformer vistaAlgof=new VistaAlgoformer(juego.getAutobots().getOptimus(),tab,"O", contenedor,juego,this);
	        vistaAlgof.dibujar();
	       
	        VistaAlgoformer vistaAlgof2=new VistaAlgoformer(juego.getAutobots().getBumblebee(),tab,"B", contenedor,juego,this);
	        vistaAlgof2.dibujar();
	        
	        VistaAlgoformer vistaAlgof3=new VistaAlgoformer(juego.getAutobots().getRatchet(),tab,"R", contenedor,juego,this);
	        vistaAlgof3.dibujar();
	    }

	    private void dibujarFormas() {
	    	
	    	  
	    	        for (int column = 0; column < 50; column++) {
	    	            for (int row = 0 ; row < 50; row++) {
	    	            	Rectangle rect = new Rectangle(25,25);
	    	            	
	    	            	//VistaSuperficie vistaSup= new VistaSuperficie(tablero.getCasillero(row, column),rect);
	    	            	
	    	            	rect.setFill(Color.TRANSPARENT);
	    	            	rect.setStroke(Color.BLACK);
	    	            	
	    	            	
	    	       
	    	                GridPane.setConstraints(rect, column, row);
	    	                tab.getChildren().add(rect);
	    	            }
	    	        }

	    	      
	    	       

	    	    }
	    	
	        //canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
	    

	    public void clean() {
	    		
	        //canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
	        //canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
	    }


		public void dibujarZonaObjetivoMovimiento(Algoformer algof,VistaAlgoformer vista) {
			
		int distanciaACubrir=algof.getVelocidad();
		int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
		int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
		
		int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
		int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
		
			 for (int column=minColumn; column<maxColumn; column++) {
 	            for (int row = minFila ; row<maxFila; row++) {
 	            	
 	            	BotonObjetivoMovimientoHandler handler = new BotonObjetivoMovimientoHandler(algof,row,column,vista);
 	            	Button botonObjetivoMovimiento = new Button("");
 	            	botonObjetivoMovimiento.setOnAction(handler);
 	       
 	                GridPane.setConstraints(botonObjetivoMovimiento, column, row);
 	                tab.getChildren().add(botonObjetivoMovimiento);
 	            }
 	        }
			
		}
	

}
