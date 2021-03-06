package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaRatchetController {
	
	@FXML ImageView vista_ratchet;
	Algoformer ratchet;
	VistaAlgoformer vistaratchet;
	TableroController tabcontroller;
	
	MenuAccionesAlgoformerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	public void mostrarMenu() throws Exception{
Aplicacion.menuaccionescontroller.setAlgoformer(ratchet, vistaratchet);
		
		Aplicacion.menuaccionescontroller.actualizarInfo("Ratchet");
		
	//	Image img=new Image("C:/imagenes/autobots/humanoide/ratchet.png");
		
	//	Aplicacion.menuaccionescontroller.imagen.setImage(img);
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Aplicacion.menuaccionescontroller.HabilitarBotonesAlgoformer();
		/*if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.autobots&&ratchet.getEfecto().esperaturnos==0){
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
		menuestadocontroller.setAlgoformer(ratchet, vistaratchet);
		menuestadocontroller.setTableroController(tabcontroller);
		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Ratchet");
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
		menuaccionescontroller.setAlgoformer(ratchet, vistaratchet);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Ratchet");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		*/
	}
	


	public void setRatchet(Algoformer rat, VistaAlgoformer vistarat) {
		// TODO Auto-generated method stub
		ratchet = rat;
		vistaratchet = vistarat;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}

}
