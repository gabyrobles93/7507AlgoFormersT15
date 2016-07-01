package Vista;

import java.io.File;
import java.io.IOException;

import Modelo.Bonecrusher;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.menuAccionesAlgoformerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaBonecrusher extends VistaAlgoformer {

	protected ImageView vistaBonecrusher;
	protected VistaBonecrusherController controllerBonecrusher;

private GridPane tablero;
	public VistaBonecrusher(Bonecrusher bonecrusher,TableroController tableroController) {
		this.algof=bonecrusher;
		this.tableroController=tableroController;

	}
	@Override
	public void dibujar() {
		try {
			FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(Aplicacion.class.getResource("Bonecrusher.fxml"));
					
				/*	File file = new File("C:\\imagenes\\decepticons\\humanoide\\bonecrusher.png");
	
					Image imagebonecrusher = new Image(file.toURI().toString());
					ImageView picbonecrusher = new ImageView();
					picbonecrusher.setId("imagenBonecrusherHumanoide");
					picbonecrusher.setFitWidth(75);
					picbonecrusher.setFitHeight(75);
					picbonecrusher.setImage(imagebonecrusher);*/
						
			
					this.vistaBonecrusher = loader3.load();
					
				//	vistaBonecrusher.getChildren().add(picbonecrusher);
					
					controllerBonecrusher = loader3.getController();
					
					controllerBonecrusher.setControllerTablero(tableroController);
					controllerBonecrusher.setAlgoformer(algof);
					controllerBonecrusher.dibujar();
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
		///controllerBonecrusher.dibujar();
	}
	
	public void redibujar(){
		controllerBonecrusher.dibujar();
	}
    
}