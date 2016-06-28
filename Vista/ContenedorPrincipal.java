package Vista;

import java.io.IOException;

import Vista.Controlador.ContenedorPrincipalController;
import Vista.Controlador.TableroCieloController;
import Vista.Controlador.TableroTierraController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ContenedorPrincipal {

	TableroTierraController controllerTableroTierra;
	TableroCieloController controllerTableroCielo;
	FXMLLoader fxmlTableroTierraLoader;
	FXMLLoader fxmlTableroCieloLoader;

	Parent rootTableroTierra;
	Parent rootTableroCielo;

	
	public ContenedorPrincipal() throws Exception{
		
		fxmlTableroTierraLoader = new FXMLLoader(getClass().getResource("Tablero_Tierra.fxml"));
	    controllerTableroTierra = new TableroTierraController();
	    
		fxmlTableroCieloLoader = new FXMLLoader(getClass().getResource("Tablero_Cielo.fxml"));
	    controllerTableroCielo = new TableroCieloController();
	    
	    fxmlTableroTierraLoader.setController(controllerTableroTierra);
	    fxmlTableroCieloLoader.setController(controllerTableroCielo);
	    
	    rootTableroTierra = fxmlTableroTierraLoader.load();
	    rootTableroCielo = fxmlTableroCieloLoader.load();
	    
	    inicializarTableros();

	}

	private void inicializarTableros() {
		// TODO Auto-generated method stub
		controllerTableroCielo.inicializarTableroCielo(controllerTableroTierra.inicializarTableroTierra());
	}

	public void mostrarTableroTierra(Stage stage) throws Exception {

		Scene scene = new Scene(rootTableroTierra);
		
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void mostrarTableroCielo(Stage stage) throws Exception {

		Scene scene = new Scene(rootTableroCielo);
		
		stage.setScene(scene);
		
		stage.show();
	}

	public void setModoSeleccionar(boolean b) {
		// TODO Auto-generated method stub
		
	}


	
}
