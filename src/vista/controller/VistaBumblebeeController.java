package vista.controller;

import vista.Aplicacion;
import vista.VistaAlgoformer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Bumblebee;

public class VistaBumblebeeController {

	@FXML ImageView vista_bumblebee;
	Algoformer bumblebee;
	VistaAlgoformer vistabumblebee;
	TableroController tabcontroller;
	
	MenuAccionesAlgoformerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	public void mostrarMenu() throws Exception{
		
		if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.autobots&&bumblebee.getEfecto().esperaturnos==0){
			mostrarMenuAcciones();
		}else{
			mostrarVerEstado();
		}
	}
	
	private void mostrarVerEstado() throws Exception{
		FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(bumblebee, vistabumblebee);
		menuestadocontroller.setTableroController(tabcontroller);
		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Bumblebee");
		ventana.setResizable(false);
		ventana.setScene(scene);
		ventana.show();
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
				
	}

	public void mostrarMenuAcciones() throws Exception{
		
		FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();

		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(bumblebee, vistabumblebee);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Bumblebee");
		ventana.setResizable(false);
		ventana.setScene(scene);
		ventana.show();
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		
	}
	


	public void setBumblebee(Algoformer bumb, VistaAlgoformer vistabumb) {
		// TODO Auto-generated method stub
		bumblebee = bumb;
		vistabumblebee = vistabumb;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}
}
