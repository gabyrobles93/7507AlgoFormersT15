package EJEMPLOS;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loadertierra = new FXMLLoader(getClass().getResource("TableroTierra.fxml"));
		Parent rootTableroTierra = loadertierra.load();
		TableroTierraController controllerTableroTierra = loadertierra.getController();
		
		
		FXMLLoader loadercielo = new FXMLLoader(getClass().getResource("TableroCielo.fxml"));
		Parent rootTableroCielo = loadercielo.load();
		TableroCieloController controllerTableroCielo = loadercielo.getController();
		


		
		
		Scene sceneTierra = new Scene(rootTableroTierra);
		Scene sceneCielo = new Scene(rootTableroCielo);
		
		controllerTableroCielo.setStage(primaryStage);
		controllerTableroTierra.setStage(primaryStage);

		controllerTableroCielo.setProximaEscena(sceneTierra);
		controllerTableroTierra.setProximaEscena(sceneCielo);
		
		controllerTableroCielo.inicializarTableroCielo(controllerTableroTierra.inicializarTableroTierra());
		controllerTableroTierra.updateGridPane();
		
		primaryStage.setTitle("Gordo Pablo Chupavergas");
		primaryStage.setScene(sceneTierra);
		primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
