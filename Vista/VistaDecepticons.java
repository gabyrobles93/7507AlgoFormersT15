package Vista;

import Modelo.Decepticons;
import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;

public class VistaDecepticons extends VistaEquipo {

	public VistaDecepticons(Juego juego, GridPane tab, ContenedorPrincipal contenedor,
			VistaTerreno vistaTerreno) {
		this.contenedor=contenedor;
		this.equipo=juego.getDecepticons();
		this.tab=tab;
		this.vistaTerreno=vistaTerreno;
		this.juego=juego;
	}
@Override
public void dibujarBotonesJugador() {
		 VistaAlgoformer vistaMega=new VistaAlgoformer(((Decepticons) equipo).getMegatron(),tab,"M",contenedor,juego,vistaTerreno);
		vistaMega.dibujar();
		VistaAlgoformer vistaBone=new VistaAlgoformer(((Decepticons) equipo).getBonecrusher(),tab,"B",contenedor,juego,vistaTerreno);
		vistaBone.dibujar();
		VistaAlgoformer vistaFrenzy=new VistaAlgoformer(((Decepticons) equipo).getFrenzy(),tab,"F",contenedor,juego,vistaTerreno);
		vistaFrenzy.dibujar();
	}
@Override
public void dibujarImagenEnemigo(){
	 VistaAlgoformer vistaMega=new VistaAlgoformer(((Decepticons) equipo).getMegatron(),tab,"M",contenedor,juego,vistaTerreno);
		vistaMega.dibujarImagen();
		VistaAlgoformer vistaBone=new VistaAlgoformer(((Decepticons) equipo).getBonecrusher(),tab,"B",contenedor,juego,vistaTerreno);
		vistaBone.dibujarImagen();
		VistaAlgoformer vistaFrenzy=new VistaAlgoformer(((Decepticons) equipo).getFrenzy(),tab,"F",contenedor,juego,vistaTerreno);
		vistaFrenzy.dibujarImagen();
}
}
