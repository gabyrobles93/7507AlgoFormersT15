package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.modelo.Direccion;
import src.modelo.Posicion;
import src.modelo.Robot;
import src.modelo.Terreno;
import Modelo.Juego;
import Vista.eventos.AplicacionOnKeyPressEventHandler;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Algoformers");

        Juego juego = crearModelo();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaTurnoAutobots = new Scene(contenedorPrincipal, 640, 480);

       AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal);
        escenaTurnoAutobots.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaTurnoAutobots);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
        
        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

     
        // add handler to this:
        // stage.setOnCloseRequest()

       

        stage.show();

    }

    private Juego crearModelo() {
      Juego juego=new Juego();
      return juego;
    }
}
