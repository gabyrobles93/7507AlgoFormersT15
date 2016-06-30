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

public class Aplicacion extends Application {

	private BorderPane Tablero;
	ScrollPane vistaTableroTierra;
	ScrollPane vistaTableroCielo;
	private Stage ventanaPrincipal;
	private TableroController controladorTablero;
	TableroTierraController controllerTableroTierra;
	TableroCieloController controllerTableroCielo;
	protected AnchorPane vistaBumblebee;
	protected VistaBumblebee controllerBumblebee;
	Juego juego;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		/*
		 * ContenedorPrincipal contenedorprincipal = new
		 * ContenedorPrincipal(stage); contenedorprincipal.setStage(stage);
		 * 
		 * contenedorprincipal.mostrarTableroTierra();
		 * 
		 */
		juego = new Juego();

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

			controladorTablero = loader.getController();

			// Show the scene containing the root layout.
			Scene scene = new Scene(Tablero);
			ventanaPrincipal.setScene(scene);
			ventanaPrincipal.show();
			initVistaTableroTierra();
			initVistaTableroCielo();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initVistaTableroTierra() {
		try {
			// Load person overview.
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(Aplicacion.class.getResource("Tablero_Tierra.fxml"));
			vistaTableroTierra = loader2.load();

			controllerTableroTierra = loader2.getController();
			//el controlador del tablero general tiene ref a los controladores especificos
			controladorTablero.setTableroTierraController(controllerTableroTierra);
			
			controllerTableroTierra.inicializarTableroTierra(juego.getTablero());

			Tablero.setCenter(vistaTableroTierra);
			// Set person overview into the center of root layout.

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initVistaTableroCielo() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("Tablero_Cielo.fxml"));
			vistaTableroCielo = loader.load();

			controllerTableroCielo = loader.getController();

			controladorTablero.setTableroCieloController(controllerTableroCielo);
			//el controlador del tablero general tiene ref a los controladores especificos
			controllerTableroCielo.inicializarTableroCielo(juego.getTablero());
			// Set person overview into the center of root layout.
			controladorTablero.setCenter(vistaTableroCielo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void iniciarInterfazGrafica(Stage mainStage) throws Exception {

	}

	/*
	 * private void iniciarContenedorPrincipal(Stage mainStage) throws
	 * Exception{
	 * 
	 * // TODO Auto-generated method stub
	 * 
	 * Parent rootContendorPrincipal = loadContenedorPrincipal().load();
	 * 
	 * mainStage.setTitle("Algoformers: El Juego");
	 * 
	 * Scene vistaContenedorPrincipal = new Scene(rootContendorPrincipal);
	 * 
	 * mainStage.setScene(vistaContenedorPrincipal);
	 * mainStage.setResizable(true); mainStage.setFullScreen(false);
	 * mainStage.show();
	 * 
	 * 
	 * }
	 */

}
