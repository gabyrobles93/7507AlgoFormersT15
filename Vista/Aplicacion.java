package Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import Modelo.Juego;
import Vista.Controlador.CartelBienvenidosController;
import Vista.Controlador.TableroCieloController;
import Vista.Controlador.TableroController;
import Vista.Controlador.TableroTierraController;




public class Aplicacion extends Application {

	private BorderPane Tablero;
	ScrollPane vistaTableroTierra;
	ScrollPane vistaTableroCielo; 
	private Stage ventanaPrincipal;
	private TableroController controladorTablero;
	TableroTierraController controllerTableroTierra;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    
    

    public void start(Stage stage) throws Exception {
    	/*
    	 ContenedorPrincipal contenedorprincipal = new ContenedorPrincipal(stage);
    	contenedorprincipal.setStage(stage);
    	
    	contenedorprincipal.mostrarTableroTierra();
    	
    	 */
    	
    this.ventanaPrincipal = stage;
    this.ventanaPrincipal.setTitle("Algoformers");
	

    initRootTablero();
    	
  
	
    	


    }

    
	private void initRootTablero() {
		
		        try {
		            // Load root layout from fxml file.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(Aplicacion.class.getResource("TableroRaiz.fxml"));
		           Tablero = (BorderPane) loader.load();
		           controladorTablero=new TableroController();
		        	loader.setController(controladorTablero);
		        	
		        	
		            // Show the scene containing the root layout.
		            Scene scene = new Scene(Tablero);
		            ventanaPrincipal.setScene(scene);
		            ventanaPrincipal.show();
		            showVistaTableroTierra();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		
	 public void showVistaTableroTierra() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Aplicacion.class.getResource("Tablero_Tierra.fxml"));
	        vistaTableroTierra =  loader.load();

	           controllerTableroTierra = new TableroTierraController();
	           
	           loader.setController(controllerTableroTierra);
	           
	           
	        
	           
	           controllerTableroTierra.inicializarTableroTierra();
	            // Set person overview into the center of root layout.
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 public void showVistaTableroCielo() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Aplicacion.class.getResource("Tablero_Cielo.fxml"));
	            vistaTableroCielo = (ScrollPane) loader.load();
	            
	            TableroCieloController controllerTableroCielo = new TableroCieloController();
		           
		           loader.setController(controllerTableroCielo);
		          
		        
	            // Set person overview into the center of root layout.
	           controladorTablero.setCenter(vistaTableroCielo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
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
