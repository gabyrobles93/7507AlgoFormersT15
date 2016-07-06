package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Autobots;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaMenasorController {
	
	@FXML ImageView vista_menasor;
	Algoformer menasor;
	VistaAlgoformer vistamenasor;
	TableroController tabcontroller;
	
	MenuAccionesCombinerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	public void mostrarMenu() throws Exception{
Aplicacion.menuaccionescontroller.setAlgoformer(menasor, vistamenasor);
		
		Aplicacion.menuaccionescontroller.actualizarInfo("Menasor");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Aplicacion.menuaccionescontroller.HabilitarBotonesSuper();
		/*if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.decepticons&&Aplicacion.juego.decepticons.puedeJugar()){
			mostrarMenuAcciones();
		}else{
			mostrarVerEstado();
		}*/
	}
	
	private void mostrarVerEstado() throws Exception{
		/*FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(menasor, vistamenasor);
		menuestadocontroller.setTableroController(tabcontroller);
		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Menasor");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
			*/	
	}

	public void mostrarMenuAcciones() throws Exception{
		
		/*FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesCombiner.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();

		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(menasor, vistamenasor);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Menasor");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		*/
	}
	


	public void setMenasor(Algoformer mena, VistaAlgoformer vistamena) {
		// TODO Auto-generated method stub
		menasor = mena;
		vistamenasor = vistamena;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}

}
