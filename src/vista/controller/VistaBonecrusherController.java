package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Algoformer;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class VistaBonecrusherController {
	
	@FXML ImageView vista_bonecrusher;
	
	Algoformer bonecrusher;
	VistaAlgoformer vistabonecrusher;
	TableroController tabcontroller;
	
	
	
	
	public void mostrarMenu() throws Exception{
		Aplicacion.menuaccionescontroller.setAlgoformer(bonecrusher, vistabonecrusher);
		
		Aplicacion.menuaccionescontroller.actualizarInfo("Bonecrusher");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		
		Aplicacion.menuaccionescontroller.HabilitarBotonesAlgoformer();
		/*if(Aplicacion.juego.getEjecutorDeTurnoActual()==Aplicacion.juego.decepticons&&bonecrusher.getEfecto().esperaturnos==0){
			mostrarMenuAcciones();
			return;
		}else{
			mostrarVerEstado();
			return;
		}*/
	}
	
	public void mostrarMenuAcciones() throws Exception{
	/*	
		FXMLLoader loadermenuacciones = new FXMLLoader(Aplicacion.class.getResource("MenuAccionesAlgoformer.fxml"));
		loadermenuacciones.load();
		Stage ventana = new Stage();
		
		menuaccionescontroller = loadermenuacciones.getController();
		menuaccionescontroller.setAlgoformer(bonecrusher, vistabonecrusher);
		menuaccionescontroller.setTableroController(tabcontroller);
		menuaccionescontroller.setStage(ventana);
		
		Scene scene = new Scene(menuaccionescontroller.getVista());
		ventana.setTitle("bonecrusher");
		ventana.setResizable(false);
		ventana.setScene(scene);
		ventana.show();
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);
		*/
	}
	
	private void mostrarVerEstado() throws Exception{
	/*FXMLLoader loadermenuestado = new FXMLLoader(Aplicacion.class.getResource("MenuVerEstado.fxml"));
		loadermenuestado.load();
		Stage ventana = new Stage();

		menuestadocontroller = loadermenuestado.getController();
		menuestadocontroller.setAlgoformer(bonecrusher, vistabonecrusher);
		menuestadocontroller.setTableroController(tabcontroller);


		
		Scene scene = new Scene(menuestadocontroller.getVista());
		ventana.setTitle("bonecrusher");
		ventana.setResizable(false);
		ventana.setScene(scene);
		ventana.show();
		VentanaMenuAccionesController ventCont=new VentanaMenuAccionesController(tabcontroller);
		ventana.setOnCloseRequest(ventCont);//si se cierra lA VENTANA desaparece todo
			*/	
	}

	public void setBonecrusher(Algoformer bone, VistaAlgoformer vistabone) {
		// TODO Auto-generated method stub
		bonecrusher = bone;
		vistabonecrusher = vistabone;
	}
	
	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tabcontroller = tabcont;
	}

}
