package Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.TilePane;

public class MoverEventHandler implements EventHandler<ActionEvent> {
	private final VistaAlgoformer vista;
	private final TilePane pane;

	public MoverEventHandler(VistaAlgoformer vista, TilePane pane) {
		this.vista=vista;
		this.pane=pane;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
