package vista.controller;

import java.util.ArrayList;
import java.util.List;

import modelo.ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores;
import modelo.ErrorDistanciaExcesivaParaFormarSuperion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Juego;
import modelo.Posicion;
import modelo.Superion;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class MenuAccionesAlgoformerController {

	@FXML AnchorPane vista_menu_acciones;
	Algoformer algof;
	VistaAlgoformer vistaalgof;
	TableroController tablerocontroller;
	Stage ventana;
	
	public void mostrarZonaAtaque() throws Exception{
		PosibleAtaqueController posibleataquecontroller;
		
		int distanciaACubrir = algof.getDistanciaDeAtaque();
		int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
		int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
		
		int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
		int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
		
		Posicion posicionalgoformer = algof.getPosicion();
		
		List<ImageView> listaReferencias = new ArrayList<ImageView>();
		
			 for (int column=minColumn; column<=maxColumn; column++) {
		            for (int row = minFila ; row<=maxFila; row++) {
		            	if( !((column == posicionalgoformer.getColumna()) && (row == posicionalgoformer.getFila())) ){ 
			        		FXMLLoader loader = new FXMLLoader();
			        		loader.setLocation(Aplicacion.class.getResource("PosibleAtaque.fxml"));
			        		loader.load();
			        		
			        		posibleataquecontroller = loader.getController();
			        		posibleataquecontroller.setParametros(algof, row, column, vistaalgof, this, ventana);
			        		
			        		tablerocontroller.dibujarNodo(posibleataquecontroller.getVista(), row, column);		             		        		
			        	 	listaReferencias.add(posibleataquecontroller.getVista());	
		            	}
		            }
		        }		 
			 tablerocontroller.setReferenciasObjetivoAtaque(listaReferencias);		
	}
		

	
	public void mostrarZonaMovimiento() throws Exception{
		
		PosibleMovimientoController posiblemovimientocontroller;
		
		int distanciaACubrir = algof.getVelocidad();
		int minColumn = (algof.getPosicion().getColumna()-distanciaACubrir>=0)?algof.getPosicion().getColumna()-distanciaACubrir:0;
		int maxColumn = (algof.getPosicion().getColumna()+distanciaACubrir>=50)?49:algof.getPosicion().getColumna()+distanciaACubrir;	
		
		int minFila = (algof.getPosicion().getFila()-distanciaACubrir>=0)?algof.getPosicion().getFila()-distanciaACubrir:0;
		int maxFila = (algof.getPosicion().getFila()+distanciaACubrir>=50)?49:algof.getPosicion().getFila()+distanciaACubrir;	
		
		Posicion posicionalgoformer = algof.getPosicion();
		
		List<ImageView> listaReferencias = new ArrayList<ImageView>();
		
			 for (int column=minColumn; column<=maxColumn; column++) {
		            for (int row = minFila ; row<=maxFila; row++) {
		            	if( !((column == posicionalgoformer.getColumna()) && (row == posicionalgoformer.getFila())) ){ 
			        		FXMLLoader loader = new FXMLLoader();
			        		loader.setLocation(Aplicacion.class.getResource("PosibleMovimiento.fxml"));
			        		loader.load();
			        		
			        		posiblemovimientocontroller = loader.getController();
			        		posiblemovimientocontroller.setParametros(algof, row, column, vistaalgof, this, ventana);
			        		
			        		tablerocontroller.dibujarNodo(posiblemovimientocontroller.getVista(), row, column);		             		        		
			        	 	listaReferencias.add(posiblemovimientocontroller.getVista());	
		            	}
		            }
		        }		 
			 tablerocontroller.setReferenciasObjetivoMovimiento(listaReferencias);		
	}
	
	public void capturarChispa(){
		try{
			algof.capturarChispa();
			ventana.close();
			mostrarMensajeVictoria();

		}catch(RuntimeException e){
			
			mostrarErrorImposibleCapturarChispa();
			
		}
	}
	
	public void combinar(){

		if(algof.comparteEquipoCon(Aplicacion.juego.autobots.getOptimus())){
			try{
				Superion superion=new Superion(Aplicacion.juego.autobots.getOptimus(),Aplicacion.juego.autobots.getBumblebee(),Aplicacion.juego.autobots.getRatchet(),Aplicacion.juego.autobots.getOptimus().getPosicion());
			}catch(ErrorDistanciaExcesivaParaFormarSuperion e){
				mostrarErrorSuperionDistanciaExcesiva();
			}catch(ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores e){
				mostrarErrorSuperionPosicionInvalida();
			}
		}

	}
	
	
	private void mostrarErrorSuperionPosicionInvalida() {
		// TODO Auto-generated method stub
		HBox hb=new HBox();
		Text txt=new Text("Posicion de nacimiento de superion invalida.");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		
	}



	private void mostrarErrorSuperionDistanciaExcesiva() {
		// TODO Auto-generated method stub
		HBox hb=new HBox();
		Text txt=new Text("Distancia Excesiva entre Autobots para formar Superion.");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		
	}



	private void mostrarMensajeVictoria() {
		if(Aplicacion.juego.getGanador()==Aplicacion.juego.autobots){
			mostrarAutobotsGanaron();
		}else{
			mostrarDecepticonsGanaron();
		}
	}



	private void mostrarDecepticonsGanaron() {
		HBox hb=new HBox();
		Text txt=new Text("Han Ganado los Decepticons");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setScene(sc);
		Aplicacion.ventanaPrincipal.setFullScreen(true);
		Aplicacion.ventanaPrincipal.show();		
	}



	private void mostrarAutobotsGanaron() {
		
		HBox hb=new HBox();
		Text txt=new Text("Han ganado los Autobots");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setScene(sc);
		Aplicacion.ventanaPrincipal.setFullScreen(true);
		Aplicacion.ventanaPrincipal.show();		
	}



	private void mostrarErrorImposibleCapturarChispa() {

		HBox hb=new HBox();
		Text txt=new Text("Error imposible capturar Chispa");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		
	}



	public void mostrarEstado(){
		VBox hb=new VBox();
		Text txt1=new Text("Vida "+String.valueOf(algof.getVida()));
		Text txt2=new Text("Ataque "+String.valueOf(algof.getAtaque()));
		Text txt3=new Text("Velocidad "+String.valueOf(algof.getVelocidad()));
		Text txt4=new Text("Espera Turnos "+String.valueOf(algof.getEfecto().esperaturnos));
		hb.getChildren().addAll(txt1,txt2,txt3,txt4);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Estado del Algoformer");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();
		
	}


	public Parent getVista() {
		// TODO Auto-generated method stub
		return vista_menu_acciones;
	}

	public void setAlgoformer(Algoformer algoformer, VistaAlgoformer vistaalgoformer) {
		// TODO Auto-generated method stub
		algof = algoformer;
		vistaalgof = vistaalgoformer;
	}
	
	public void setTableroController(TableroController tabcontroller){
		tablerocontroller = tabcontroller;
	}

	public void borrarZonaObjetivoMovimiento() {
		// TODO Auto-generated method stub
		tablerocontroller.borrarZonaObjetivoMovimiento();
	}

	public void redibujarAlgoformers() {
		// TODO Auto-generated method stub
		tablerocontroller.redibujarAlgoformers();
	}

	public void setStage(Stage vent) {
		// TODO Auto-generated method stub
		ventana = vent;
	}



	public void borrarZonaObjetivoAtaque() {
		// TODO Auto-generated method stub
		tablerocontroller.borrarZonaObjetivoAtaque();
	}
	
}
