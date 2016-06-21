package Vista;

import Modelo.Algoformer;
import Modelo.Megatron;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.TilePane;

public class AtacarEventHandler implements EventHandler<ActionEvent> {
	private final VistaAlgoformer vista;
	private final TilePane pane;

	public AtacarEventHandler(VistaAlgoformer vistaMegatron, TilePane paneCentral) {
	 this.vista=vistaMegatron;
	 this.pane=paneCentral;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		vista.resaltarZonaDeAtaque();
	// como hago para Esperar que clickee el objetivo??
	}

}
