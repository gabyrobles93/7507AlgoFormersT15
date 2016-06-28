package Vista.Controlador;

import Modelo.Algoformer;
import Modelo.Juego;
import Vista.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSeleccionarAlgoformerEventHandler implements EventHandler<ActionEvent> {
private final Algoformer algof;
private final VistaAlgoformer vistaAlgof;
public BotonSeleccionarAlgoformerEventHandler(VistaAlgoformer vista, Algoformer algof){
	this.algof=algof;
	this.vistaAlgof=vista;
}
	@Override
	public void handle(ActionEvent arg0) {
		vistaAlgof.resaltar();
		
		
	}

}
