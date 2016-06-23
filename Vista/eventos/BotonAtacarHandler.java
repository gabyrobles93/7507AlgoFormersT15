package Vista.eventos;

import Modelo.Algoformer;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
