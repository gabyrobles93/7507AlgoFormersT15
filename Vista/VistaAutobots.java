package Vista;

import Modelo.Autobots;
import Modelo.Decepticons;
import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;

public class VistaAutobots extends VistaEquipo {

	public VistaAutobots(Juego juego, GridPane tab, ContenedorPrincipal contenedor,
			VistaTerreno vistaTerreno) {
		this.contenedor=contenedor;
		this.equipo=juego.getAutobots();
		this.tab=tab;
		this.vistaTerreno=vistaTerreno;
		this.juego=juego;
	}
@Override
public void dibujarBotonesJugador() {
	VistaAlgoformer vistaOptimus=new VistaAlgoformer(((Autobots) equipo).getOptimus(),tab,"O",contenedor,juego,vistaTerreno);
	vistaOptimus.dibujar();
	VistaAlgoformer vistaBumblebee=new VistaAlgoformer(((Autobots) equipo).getBumblebee(),tab,"B",contenedor,juego,vistaTerreno);
	vistaBumblebee.dibujar();
	VistaAlgoformer vistaRatchet=new VistaAlgoformer(((Autobots) equipo).getRatchet(),tab,"R",contenedor,juego,vistaTerreno);
	vistaRatchet.dibujar();
		
	}
@Override
public void dibujarImagenEnemigo(){
	VistaAlgoformer vistaOptimus=new VistaAlgoformer(((Autobots) equipo).getOptimus(),tab,"O",contenedor,juego,vistaTerreno);
	vistaOptimus.dibujarImagen();
	VistaAlgoformer vistaBumblebee=new VistaAlgoformer(((Autobots) equipo).getBumblebee(),tab,"B",contenedor,juego,vistaTerreno);
	vistaBumblebee.dibujarImagen();
	VistaAlgoformer vistaRatchet=new VistaAlgoformer(((Autobots) equipo).getRatchet(),tab,"R",contenedor,juego,vistaTerreno);
	vistaRatchet.dibujarImagen();
	
}
}
