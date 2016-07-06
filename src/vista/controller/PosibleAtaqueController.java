package vista.controller;

import modelo.Casillero;
import modelo.ErrorAlgoformerInexistente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.ErrorAlgoformerHumanoideNoPuedePasarPorPantano;
import modelo.ErrorCasillerOcupado;
import modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Juego;
import modelo.Posicion;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class PosibleAtaqueController {

	@FXML ImageView vista_posible_ataque;
	Algoformer algoformer;
	VistaAlgoformer vistaalgoformer;
	menuAccionesController menucontroller;

	int fila;
	int columna;
	Stage ventana;
	
	public void setParametros(Algoformer algof, int row, int column, VistaAlgoformer vistaalgof,menuAccionesController menuAccionesAlgoformerController, Stage vent) {
	
		algoformer = algof;
		fila = row;
		columna = column;
		vistaalgoformer = vistaalgof;
		menucontroller = menuAccionesAlgoformerController;
		ventana = vent;
	}
	
	
	public void atacar(){
		
		Casillero casAux;
		casAux=Aplicacion.juego.getTablero().getCasillero(fila, columna);
		
		try{
			algoformer.atacar((Algoformer)(casAux.getMovilOcupa()));
			menucontroller.borrarZonaObjetivoAtaque();
			menucontroller.redibujarAlgoformers();
			
			if(Aplicacion.juego.getGanador()!=null){
				mostrarMensajeVictoria();
			}
			Aplicacion.juego.jugarTurno();
			
		}catch(ErrorAlgoformerInexistente e){
			mostrarErrorAlgoformerInexistente();
		
			
		}catch(ErrorNoSePuedeAtacarIntegranteDeEquipo e){
			mostrarNoSePuedeAtacarIntegranteDeEquipo();
		}
		
	
}
	
	private void mostrarMensajeVictoria() {
		if(Aplicacion.juego.getGanador()==Aplicacion.juego.autobots){
			mostrarAutobotsGanaron();
		}else{
			mostrarDecepticonsGanaron();
		}
	}



	private void mostrarDecepticonsGanaron() {
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Han Ganado los Decepticons");
		error.setTextFill(Color.WHITE);
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
	/*
		HBox hb=new HBox();
		Text txt=new Text("Han Ganado los Decepticons");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setScene(sc);
		Aplicacion.ventanaPrincipal.setFullScreen(true);
		Aplicacion.ventanaPrincipal.show();		
	*/
	}
	



	private void mostrarAutobotsGanaron() {
	
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Juego Terminado");
		error.setTextFill(Color.WHITE);
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
	 /*
		HBox hb=new HBox();
		Text txt=new Text("Han ganado los Autobots");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setScene(sc);
		Aplicacion.ventanaPrincipal.setFullScreen(true);
		Aplicacion.ventanaPrincipal.show();		
		*/
	}
		
	
	private void mostrarErrorAlgoformerInexistente() {

		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Error, no hay ninguna victima en ese casillero");
		error.setTextFill(Color.WHITE);
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
		
		/*
		HBox hb=new HBox();
		Text txt=new Text("Error, no hay ninguna victima en ese casillero");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		
		*/
	}

	private void mostrarNoSePuedeAtacarIntegranteDeEquipo() {
		// TODO Auto-generated method stub
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Error, no puedes atacar otro algoformer de tu mismo equipo");
		error.setTextFill(Color.WHITE);
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
		
		/*
		HBox hb=new HBox();
		Text txt=new Text("Error, no puedes atacar otro algoformer de tu mismo equipo");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
		
		*/
	}




	
	

	
	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vista_posible_ataque;
	}



}
