package Vista.Controlador;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import Vista.ContenedorPrincipal;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;
import Modelo.Algoformer;
import Modelo.Juego;
import Modelo.Posicion;
public class BotonMoverHandler implements EventHandler<ActionEvent> {

   private  VistaAlgoformer vistaAlgo;
    private  Algoformer algof;
    private  GridPane tablero;
    private  ContenedorPrincipal contenedor;
	private VistaAlgoformer vista;
/*
    public BotonMoverHandler(VistaAlgoformer vistaAlgoformer, Algoformer algof) {
        this.vista  = vistaAlgoformer;
        this.algof = algof;
    }
*/
    public BotonMoverHandler(Algoformer algof,GridPane tablero) {
	this.tablero=tablero;
	this.algof=algof;
	}

	@Override
    public void handle(ActionEvent actionEvent) {
	
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
    }
}
