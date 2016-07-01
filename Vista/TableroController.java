package Vista;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Modelo.Bumblebee;
import Vista.Controlador.BotonAyudaController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroController {
	
	TableroTierraController tabtierra;
	TableroCieloController tabcielo;
	
	@FXML private BorderPane tableroGeneral;
	@FXML private MenuItem ver_resumen;
	@FXML private MenuItem ver_tierra;
	@FXML private MenuItem ver_cielo;
	@FXML private MenuItem ayuda;
	@FXML private MenuItem acerca_de;
	@FXML private MenuBar barra_de_menu;

	
public void setCenter(ScrollPane tablero){
	tableroGeneral.setCenter(tablero);
}
public void setTableroTierra(){
	setCenter(tabtierra.getScrollPane());
}
public void setTableroCielo(){
	setCenter(tabcielo.getScrollPane());
}




public void setTableroCieloController(TableroCieloController controllerTableroCielo) {
	// TODO Auto-generated method stub
	tabcielo=controllerTableroCielo;
}


public void setTableroTierraController(TableroTierraController controllerTableroTierra) {
	tabtierra=controllerTableroTierra;
	
}

public void mostrarAyuda() throws Exception {

	//BotonAyudaController ayudacontroller = new BotonAyudaController(stage);
	
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Aplicacion.class.getResource("Ayuda.fxml"));
   // loader.setController(ayudacontroller);
    
    Parent vistaayuda =  loader.load();
    
    Scene nuevascene = new Scene(vistaayuda);
	
    Stage stage = new Stage();
    stage.setScene(nuevascene);
    stage.setFullScreen(false);
    stage.setResizable(false);
    stage.show();
	
}

public void mostrarResumenJuego() throws Exception {

	//BotonAyudaController ayudacontroller = new BotonAyudaController(stage);
	
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Aplicacion.class.getResource("Resumen_Juego.fxml"));
   // loader.setController(ayudacontroller);
    
    Parent vistaayuda =  loader.load();
    
    Scene nuevascene = new Scene(vistaayuda);
	
    Stage stage = new Stage();
    stage.setScene(nuevascene);
    stage.setFullScreen(false);
    stage.setResizable(false);
    stage.show();
	
}

public void mostrarAcercaDe() throws Exception {

	//BotonAyudaController ayudacontroller = new BotonAyudaController(stage);
	
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Aplicacion.class.getResource("Acerca_De.fxml"));
   // loader.setController(ayudacontroller);
    
    Parent vistaayuda =  loader.load();
    
    Scene nuevascene = new Scene(vistaayuda);
	
    Stage stage = new Stage();
    stage.setScene(nuevascene);
    stage.setFullScreen(false);
    stage.setResizable(false);
    stage.show();
}

public void dibujarNodo(Node image, int columna, int fila) {
	// TODO Auto-generated method stub
	
	tabtierra.dibujarNodo(image, columna, fila);
	tabcielo.dibujarNodo(image, columna, fila);
}


public void eliminarNodo(Node img) {
	// TODO Auto-generated method stub
	tabtierra.eliminarNodo(img);
	tabcielo.eliminarNodo(img);
	
}


public void setReferenciasObjetivoMovimiento(List<ImageView> nuevaLista) {
	// TODO Auto-generated method stub
	tabtierra.setReferenciasObjetivoMovimiento(nuevaLista);
	tabcielo.setReferenciasObjetivoMovimiento(nuevaLista);
}

public void borrarReferenciasObjetivoMovimiento(){
	
	tabtierra.borrarReferenciasObjetivoMovimiento();
	tabcielo.borrarReferenciasObjetivoMovimiento();
	
	
}
public void inicializarTableros(Modelo.Tablero tablero, TableroCieloController controllerTableroCielo, TableroTierraController controllerTableroTierra) {
	// TODO Auto-generated method stub
	
	controllerTableroTierra.inicializarSuperficies(tablero);
	controllerTableroCielo.inicializarSuperficies(tablero);
	
	ubicarAutobots();
}
	private void ubicarAutobots() {
		//	VistaAlgoformer vistaOptimus=new VistaOptimus(Optimus.getOptimus());
			//vistaOptimus.dibujar(tablero_tierra);
			VistaBumblebee vistaBumblebee=new VistaBumblebee(Bumblebee.getBumblebee(),this);
		
			vistaBumblebee.dibujar();
		//	VistaAlgoformer vistaRatchet=new VistaRatchet(Ratchet.getRatchet());
			//vistaRatchet.dibujar(tablero_tierra);
		}
}

