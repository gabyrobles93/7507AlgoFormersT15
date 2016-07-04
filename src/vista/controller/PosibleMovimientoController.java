package vista.controller;

import vista.Aplicacion;
import modelo.ErrorAlgoformerHumanoideNoPuedePasarPorPantano;
import modelo.ErrorCasillerOcupado;
import modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Juego;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Posicion;
import vista.VistaAlgoformer;

public class PosibleMovimientoController {

	public static Juego juego;
	@FXML ImageView vista_posible_movimiento;
	Algoformer algoformer;
	VistaAlgoformer vistaalgoformer;
	menuAccionesController menucontroller;
	
	int fila;
	int columna;
	Stage ventana;
	
	public void setParametros(Algoformer algof, int row, int column, VistaAlgoformer vistaalgof,
		menuAccionesController menuAccionesController, Stage vent) {
		// TODO Auto-generated method stub
		algoformer = algof;
		fila = row;
		columna = column;
		vistaalgoformer = vistaalgof;
		menucontroller = menuAccionesController;
		ventana = vent;
	}
	
	public void mover(){
		
		Posicion nuevaposicion = new Posicion(fila, columna);
		
		try{
			
			algoformer.mover(nuevaposicion);
			menucontroller.borrarZonaObjetivoMovimiento();
			menucontroller.redibujarAlgoformers();
			ventana.close();
			Aplicacion.juego.jugarTurno();
			
		}catch(ErrorCasillerOcupado e){
			
			mostrarErrorCasilleroOcupado();

			
		}catch(ErrorCasillerosNoConectadosPorLineaRecta e){
			
			mostrarErrorCasillerosNoConectadosPorLineaRecta();

		}catch(ErrorAlgoformerHumanoideNoPuedePasarPorPantano e){
			
			mostrarErrorAlgoformerHumanoideNoPuedePasarPorPantano();

		}catch(ErrorVelocidadDelMovilInsuficiente e){
			
			mostrarErrorVelocidadDelMovilInsuficiente();
		}		
		
	}
	
	private void mostrarErrorVelocidadDelMovilInsuficiente() {
		// TODO Auto-generated method stub
		
		HBox hb=new HBox();
		Text txt=new Text("velocidad Insuficiente, atento con el pantano");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
	}

	private void mostrarErrorAlgoformerHumanoideNoPuedePasarPorPantano() {
		// TODO Auto-generated method stub
		
		HBox hb=new HBox();
		Text txt=new Text("Oh! te has topado con una superficie pantanosa, no puedes pisarla en modo humanoide");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
	}

	private void mostrarErrorCasillerosNoConectadosPorLineaRecta() {
		// TODO Auto-generated method stub
		
		HBox hb=new HBox();
		Text txt=new Text("Los Casilleros deben estar en linea recta ");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
	}

	private void mostrarErrorCasilleroOcupado() {
		// TODO Auto-generated method stub
		
		HBox hb=new HBox();
		Text txt=new Text("Los Casilleros deben estar desocupados ");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
	}
	
	


	
	public ImageView getVista() {
		// TODO Auto-generated method stub
		return vista_posible_movimiento;
	}
	
}
