package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaOptimusController {

	@FXML ImageView vista_optimus;
	Algoformer optimus;
	VistaAlgoformer vistaoptimus;
	TableroController tabcontroller;
	
	MenuAccionesAlgoformerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	public void mostrarMenu() throws Exception{
Aplicacion.menuaccionescontroller.setAlgoformer(optimus, vistaoptimus);
		
		Aplicacion.menuaccionescontroller.actualizarInfo("Optimus");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Aplicacion.menuaccionescontroller.HabilitarBotonesAlgoformer();
	
		//if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.autobots&&optimus.getEfecto().esperaturnos==0){
			mostrarMenuAcciones();
		//}else{
			//mostrarVerEstado();
		//}
	}
	
	private void mostrarVerEstado() throws Exception{
	/*	FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(optimus, vistaoptimus);
		menuestadocontroller.setTableroController(tabcontroller);
		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Optimus");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
			*/	
	}

	public void mostrarMenuAcciones() throws Exception{
		
	/*	FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();

		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(optimus, vistaoptimus);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Optimus");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		*/
	}
	


	public void setOptimus(Algoformer optim, VistaAlgoformer vistaoptim) {
		// TODO Auto-generated method stub
		optimus = optim;
		vistaoptimus = vistaoptim;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}
	
}
