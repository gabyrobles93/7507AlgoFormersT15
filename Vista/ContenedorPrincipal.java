package Vista;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ContenedorPrincipal {
TableroController controllerTablero;
Stage mainStage;
Scene vistaTablero;
FXMLLoader fxmlTableroLoader;
Parent rootTablero;

public ContenedorPrincipal(Stage stage)throws Exception{
	
	mainStage=stage;
	fxmlTableroLoader=new FXMLLoader(getClass().getResource("TableroRaiz.fxml"));
	rootTablero=fxmlTableroLoader.load();
	
	fxmlTableroLoader.setController(controllerTablero);
	
}
	/*TableroTierraController controllerTableroTierra;
	TableroCieloController controllerTableroCielo;
	FXMLLoader fxmlTableroTierraLoader;
	FXMLLoader fxmlTableroCieloLoader;

	Parent rootTableroTierra;
	Parent rootTableroCielo;

	
	Scene vistaTierra;
	
	
	public ContenedorPrincipal(Stage stage) throws Exception{
		
		mainStage = stage;
		
		fxmlTableroTierraLoader = new FXMLLoader(getClass().getResource("Tablero_Tierra.fxml"));
	    controllerTableroTierra = new TableroTierraController();
	    
		fxmlTableroCieloLoader = new FXMLLoader(getClass().getResource("Tablero_Cielo.fxml"));
	    controllerTableroCielo = new TableroCieloController();
	    
	    fxmlTableroTierraLoader.setController(controllerTableroTierra);
	    fxmlTableroCieloLoader.setController(controllerTableroCielo);
	    
	    rootTableroTierra = fxmlTableroTierraLoader.load();
	    rootTableroCielo = fxmlTableroCieloLoader.load();
	    
	    vistaTierra = new Scene(rootTableroTierra);
	    vistaCielo = new Scene(rootTableroCielo);
	    
	    controllerTableroTierra.setStage(mainStage);
	    controllerTableroCielo.setStage(mainStage);
	    
	    controllerTableroTierra.setProximaEscena(vistaCielo);
	    controllerTableroCielo.setProximaEscena(vistaTierra);
	    
	    inicializarTableros();
*/
	
/*	
	public void setStage(Stage stg){
		mainStage = stg;
	    controllerTablero.setStage(mainStage);
	   
	}

	private void inicializarTableros() {
		// TODO Auto-generated method stub
		controllerTableroCielo.inicializarTableroCielo(controllerTableroTierra.inicializarTableroTierra());
	}

	public void mostrarTableroTierra() throws Exception {
		
		mainStage.setScene(vistaTierra);
		
		mainStage.show();
	}
	
	public void mostrarTableroCielo() throws Exception {
		
		mainStage.setScene(vistaCielo);
		mainStage.setFullScreen(false);
		mainStage.show();
	}

	public void setModoSeleccionar(boolean b) {
		// TODO Auto-generated method stub
		
	}
*/

	
}
