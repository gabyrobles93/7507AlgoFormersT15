
package vista.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Megatron;
import vista.Aplicacion;

public class VentanaPrincipalController {

	@FXML BorderPane vista_ventana_principal;
	@FXML MenuBar barra_de_menu;
	@FXML VBox botones;
	@FXML HBox info;
	Algoformer algof=Megatron.getMegatron();
	TableroController tablerocontroller;
	Stage ventanaPrincipal;
	
	public void setBarraDeMenu(MenuBar barrademenu) {
		// TODO Auto-generated method stub
		vista_ventana_principal.setTop(barrademenu);
	}

	public void mostrarVentanaPrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		Scene scene = new Scene(vista_ventana_principal);
		ventana.setScene(scene);
		
		ventana.setTitle("Algoformers");
		ventana.setScene(scene);
		ventana.show();
	}

	public void mostrarTablero() {
		// TODO Auto-generated method stub
		vista_ventana_principal.setCenter(tablerocontroller.getVistaTablero());
		
	//	vista_ventana_principal.setBottom(info);
	//	vista_ventana_principal.setLeft(botones);
		
		ventanaPrincipal.show();
	}


	public void setTablero(TableroController tabcontr) {
		// TODO Auto-generated method stub
		tablerocontroller = tabcontr;
	}

	public void setVentana(Stage ventprin) {
		// TODO Auto-generated method stub
		ventanaPrincipal = ventprin;
	}
public void setAlgoformer(Algoformer algof, String string){
	/*this.algof=algof;
	botones.getChildren().clear();
	Text txt0 =new Text(string);
	Text txt1=new Text("Vida "+String.valueOf(algof.getVida()));
	Text txt2=new Text("Ataque "+String.valueOf(algof.getAtaque()));
	Text txt3=new Text("Velocidad "+String.valueOf(algof.getVelocidad()));
	Text txt4=new Text("Espera Turnos "+String.valueOf(algof.getEfecto().esperaturnos));
	botones.getChildren().addAll(txt0,txt1,txt2,txt3,txt4);
	*/
}

public void setMenuAcciones(VBox menu) {
	// TODO Auto-generated method stub
	vista_ventana_principal.setLeft(menu);
}

}
