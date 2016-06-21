package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.modelo.Robot;
import Modelo.Algoformer;
import Modelo.Juego;
import Modelo.Posicion;

import Vista.VistaAlgoformer;
public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaAlgoformer vista;
    private final Algoformer algof;

    public BotonMoverHandler(VistaAlgoformer vistaAlgoformer, Algoformer algof) {
        this.vista = vistaAlgoformer;
        this.algof = algof;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algof.mover(new Posicion(5,5));
        this.vista.update();
    }
}
