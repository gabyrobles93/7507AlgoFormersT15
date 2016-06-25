package Vista;

import Modelo.Decepticons;
import Modelo.Equipo;
import Modelo.Juego;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaDecepticons extends VistaEquipo {

	public VistaDecepticons(Stage stage,Juego juego, GridPane tab, ContenedorPrincipal contenedor,
			VistaTerreno vistaTerreno) {
		this.contenedor=contenedor;
		this.equipo=juego.getDecepticons();
		this.tab=tab;
		this.vistaTerreno=vistaTerreno;
		this.juego=juego;
		this.stage=stage;
	}
@Override
public void dibujarBotonesJugador() {
		 VistaAlgoformer vistaMega=new VistaAlgoformer(stage,((Decepticons) equipo).getMegatron(),tab,"M",contenedor,juego,vistaTerreno);
		vistaMega.dibujar();
		VistaAlgoformer vistaBone=new VistaAlgoformer(stage,((Decepticons) equipo).getBonecrusher(),tab,"B",contenedor,juego,vistaTerreno);
		vistaBone.dibujar();
		VistaAlgoformer vistaFrenzy=new VistaAlgoformer(stage,((Decepticons) equipo).getFrenzy(),tab,"F",contenedor,juego,vistaTerreno);
		vistaFrenzy.dibujar();
	}
@Override
public void dibujarImagenEnemigo(){
	 VistaAlgoformer vistaMega=new VistaAlgoformer(stage,((Decepticons) equipo).getMegatron(),tab,"M",contenedor,juego,vistaTerreno);
		vistaMega.dibujarImagen("M",Color.RED);
		VistaAlgoformer vistaBone=new VistaAlgoformer(stage,((Decepticons) equipo).getBonecrusher(),tab,"B",contenedor,juego,vistaTerreno);
		vistaBone.dibujarImagen("B",Color.RED);
		VistaAlgoformer vistaFrenzy=new VistaAlgoformer(stage,((Decepticons) equipo).getFrenzy(),tab,"F",contenedor,juego,vistaTerreno);
		vistaFrenzy.dibujarImagen("F",Color.RED);
}
}
