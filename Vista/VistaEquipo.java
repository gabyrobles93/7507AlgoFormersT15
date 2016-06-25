package Vista;

import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class VistaEquipo {
	protected Juego juego;
	protected Equipo equipo;
	protected GridPane tab;
	protected ContenedorPrincipal contenedor;
	protected VistaTerreno vistaTerreno;
	protected Stage stage;

	public static VistaEquipo getVistaEquipo(Stage stage,Juego juego,Equipo equipoJugador, GridPane tab, ContenedorPrincipal contenedor, VistaTerreno vistaTerreno) {
		
		if(equipoJugador.equals(juego.getAutobots())){
			return new VistaAutobots( stage,juego,tab,contenedor,vistaTerreno);
		}else{
			return new VistaDecepticons(stage,juego,tab,contenedor,vistaTerreno);
		}
	}

	public void dibujarBotonesJugador() {
		 
		
	}

	public void dibujarImagenEnemigo() {
		
		
	}

}
