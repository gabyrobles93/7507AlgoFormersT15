package Vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import Vista.BarraDeMenu;
import Vista.ContenedorPrincipal;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;
    private BarraDeMenu menuBar;
    private ContenedorPrincipal contenedor;

    public AplicacionOnKeyPressEventHandler(Stage stage,ContenedorPrincipal contenedor) {
        this.stage = stage;
        this.menuBar = contenedor.getBarraDeMenu();
        this.contenedor=contenedor;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
        	
            stage.setMaximized(true);
            menuBar.aplicacionMaximizada();
        }
       
    }
}
