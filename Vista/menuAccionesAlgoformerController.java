package Vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Algoformer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Vista.Aplicacion;
import Vista.Controlador.BotonMoverHandler;
import Vista.Controlador.BotonObjetivoAtacarHandler;
import Vista.Controlador.BotonObjetivoMovimientoHandler;

public class menuAccionesAlgoformerController  {

	Algoformer algof;
	GridPane tablero;
	VistaBumblebee2 vistaAlgof;
	TableroTierraController vistaTablero;
	
	
	@FXML Button boton_atacar;
	@FXML Button boton_mover;
	@FXML Button boton_ver_estado;
	@FXML Button boton_transformar;
	@FXML Button boton_combinar;
	
	/*public menuAccionesAlgoformerController(Algoformer algoformer, GridPane tablero) {
		// TODO Auto-generated constructor stub
		algof = algoformer;
		this.tablero=tablero;
		
	}*/
public void mostrarEstado(ActionEvent event) {
		
		VBox hb=new VBox();
		Text txt1=new Text("Vida "+String.valueOf(algof.getVida()));
		Text txt2=new Text("Ataque "+String.valueOf(algof.getAtaque()));
		Text txt3=new Text("Velocidad "+String.valueOf(algof.getVelocidad()));
		Text txt4=new Text("Espera Turnos "+String.valueOf(algof.getEfecto().esperaturnos));
		hb.getChildren().addAll(txt1,txt2,txt3,txt4);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Estado del Algoformer");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
		
		
	}

public void setAlgoformer(Algoformer algof2) {
	// TODO Auto-generated method stub
	this.algof=algof2;
}
public void setVistaAlgoformer(VistaBumblebee2 algof2) {
	// TODO Auto-generated method stub
	this.vistaAlgof=algof2;
}
public void setTablero(TableroTierraController controllerTablero) {
	// TODO Auto-generated method stub
	this.vistaTablero=controllerTablero;
}
public void mostrarZonaMovimiento() {
	this.borrarZonaObjetivoMovimiento();
	
	int distanciaACubrir=algof.getVelocidad();
	int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
	int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
	
	int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
	int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
	
	List<ImageView> listaReferencias = new ArrayList<ImageView>();

	File file = new File("C:\\imagenes\\acciones\\moverse_permitido.png");
	
		 for (int column=minColumn; column<=maxColumn; column++) {
	            for (int row = minFila ; row<=maxFila; row++) {
	            	
	        		
	        		
	        		Image flechamoverse = new Image(file.toURI().toString());
	        		ImageView picmoverse = new ImageView();
	        		picmoverse.setFitWidth(75);
	        		picmoverse.setFitHeight(75);
	        		picmoverse.setImage(flechamoverse);
	        		
	        	 	BotonObjetivoMovimientoHandler movHandler=new BotonObjetivoMovimientoHandler(algof,row,column,vistaAlgof,this);          
	        	 	picmoverse.setOnMouseClicked(movHandler);
	        		
	        	 	listaReferencias.add(picmoverse);
	        	 	
	        	 	vistaTablero.dibujarNodo(picmoverse, column, row);	         
	            }
	        }

    vistaTablero.setReferenciasObjetivoMovimiento(listaReferencias);
    
}
public void mostrarZonaAtaque() {
	
	this.borrarZonaObjetivoMovimiento();
	
	int distanciaACubrir=algof.getDistanciaDeAtaque();
	int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
	int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
	
	int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
	int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
	
	List<ImageView> listaReferencias = new ArrayList<ImageView>();

	
	
		 for (int column=minColumn; column<=maxColumn; column++) {
	            for (int row = minFila ; row<=maxFila; row++) {
	            	
	        		File file = new File("C:\\imagenes\\acciones\\moverse_permitido.png");
	        		
	        		Image flechamoverse = new Image(file.toURI().toString());
	        		ImageView picmoverse = new ImageView();
	        		picmoverse.setFitWidth(75);
	        		picmoverse.setFitHeight(75);
	        		picmoverse.setImage(flechamoverse);
	        		
	        	 	BotonObjetivoAtacarHandler movHandler=new BotonObjetivoAtacarHandler(algof,row,column,vistaAlgof,this);          
	        	 	picmoverse.setOnMouseClicked(movHandler);
	        		
	        	 	listaReferencias.add(picmoverse);
	        	 	
	        	 	vistaTablero.dibujarNodo(picmoverse, column, row);	         
	            }
	        }

    vistaTablero.setReferenciasObjetivoMovimiento(listaReferencias);
    
}

public void borrarZonaObjetivoMovimiento() {
	// TODO Auto-generated method stub
	vistaTablero.borrarReferenciasObjetivoMovimiento();
	
}


	
	}
	/*public void handlerBotonMover(){
		int distanciaACubrir=algof.getVelocidad();
		int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
		int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
		
		int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
		int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
		
			 for (int column=minColumn; column<=maxColumn; column++) {
 	            for (int row = minFila ; row<=maxFila; row++) {
 	            	
 	            Node nodo=	getNodeByRowColumnIndex(row,column,tablero);
 	            nodo.setStyle( "-fx-stroke: green;-fx-stroke-width: 5;");
 	            }
 	        }
	}
	
	public Node getNodeByRowColumnIndex( int row, int column,GridPane tablero) {
        Node result = null;
        ObservableList<Node> childrens = tablero.getChildren();
        for(Node node : childrens) {
            if(tablero.getRowIndex(node) == row && tablero.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }*/

