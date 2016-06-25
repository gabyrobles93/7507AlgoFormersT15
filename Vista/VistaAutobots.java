package Vista;

import Modelo.Autobots;
import Modelo.Decepticons;
import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaAutobots extends VistaEquipo {

	public VistaAutobots(Stage stage,Juego juego, GridPane tab, ContenedorPrincipal contenedor,
			VistaTerreno vistaTerreno) {
		this.contenedor=contenedor;
		this.equipo=juego.getAutobots();
		this.tab=tab;
		this.vistaTerreno=vistaTerreno;
		this.juego=juego;
		this.stage=stage;
	}
@Override
public void dibujarBotonesJugador() {
	VistaAlgoformer vistaOptimus=new VistaAlgoformer(stage,((Autobots) equipo).getOptimus(),tab,"O",contenedor,juego,vistaTerreno);
	vistaOptimus.dibujar();
	VistaAlgoformer vistaBumblebee=new VistaAlgoformer(stage,((Autobots) equipo).getBumblebee(),tab,"B",contenedor,juego,vistaTerreno);
	vistaBumblebee.dibujar();
	VistaAlgoformer vistaRatchet=new VistaAlgoformer(stage,((Autobots) equipo).getRatchet(),tab,"R",contenedor,juego,vistaTerreno);
	vistaRatchet.dibujar();
		
	}
@Override
public void dibujarImagenEnemigo(){
	VistaAlgoformer vistaOptimus=new VistaAlgoformer(stage,((Autobots) equipo).getOptimus(),tab,"O",contenedor,juego,vistaTerreno);
	vistaOptimus.dibujarImagen("O",Color.BLUE);
	VistaAlgoformer vistaBumblebee=new VistaAlgoformer(stage,((Autobots) equipo).getBumblebee(),tab,"B",contenedor,juego,vistaTerreno);
	vistaBumblebee.dibujarImagen("B",Color.BLUE);
	VistaAlgoformer vistaRatchet=new VistaAlgoformer(stage,((Autobots) equipo).getRatchet(),tab,"R",contenedor,juego,vistaTerreno);
	vistaRatchet.dibujarImagen("R",Color.BLUE);
	
}
}
