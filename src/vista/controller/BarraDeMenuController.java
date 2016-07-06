package vista.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenuController implements Initializable{
	
	@FXML MenuBar barra_de_menu;
	@FXML MenuItem boton_ver_tierra;
	@FXML MenuItem boton_ver_cielo;
	
	TableroController tablerocontroller;
	VentanaPrincipalController ventanaprincipalcontroller;
	Stage ventana;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		boton_ver_tierra.setDisable(true);
	}

	public MenuBar getBarraDeMenu(){
		return barra_de_menu;
	}
	
	public void setStage(Stage stage){
		ventana = stage;
	}

	public void botonVerResumenController(){
		
	}
	
	public void botonVerTierraController(){
		boton_ver_cielo.setDisable(false);
		boton_ver_tierra.setDisable(true);
		tablerocontroller.borrarCielo();
		tablerocontroller.dibujarTierra();
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.dibujarAlgoformers();
		tablerocontroller.dibujarChispa();
		ventana.setTitle("Algoformers - Tablero Tierra");
		ventanaprincipalcontroller.mostrarTablero();
	}
	
	public void botonVerCieloController(){
		boton_ver_cielo.setDisable(true);
		boton_ver_tierra.setDisable(false);
		tablerocontroller.borrarTierra();
		tablerocontroller.dibujarCielo();
		tablerocontroller.borrarAlgoformers();
		tablerocontroller.dibujarAlgoformers();
		tablerocontroller.dibujarChispa();
		ventana.setTitle("Algoformers - Tablero Cielo");
		ventanaprincipalcontroller.mostrarTablero();
	}
	
	public void botonAcercaDeController(){
		
	}

	public void setControllers(TableroController tabcont, VentanaPrincipalController ventpricont) {
		// TODO Auto-generated method stub
		tablerocontroller = tabcont;
		ventanaprincipalcontroller = ventpricont;
	}




}
