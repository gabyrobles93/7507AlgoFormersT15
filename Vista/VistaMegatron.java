package Vista;


import java.io.File;
import java.io.IOException;

import Modelo.Bumblebee;
import Modelo.Megatron;
import Vista.Controlador.VerEstadoAlgoformerController;
import Vista.menuAccionesAlgoformerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaMegatron extends VistaAlgoformer {
	protected ImageView vistaMegatron;
	protected VistaMegatronController controllerMegatron;
	
	private GridPane tablero;
	public VistaMegatron(Megatron megatron,TableroController tableroController) {
		this.algof=megatron;
		this.tableroController=tableroController;
	}
	
	@Override
	public void dibujar() {
		try {
			FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(Aplicacion.class.getResource("Megatron.fxml"));
					
				/*	File file = new File("C:\\imagenes\\decepticons\\humanoide\\bonecrusher.png");
	
					Image imagebonecrusher = new Image(file.toURI().toString());
					ImageView picbonecrusher = new ImageView();
					picbonecrusher.setId("imagenBumblebeeHumanoide");
					picbonecrusher.setFitWidth(75);
					picbonecrusher.setFitHeight(75);
					picbonecrusher.setImage(imagebonecrusher);*/
						
			
					this.vistaMegatron = loader3.load();
					
				//	vistaBumblebee.getChildren().add(picbonecrusher);
					
					controllerMegatron = loader3.getController();
					
					controllerMegatron.setControllerTablero(tableroController);
					controllerMegatron.setAlgoformer(algof);
					controllerMegatron.dibujar();
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
