package Vista.Controlador;

import Modelo.Algoformer;
import Modelo.ErrorAlgoformerHumanoideNoPuedePasarPorPantano;
import Modelo.ErrorCasillerOcupado;
import Modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Juego;
import Modelo.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Vista.VistaAlgoformer;
import Vista.VistaBumblebee2;
import Vista.VistaTerreno;
import Vista.menuAccionesAlgoformerController;

public class BotonObjetivoMovimientoHandler implements EventHandler<MouseEvent>{
private final int fila;
private final int columna;
private Algoformer algof;
private  VistaBumblebee2 vistaAlgof;
<<<<<<< HEAD

=======
private  Juego juego;
private menuAccionesAlgoformerController menuacciones;
>>>>>>> 06e14d374c0e8233ca1f390ded8bdd12014fffbd
	
	public BotonObjetivoMovimientoHandler( Algoformer algof,int fila,int columna,VistaBumblebee2 vistaAlgof, menuAccionesAlgoformerController menu){
		this.fila=fila;
		this.columna=columna;
		this.algof=algof;
		this.vistaAlgof=vistaAlgof;
		this.menuacciones = menu;
		//this.juego=juego;
	}
	@Override
	public void handle(MouseEvent arg0) {
		Posicion pos= new Posicion(fila,columna);
		try{
		algof.mover(pos);
		menuacciones.borrarZonaObjetivoMovimiento();
		vistaAlgof.cerrarMenu();
		vistaAlgof.update();
		//juego.jugarTurno();
		}catch(ErrorCasillerOcupado e){
			
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
			
		}catch(ErrorCasillerosNoConectadosPorLineaRecta e){
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
		}catch(ErrorAlgoformerHumanoideNoPuedePasarPorPantano e){
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
		}catch(ErrorVelocidadDelMovilInsuficiente e){
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
	}

}
