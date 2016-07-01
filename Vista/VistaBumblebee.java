package Vista;

import java.io.File;
import java.io.IOException;

import Modelo.Algoformer;
import Modelo.Bumblebee;
import Vista.Controlador.BotonMoverHandler;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.menuAccionesAlgoformerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaBumblebee extends VistaAlgoformer{


private GridPane tablero;
	public VistaBumblebee(Bumblebee bumblebee,TableroController tableroController) {
		this.algof=bumblebee;
		this.tableroController=tableroController;
	}
	@Override
	public void dibujar() {
		try {
			FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(Aplicacion.class.getResource("Bumblebee.fxml"));
					
					File file = new File("C:\\imagenes\\decepticons\\humanoide\\bonecrusher.png");
	
					Image imagebonecrusher = new Image(file.toURI().toString());
					ImageView picbonecrusher = new ImageView();
					picbonecrusher.setId("imagenBumblebeeHumanoide");
					picbonecrusher.setFitWidth(75);
					picbonecrusher.setFitHeight(75);
					picbonecrusher.setImage(imagebonecrusher);
						
			
					vistaBumblebee = loader3.load();
					
					vistaBumblebee.getChildren().add(picbonecrusher);
					
					controllerBumblebee = loader3.getController();
					
					controllerBumblebee.setControllerTablero(tableroController);
					controllerBumblebee.setAlgoformer(algof);
					controllerBumblebee.dibujar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		/*if(algof.getVida()==0){
			return;
		}
		if(algof.getEfecto().esperaturnos!=0){
			dibujarImagen(nombre,Color.GREEN);
			return;
		}
		
		MenuItem mi=new MenuItem("atacar");
		MenuItem mi2=new MenuItem("mover");
		MenuItem mi3 =new MenuItem("cambiar modo");
		MenuItem verEstado =new MenuItem("ver estado");
		MenuItem capturarChispa =new MenuItem("capturar chispa");
		
		MenuButton algo =new MenuButton(nombre,null,mi,mi2,mi3,verEstado,capturarChispa);
		algo.setTextFill(Color.AZURE);
		//BotonSeleccionarAlgoformerEventHandler handlerSeleccionar= new BotonSeleccionarAlgoformerEventHandler();
		//algo.setOnAction(handlerSeleccionar);
		ContenedorJuegoFinalizado contenedorFinal= new ContenedorJuegoFinalizado(stage,juego);
		Scene escenaFinal =new Scene(contenedorFinal);
		
		BotonCapturarChispaHandler handlerCapturarChispa=new BotonCapturarChispaHandler(stage,this.algof,this.vista,escenaFinal);
		capturarChispa.setOnAction(handlerCapturarChispa);
		
		BotonMoverHandler handlerMover=new BotonMoverHandler(vista,algof,contenedor, this);
		mi2.setOnAction(handlerMover);
		
		BotonAtacarHandler handlerAtacar=new BotonAtacarHandler(vista,algof,this);
		mi.setOnAction(handlerAtacar);
		
		BotonCambiarModoHandler handlerCambiarModo= new BotonCambiarModoHandler(vista,algof,this);
		mi3.setOnAction(handlerCambiarModo);
		
		BotonVerEstadoHandler botonHandler=new BotonVerEstadoHandler(algof);
		verEstado.setOnAction(botonHandler);
		
		GridPane.setConstraints(algo, algof.getPosicion().getColumna(), algof.getPosicion().getFila());
		
		*/
		///controllerBumblebee.dibujar();
	}
	
	
    
}
