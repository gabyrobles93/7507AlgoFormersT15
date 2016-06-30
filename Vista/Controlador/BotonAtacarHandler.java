package Vista.Controlador;

import Modelo.Algoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;

public class BotonAtacarHandler implements EventHandler<ActionEvent>{

	private Algoformer algof;
	private VistaAlgoformer vistaAlgoformer;
	private VistaTerreno tablero;
	
	public BotonAtacarHandler(VistaTerreno tablero,Algoformer algof, VistaAlgoformer vistaAlgoformer){
		this.algof=algof;
		this.vistaAlgoformer=vistaAlgoformer;
		this.tablero=tablero;
	}
	@Override
	public void handle(ActionEvent event) {
		tablero.dibujarZonaObjetivoAtaque(algof,vistaAlgoformer);
		
	}

}
