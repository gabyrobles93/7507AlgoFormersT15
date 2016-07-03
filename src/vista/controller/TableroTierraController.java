/*
package vista.controller;

import vista.VistaSuperficie;
import vista.VistaBonecrusher;
import vista.VistaBumblebee;
import vista.VistaFrenzy;
import vista.VistaMegatron;
import vista.VistaOptimus;
import vista.VistaRatchet;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Autobots;
import modelo.Decepticons;
import modelo.Tablero;

public class TableroTierraController {

	@FXML GridPane tablero_tierra;
	@FXML ScrollPane vista_tablero_tierra;
	List<ImageView> listaReferencias;
	TableroController tablerocontroller;

	
	public Node getVistaTablero() {
		// TODO Auto-generated method stub
		return vista_tablero_tierra;
	}

	public void inicializarSuperficies(Tablero tablero) {
		// TODO Auto-generated method stub
		
		for( int fila = 0; fila < 50; fila++){
			for( int columna = 0; columna < 50; columna ++){
			
			VistaSuperficie vista = VistaSuperficie.crearVista(tablero.getCasillero(fila, columna).getSuperficieTierra());
			vista.dibujar(tablero_tierra, fila, columna);
			
			}
		}
	}

	public void ubicarAutobots(Autobots autobots) throws Exception{
		// TODO Auto-generated method stub
		VistaBumblebee vistaBumblebee = new VistaBumblebee(autobots.getBumblebee(), tablerocontroller);
		vistaBumblebee.dibujar(tablero_tierra, autobots.getBumblebee().getPosicion().getFila(), autobots.getBumblebee().getPosicion().getColumna());
			
		VistaOptimus vistaOptimus = new VistaOptimus();
		vistaOptimus.dibujar(tablero_tierra, autobots.getOptimus().getPosicion().getFila(), autobots.getOptimus().getPosicion().getColumna());
			
		VistaRatchet vistaRatchet = new VistaRatchet();
		vistaRatchet.dibujar(tablero_tierra, autobots.getRatchet().getPosicion().getFila(), autobots.getRatchet().getPosicion().getColumna());
	}

	public void ubicarDecepticons(Decepticons decepticons) {
		// TODO Auto-generated method stub
		
		VistaBonecrusher vistabonecrusher = new VistaBonecrusher();
		vistabonecrusher.dibujar(tablero_tierra, decepticons.getBonecrusher().getPosicion().getFila(), decepticons.getBonecrusher().getPosicion().getColumna());
			
		VistaFrenzy vistafrenzy = new VistaFrenzy();
		vistafrenzy.dibujar(tablero_tierra, decepticons.getFrenzy().getPosicion().getFila(), decepticons.getFrenzy().getPosicion().getColumna());
			
		VistaMegatron vistamegatron = new VistaMegatron();
		vistamegatron.dibujar(tablero_tierra, decepticons.getMegatron().getPosicion().getFila(), decepticons.getMegatron().getPosicion().getColumna());
	}

	public void dibujarNodo(ImageView imagen, int columna, int fila) {
		// TODO Auto-generated method stub
		tablero_tierra.add(imagen,fila,columna);
	}

	public void setReferenciasObjetivoMovimiento(List<ImageView> nuevalista) {
		// TODO Auto-generated method stub
		listaReferencias.addAll(nuevalista);
	}

	public void setTableroController(TableroController tabcont) {
		// TODO Auto-generated method stub
		tablerocontroller = tabcont;
	}
	
}
*/