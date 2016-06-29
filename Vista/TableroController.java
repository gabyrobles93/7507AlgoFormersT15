package Vista;

import java.io.IOException;

import Vista.Controlador.BotonAyudaController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableroController {
	Stage stage;
	Scene proximaescena;
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

	BotonAyudaController ayudacontroller = new BotonAyudaController(stage);
	
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Aplicacion.class.getResource("Ayuda.fxml"));
    loader.setController(ayudacontroller);
    
    Parent vistaayuda =  loader.load();
    
    Scene nuevascene = new Scene(vistaayuda);
	
    
	
}

}