package Vista;

import java.util.Iterator;

import Modelo.Algoformer;
import Modelo.Juego;
import Vista.Controlador.BotonAtacarHandler;
import Vista.Controlador.BotonCambiarModoHandler;
import Vista.Controlador.BotonCapturarChispaHandler;
import Vista.Controlador.BotonMoverHandler;
import Vista.Controlador.BotonSeleccionarAlgoformerEventHandler;
import Vista.Controlador.BotonVerEstadoHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class VistaAlgoformer {

	protected Algoformer algof;
	GridPane tablero;
	/*String nombre;
	private  ContenedorPrincipal contenedor;
	private VistaTerreno vista;
	Stage stage;*/
	
	 public VistaAlgoformer(Stage stage,Algoformer algof, GridPane paneCentral,String nombre,ContenedorPrincipal contenedor,Juego juego,VistaTerreno vista) {
	       /* this.algof = algof;
	        this.tablero = paneCentral;
	        this.nombre=nombre;
	        this.contenedor=contenedor;
	        this.juego=juego;
	        this.vista=vista;
	        this.stage=stage;*/
	    }
	public VistaAlgoformer() {
		// TODO Auto-generated constructor stub
	}
	public void dibujar(GridPane tablero_tierra) {
		/*if(algof.getVida()==0){
			return;
		}
		if(algof.getEfecto().esperaturnos!=0){
			dibujarImagen(nombre,Color.GREEN);
			return;
		}
		
		MenuItem mi=new MenuItem("atacar");
		MenuItem mi2=new MenuItem("mover");
		MenuItem mi3 =new MenuItem("cambiar modo");
		MenuItem verEstado =new MenuItem("ver estado");
		MenuItem capturarChispa =new MenuItem("capturar chispa");
		
		MenuButton algo =new MenuButton(nombre,null,mi,mi2,mi3,verEstado,capturarChispa);
		algo.setTextFill(Color.AZURE);
		//BotonSeleccionarAlgoformerEventHandler handlerSeleccionar= new BotonSeleccionarAlgoformerEventHandler();
		//algo.setOnAction(handlerSeleccionar);
		ContenedorJuegoFinalizado contenedorFinal= new ContenedorJuegoFinalizado(stage,juego);
		Scene escenaFinal =new Scene(contenedorFinal);
		
		BotonCapturarChispaHandler handlerCapturarChispa=new BotonCapturarChispaHandler(stage,this.algof,this.vista,escenaFinal);
		capturarChispa.setOnAction(handlerCapturarChispa);
		
		BotonMoverHandler handlerMover=new BotonMoverHandler(vista,algof,contenedor, this);
		mi2.setOnAction(handlerMover);
		
		BotonAtacarHandler handlerAtacar=new BotonAtacarHandler(vista,algof,this);
		mi.setOnAction(handlerAtacar);
		
		BotonCambiarModoHandler handlerCambiarModo= new BotonCambiarModoHandler(vista,algof,this);
		mi3.setOnAction(handlerCambiarModo);
		
		BotonVerEstadoHandler botonHandler=new BotonVerEstadoHandler(algof);
		verEstado.setOnAction(botonHandler);
		
		GridPane.setConstraints(algo, algof.getPosicion().getColumna(), algof.getPosicion().getFila());
		
		*/
		
	}
	public void update() {
		tablero.getChildren().clear();
		//vista.dibujar();
		
	}
	public void resaltar() {
		
		
	}
	public void resaltarZonaDeAtaque() {
		// TODO Auto-generated method stub
		
	}
	public void dibujarImagen(String string,Color color) {
	/*	if(algof.getVida()==0){
			return;
		}
		
		MenuItem verEstado =new MenuItem("ver estado");
		
		BotonVerEstadoHandler botonHandler=new BotonVerEstadoHandler(algof);
		verEstado.setOnAction(botonHandler);
		MenuButton button = new MenuButton(string,null,verEstado);
		
		button.setTextFill(color);
		
		GridPane.setConstraints(button, algof.getPosicion().getColumna(), algof.getPosicion().getFila());
		tablero.getChildren().add(button);
	*/	
	}
	public void actualizarAlgof(Algoformer algof2) {
		// TODO Auto-generated method stub
		this.algof=algof2;
	}


}
