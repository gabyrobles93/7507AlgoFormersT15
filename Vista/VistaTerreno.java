package Vista;

import Modelo.Algoformer;
import Modelo.Equipo;
import Modelo.Juego;
import Modelo.Tablero;
import Vista.eventos.BotonAtacarHandler;
import Vista.eventos.BotonObjetivoAtacarHandler;
import Vista.eventos.BotonObjetivoMovimientoHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

public class VistaTerreno {
	
	private final GridPane tab;
	private  Equipo equipoJugador;
	private Juego juego;
	private final ContenedorPrincipal contenedor;
	//private Tablero tablero;
	private boolean ModoRango;
	private Equipo equipoExpectador;
	private Stage stage;
	

	public VistaTerreno(Stage stage,Juego juego, GridPane paneCentral,ContenedorPrincipal contenedor) {
		this.tab=paneCentral;
		//this.equipoJugador=equipoJugador;
		this.contenedor=contenedor;
		//this.equipoExpectador=equipoExpectador;
		//this.tablero=tablero;
		this.juego=juego;
		this.stage=stage;
	}


	 public void dibujar() {
		 this.clean();
		
	        this.dibujarFormas();
	        VistaChispaSuprema vistaChispa=new VistaChispaSuprema(Juego.chispa,tab,this);
			 vistaChispa.dibujar();
	        
	       VistaEquipo vistaEq= VistaEquipo.getVistaEquipo(stage,juego,juego.getEjecutorDeTurnoActual(),tab,contenedor,this);
	       vistaEq.dibujarBotonesJugador();
	       
	       Equipo eqJugador=juego.getEjecutorDeTurnoActual();
	       Equipo eqExpectador;
	       if(eqJugador==juego.getAutobots()){
	    	   eqExpectador=juego.getDecepticons();
	    	  
	       }else {
	    	   eqExpectador=juego.getAutobots();
	       }
	       VistaEquipo vistaEqExpectador=VistaEquipo.getVistaEquipo(stage,juego,eqExpectador,tab,contenedor,this);
	       vistaEqExpectador.dibujarImagenEnemigo();
	       
	        /* VistaEquipo vistaEqJug=new VistaEquipo(equipoJugador,tab,contenedor,this);
	        vistaEqJug.dibujarBotonesJugador();
	        VistaEquipo vistaEqExp=new VistaEquipo(equipoExpectador,tab,contenedor,this);
	        vistaEqExp.dibujarBotones*/
	    }

	    private void dibujarFormas() {
	    	
	    	  
	    	        for (int column = 0; column < 50; column++) {
	    	            for (int row = 0 ; row < 50; row++) {
	    	            	Rectangle rect = new Rectangle(10,10);
	    	            	
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
		
		//contenedor.setModoRango(true);
			
		int distanciaACubrir=algof.getVelocidad();
		int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
		int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
		
		int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
		int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
		
			 for (int column=minColumn; column<=maxColumn; column++) {
 	            for (int row = minFila ; row<=maxFila; row++) {
 	            	
 	            	BotonObjetivoMovimientoHandler handler = new BotonObjetivoMovimientoHandler(juego,algof,row,column,vista);
 	            	Button botonObjetivoMovimiento = new Button("");
 	            	botonObjetivoMovimiento.setOnAction(handler);
 	       
 	                GridPane.setConstraints(botonObjetivoMovimiento, column, row);
 	                tab.getChildren().add(botonObjetivoMovimiento);
 	            }
 	        }
			
		}


		public boolean ModoRango() {
			// TODO Auto-generated method stub
			return ModoRango;
		}


		public void setModoRango(boolean b) {
			ModoRango=b;
			if(ModoRango==true){
				
			}else {
				dibujar();
			}
			
		}


		public void dibujarZonaObjetivoAtaque(Algoformer algof,VistaAlgoformer vista) {
			//contenedor.setModoRango(true);
			
			int distanciaACubrir=algof.getDistanciaDeAtaque();
			int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
			int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
			
			int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
			int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
			
				 for (int column=minColumn; column<=maxColumn; column++) {
	 	            for (int row = minFila ; row<=maxFila; row++) {
	 	            	ContenedorJuegoFinalizado contenedorFinal= new ContenedorJuegoFinalizado(stage,juego);
	 	       		Scene escenaFinal =new Scene(contenedorFinal);
	 	            	
	 	            	BotonObjetivoAtacarHandler handler = new BotonObjetivoAtacarHandler(juego,algof,row,column,vista,escenaFinal,stage);
	 	            	Button botonObjetivoAtaque = new Button("");
	 	            	botonObjetivoAtaque.setOnAction(handler);
	 	       
	 	                GridPane.setConstraints(botonObjetivoAtaque, column, row);
	 	                tab.getChildren().add(botonObjetivoAtaque);
	 	            }
	 	        }
				
			
		}
	

}
