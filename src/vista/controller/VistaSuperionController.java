package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaSuperionController {

	
	@FXML ImageView vista_superion;
	Algoformer superion;
	VistaAlgoformer vistasuperion;
	TableroController tabcontroller;
	
	menuAccionesController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	public void mostrarMenu() throws Exception{
Aplicacion.menuaccionescontroller.setAlgoformer(superion, vistasuperion);
		Aplicacion.menuaccionescontroller.HabilitarBotonesSuper();
		Aplicacion.menuaccionescontroller.actualizarInfo("Superion");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		//Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.autobots&&Aplicacion.juego.decepticons.puedeJugar())
		//	mostrarMenuAcciones();
		
		
	}
	
	

	public void mostrarMenuAcciones() throws Exception{
		/*
		FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesCombiner.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();

		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(superion, vistasuperion);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Superion");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		*/
	}
	


	public void setSuperion(Algoformer sup, VistaAlgoformer vistasup) {
		// TODO Auto-generated method stub
		superion = sup;
		vistasuperion = vistasup;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}
}
