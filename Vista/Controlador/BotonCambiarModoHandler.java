package Vista.Controlador;

import Modelo.Algoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Vista.VistaAlgoformer;
import Vista.VistaTerreno;

public class BotonCambiarModoHandler implements EventHandler<ActionEvent>{
VistaTerreno vista;
Algoformer algof;
VistaAlgoformer vistaAlgoformer;
	
	
	public BotonCambiarModoHandler(VistaTerreno vista, Algoformer algof, VistaAlgoformer vistaAlgoformer) {
		this.vista=vista;
		this.algof=algof;
		this.vistaAlgoformer=vistaAlgoformer;
	}

	@Override
	public void handle(ActionEvent arg0) {
		
		algof=algof.cambiarModo();
		vistaAlgoformer.actualizarAlgof(algof);
		vistaAlgoformer.update();
		
		
	}

}
