package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaMegatronController {

	@FXML ImageView vista_megatron;
	Algoformer megatron;
	VistaAlgoformer vistamegatron;
	TableroController tabcontroller;
	
	MenuAccionesAlgoformerController menuaccionescontroller;
	MenuVerEstadoController menuestadocontroller;
	
	
	public void mostrarMenu() throws Exception{
		
		if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.decepticons&&megatron.getEfecto().esperaturnos==0){
			mostrarMenuAcciones();
			return;
		}else{
			mostrarVerEstado();
			return;
		}
	}
	
	public void mostrarMenuAcciones() throws Exception{
		
		FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();
		
		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(megatron, vistamegatron);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("Megatron");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
		
	}
	
	private void mostrarVerEstado() throws Exception{
		FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(megatron, vistamegatron);
		menuestadocontroller.setTableroController(tabcontroller);


		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("Megatron");
		ventana.setResizable(false);
		ventana.setScene(scene);
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		ventana.show();
				
	}

	public void setMegatron(Algoformer mega, VistaAlgoformer vistamega) {
		// TODO Auto-generated method stub
		megatron = mega;
		vistamegatron = vistamega;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}
}
	
	
	

