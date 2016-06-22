package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import src.modelo.Robot;
import Modelo.Algoformer;
import Modelo.Juego;
import Modelo.Posicion;
import Vista.ContenedorPrincipal;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;
public class BotonMoverHandler implements EventHandler<ActionEvent> {

   private final VistaAlgoformer vistaAlgo;
    private final Algoformer algof;
    private final VistaTerreno tablero;
    private final ContenedorPrincipal contenedor;

   /* public BotonMoverHandler(VistaAlgoformer vistaAlgoformer, Algoformer algof) {
        this.vista = vistaAlgoformer;
        this.algof = algof;
    }*/

    public BotonMoverHandler(VistaTerreno tablero, Algoformer algof2,ContenedorPrincipal contenedor,VistaAlgoformer vista) {
	this.tablero=tablero;
	this.algof=algof2;
	this.contenedor=contenedor;
	this.vistaAlgo=vista;
	}

	@Override
    public void handle(ActionEvent actionEvent) {
	
		
		tablero.dibujarZonaObjetivoMovimiento(algof,vistaAlgo);
		
        contenedor.ModoSeleccionar(false);
        
        
    }
}
