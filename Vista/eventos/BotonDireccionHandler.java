package Vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.modelo.Robot;

public class BotonDireccionHandler implements EventHandler<ActionEvent> {

    private final Robot robot;

    public BotonDireccionHandler(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.robot.rotar();
    }
}
