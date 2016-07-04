package vista.controller;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class VentanaMenuAccionesController implements EventHandler<WindowEvent>{
	TableroController tableroController;
	
	public  VentanaMenuAccionesController(TableroController tableroController){
		this.tableroController=tableroController;
	}
	
	@Override
	public void handle(WindowEvent arg0) {
		// TODO Auto-generated method stub
		tableroController.borrarZonaObjetivoMovimiento();
		tableroController.borrarZonaObjetivoAtaque();
	}

}
