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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Algoformer;
import modelo.Juego;
import modelo.Megatron;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Superion;
import vista.Aplicacion;
import vista.VistaAlgoformer;

public class MenuAccionesAlgoformerController extends menuAccionesController{

	@FXML AnchorPane vista_menu_acciones;
	
	@FXML Label nombre;
	@FXML Label vida;
	@FXML Label ataque;
	@FXML Label velocidad;
	@FXML Label esperaturnos;
	@FXML Label alcance;
	@FXML ImageView imagen;
	@FXML Button mover;
	@FXML Button atacar;
	@FXML Button combinar;
	@FXML Button transformar;
	@FXML Button capturarChispa;
	@FXML Button desarmar;
	
	Algoformer algof;
	VistaAlgoformer vistaalgof;
	TableroController tablerocontroller;
	Stage ventana;
	
	public void mostrarZonaAtaque() throws Exception{
		this.borrarZonaObjetivoAtaque();
		this.borrarZonaObjetivoMovimiento();
		
		if(Aplicacion.juego.getEjecutorDeTurnoActual()!=algof.getEquipo()){
			
			mostrarErrorNoEsTuTurno();
			return;
		}else if(algof.getEfecto().esperaturnos!=0){
			mostrarErrorEsperaTurnos();
			return;
		}
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
			        		
			        		tablerocontroller.dibujarNodo(posibleataquecontroller.getVista(), column, row);		             		        		
			        	 	listaReferencias.add(posibleataquecontroller.getVista());	
		            	}
		            }
		        }		 
			 tablerocontroller.setReferenciasObjetivoAtaque(listaReferencias);		
	}
		

	
	private void mostrarErrorEsperaTurnos() {
		// TODO Auto-generated method stub
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Todavia no estas habilitado para jugar con este algoformer");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
	}



	private void mostrarErrorNoEsTuTurno() {
		// TODO Auto-generated method stub
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("No es tu turno.");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
	}



	public void mostrarZonaMovimiento() throws Exception{
		this.borrarZonaObjetivoAtaque();
		this.borrarZonaObjetivoMovimiento();
		if(Aplicacion.juego.getEjecutorDeTurnoActual()!=algof.getEquipo()){
			
			mostrarErrorNoEsTuTurno();
			return;
		}else if(algof.getEfecto().esperaturnos!=0){
			mostrarErrorEsperaTurnos();
			return;
		}
		
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
			        		
			        		tablerocontroller.dibujarNodo(posiblemovimientocontroller.getVista(), column, row);		             		        		
			        	 	listaReferencias.add(posiblemovimientocontroller.getVista());	
		            	}
		            }
		        }		 
			 tablerocontroller.setReferenciasObjetivoMovimiento(listaReferencias);		
	}
	
	public void capturarChispa(){
if(Aplicacion.juego.getEjecutorDeTurnoActual()!=algof.getEquipo()){
			
			mostrarErrorNoEsTuTurno();
			return;
		}else if(algof.getEfecto().esperaturnos!=0){
			mostrarErrorEsperaTurnos();
			return;
		}
		try{
			algof.capturarChispa();
			
			mostrarMensajeVictoria();

		}catch(RuntimeException e){
			
			mostrarErrorImposibleCapturarChispa();
			
		}
	}
	
	public void combinar(){
if(Aplicacion.juego.getEjecutorDeTurnoActual()!=algof.getEquipo()){
			
			mostrarErrorNoEsTuTurno();
			return;
		}else if(algof.getEfecto().esperaturnos!=0){
			mostrarErrorEsperaTurnos();
			return;
		}
	
			try{ 
				tablerocontroller.setReferenciaSuperalgoformer( algof.combinar());//creo el super y se lo asigno a la vista cargada en main
				this.redibujarAlgoformers();
				
				Aplicacion.juego.jugarTurno();
				
				Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
				Label error=new Label("Formar Super Algoformer tomará dos turnos.");
				Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
				
				/*
				VBox vb=new VBox();
				Text txt=new Text("Formar superAlgoformer tomara dos turnos");
				vb.getChildren().add(txt);
				Scene sc=new Scene(vb,200,200);
				vb.setAlignment(Pos.CENTER);
				Stage st =new Stage();
				st.setTitle("formando superAlgoformer");
				st.setScene(sc);
				st.show();
				
				*/
				
			}catch(ErrorDistanciaExcesivaParaFormarSuperion e){
				mostrarErrorSuperionDistanciaExcesiva();
			}catch(ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores e){
				mostrarErrorSuperionPosicionInvalida();
			}
		}
	public void cambiarModo(){
if(Aplicacion.juego.getEjecutorDeTurnoActual()!=algof.getEquipo()){
			
			mostrarErrorNoEsTuTurno();
			return;
		}else if(algof.getEfecto().esperaturnos!=0){
			mostrarErrorEsperaTurnos();
			return;
		}
		try{
			algof=algof.cambiarModo();
			vistaalgof.cambiarModoActualizarRef();
			this.redibujarAlgoformers();
			
			Aplicacion.juego.jugarTurno();
		}catch(RuntimeException e){
			System.out.println("error en cambiar modo");
		}
	}

	
	
	
	private void mostrarErrorSuperionPosicionInvalida() {
		// TODO Auto-generated method stub
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Posicion de nacimiento de superion invalida.");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
		
		/*HBox hb=new HBox();
		Text txt=new Text("Posicion de nacimiento de superion invalida.");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		*/
	}



	private void mostrarErrorSuperionDistanciaExcesiva() {
		// TODO Auto-generated method stub
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Distancia Excesiva entre Autobots para formar Superion.");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
		
	/*	HBox hb=new HBox();
		Text txt=new Text("Distancia Excesiva entre Autobots para formar Superion.");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Stage st = new Stage();
		st.setTitle("Error");
		st.setScene(sc);
		st.setFullScreen(false);
		st.show();		*/
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
		Label error=new Label("Han Ganado los Decepticons.");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
		
		/*HBox hb=new HBox();
		Text txt=new Text("Han Ganado los Decepticons");
		hb.getChildren().add(txt);
		hb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(hb,200,200);
		Aplicacion.ventanaPrincipal.setTitle("Juego Terminado");
		Aplicacion.ventanaPrincipal.setScene(sc);
		Aplicacion.ventanaPrincipal.setFullScreen(true);
		Aplicacion.ventanaPrincipal.show();		*/
	}



	private void mostrarAutobotsGanaron() {
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Han ganado los Autobots");
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



	private void mostrarErrorImposibleCapturarChispa() {
		
		Aplicacion.ventanaprincipalcontroller.info.getChildren().clear();
		Label error=new Label("Error imposible capturar Chispa");
		Aplicacion.ventanaprincipalcontroller.info.getChildren().add(error);
/*
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
*/
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



	public void actualizarInfo(String string) {
		// TODO Auto-generated method stub
		nombre.setText(string);
		vida.setText("Vida "+String.valueOf(algof.getVida()));
		ataque.setText("Ataque "+String.valueOf(algof.getAtaque()));
		velocidad.setText("Velocidad "+String.valueOf(algof.getVelocidad()));
		esperaturnos.setText("Espera Turnos "+String.valueOf(algof.getEfecto().esperaturnos));
	}



	public void HabilitarBotonesSuper() {
		// TODO Auto-generated method stub
		atacar.setDisable(false);
		mover.setDisable(false);
		capturarChispa.setDisable(false);
		desarmar.setDisable(false);
		transformar.setDisable(true);
		combinar.setDisable(true);
	}
	public void HabilitarBotonesAlgoformer(){
		atacar.setDisable(false);
		mover.setDisable(false);
		capturarChispa.setDisable(false);
		desarmar.setDisable(true);
		transformar.setDisable(false);
		combinar.setDisable(false);
	}
	
}
