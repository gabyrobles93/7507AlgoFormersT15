package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;
import vista.VistaFrenzy;

public class VistaFrenzyController {
	
	@FXML ImageView vista_frenzy;
	Algoformer frenzy;
	VistaAlgoformer vistafrenzy;
	TableroController tabcontroller;
	
	MenuAccionesAlgoformerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	
	public void mostrarMenu() throws Exception{
		Aplicacion.menuaccionescontroller.setAlgoformer(frenzy, vistafrenzy);
		
		Aplicacion.menuaccionescontroller.actualizarInfo("Frenzy");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Aplicacion.menuaccionescontroller.HabilitarBotonesAlgoformer();
		/*if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.decepticons&&frenzy.getEfecto().esperaturnos==0){
			mostrarMenuAcciones();
			return;
		}else{
			mostrarVerEstado();
			return;
		}*/
	}
	
	public void mostrarMenuAcciones() throws Exception{
		
		/*FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();
		
		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(frenzy, vistafrenzy);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Frenzy");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		*/
	}
	
	private void mostrarVerEstado() throws Exception{
		/*FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(frenzy, vistafrenzy);
		menuestadocontroller.setTableroController(tabcontroller);


		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Frenzy");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
			*/	
	}


	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}

	public void setFrenzy(Algoformer fren, VistaFrenzy vistaFren) {
		frenzy = fren;
		vistafrenzy = vistaFren;		
	}

}
