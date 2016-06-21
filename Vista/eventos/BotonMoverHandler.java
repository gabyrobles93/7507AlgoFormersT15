package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.modelo.Robot;
import Modelo.Juego;
import Modelo.Posicion;

import Vista.VistaAlgoformer;
public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaAlgoformer vista;
    private final Juego juego;

    public BotonMoverHandler(VistaAlgoformer vistaAlgoformer, Juego juego) {
        this.vista = vistaAlgoformer;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.juego.getAutobots().getBumblebee().mover(new Posicion(20,20));
        this.vista.update();
    }
}
