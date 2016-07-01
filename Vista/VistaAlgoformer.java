package Vista;

import java.io.IOException;
import java.util.Iterator;

import Modelo.Algoformer;
import Modelo.Bumblebee;
import Modelo.Juego;
import Vista.Controlador.BotonAtacarHandler;
import Vista.Controlador.BotonCambiarModoHandler;
import Vista.Controlador.BotonCapturarChispaHandler;
import Vista.Controlador.BotonMoverHandler;
import Vista.Controlador.BotonSeleccionarAlgoformerEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class VistaAlgoformer {

	protected Algoformer algof;
	/*protected ImageView vistaBumblebee;
	protected VistaBumblebeeController controllerBumblebee;*/
	TableroController tableroController;
	/*String nombre;
	private  ContenedorPrincipal contenedor;
	private VistaTerreno vista;
	Stage stage;*/
	
	 public VistaAlgoformer(Stage stage,Algoformer algof, GridPane paneCentral,String nombre,ContenedorPrincipal contenedor,Juego juego,VistaTerreno vista) {
	 }
	 public VistaAlgoformer(){
		 
	 }

	public VistaAlgoformer(TableroController tableroController) {
		
	this.tableroController=tableroController;

		
    }
	 
		// TODO Auto-generated constructor stub

	public void dibujar() {}
	public void update() {
		//tablero.getChildren().clear();
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
	public void setAlgoformer(Algoformer algof2) {
		// TODO Auto-generated method stub
		this.algof=algof2;
	}
	public void mostrarMenuAcciones(){
		try {
			FXMLLoader loadermenuacciones = new FXMLLoader(getClass().getResource("MenuAccionesAlgoformer.fxml"));
			Parent rootMenuAcciones;
			rootMenuAcciones = loadermenuacciones.load();
			
			
			Scene sceneMenuAcciones = new Scene(rootMenuAcciones);
			Stage st = new Stage();
			
			st.setScene(sceneMenuAcciones);
			st.setFullScreen(false);
			st.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
