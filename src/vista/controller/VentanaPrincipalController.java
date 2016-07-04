
package vista.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaPrincipalController {

	@FXML BorderPane vista_ventana_principal;
	@FXML MenuBar barra_de_menu;
	TableroController tablerocontroller;
	Stage ventanaPrincipal;
	
	public void setBarraDeMenu(MenuBar barrademenu) {
		// TODO Auto-generated method stub
		vista_ventana_principal.setTop(barrademenu);
	}

	public void mostrarVentanaPrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		Scene scene = new Scene(vista_ventana_principal);
		ventana.setScene(scene);
		
		ventana.setTitle("Algoformers");
		ventana.setScene(scene);
		ventana.show();
	}

	public void mostrarTablero() {
		// TODO Auto-generated method stub
		vista_ventana_principal.setCenter(tablerocontroller.getVistaTablero());
		ventanaPrincipal.show();
	}

	public void setTablero(TableroController tabcontr) {
		// TODO Auto-generated method stub
		tablerocontroller = tabcontr;
	}

	public void setVentana(Stage ventprin) {
		// TODO Auto-generated method stub
		ventanaPrincipal = ventprin;
	}


}
