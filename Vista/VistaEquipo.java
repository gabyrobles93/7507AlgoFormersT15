package Vista;

import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;

public abstract class VistaEquipo {
	protected Juego juego;
	protected Equipo equipo;
	protected GridPane tab;
	protected ContenedorPrincipal contenedor;
	protected VistaTerreno vistaTerreno;

	public static VistaEquipo getVistaEquipo(Juego juego,Equipo equipoJugador, GridPane tab, ContenedorPrincipal contenedor, VistaTerreno vistaTerreno) {
		if(equipoJugador.equals(juego.getAutobots())){
			return new VistaAutobots(juego,tab,contenedor,vistaTerreno);
		}else{
			return new VistaDecepticons(juego,tab,contenedor,vistaTerreno);
		}
	}

	public void dibujarBotonesJugador() {
		 
		
	}

	public void dibujarImagenEnemigo() {
		
		
	}

}
