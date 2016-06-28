package Vista.Controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import Vista.ContenedorPrincipal;
import Vista.VistaTerreno;

public class SalirDeModoRangoOnKeyPressEventHandler implements EventHandler<KeyEvent> {
	private final VistaTerreno tablero;
	private final ContenedorPrincipal contenedor;
	
	public SalirDeModoRangoOnKeyPressEventHandler(VistaTerreno tablero,ContenedorPrincipal contenedor){
		this.tablero=tablero;
		this.contenedor=contenedor;
		
	}

	@Override
	public void handle(KeyEvent event) {
		if(event.getCode()==KeyCode.ESCAPE&&tablero.ModoRango()){
			//Vuelvo todo al principio
			tablero.setModoRango(false);
		}
		
	}
	
}
