package Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import Modelo.Juego;
import Vista.Controlador.CartelBienvenidosController;




public class Aplicacion extends Application {

	
    public static void main(String[] args) {
        launch(args);
    }
    
    
    

    public void start(Stage stage) throws Exception {

    	ContenedorPrincipal contenedorprincipal = new ContenedorPrincipal(stage);
    	contenedorprincipal.setStage(stage);
    	
    	contenedorprincipal.mostrarTableroTierra();
    	


    }

    
	private void iniciarInterfazGrafica(Stage mainStage) throws Exception {

	}


/*
	private void iniciarContenedorPrincipal(Stage mainStage) throws Exception{
    	
		// TODO Auto-generated method stub
    	
		Parent rootContendorPrincipal = loadContenedorPrincipal().load();
		
        mainStage.setTitle("Algoformers: El Juego");
     
        Scene vistaContenedorPrincipal = new Scene(rootContendorPrincipal);
        
        mainStage.setScene(vistaContenedorPrincipal);
        mainStage.setResizable(true);
        mainStage.setFullScreen(false);
        mainStage.show();
        
        
    }
	*/

}
