package vista.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import modelo.Algoformer;
import modelo.Autobots;
import modelo.Bonecrusher;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.Frenzy;
import modelo.Juego;
import modelo.Megatron;
import modelo.Optimus;
import modelo.Ratchet;
import vista.Aplicacion;
import vista.VistaBumblebee;
import vista.VistaChispa;
import vista.VistaFrenzy;
import vista.VistaMegatron;
import vista.VistaMenasor;
import vista.VistaOptimus;
import vista.VistaRatchet;
import vista.VistaSuperion;
import vista.VistaBonecrusher;


public class TableroController {

	Juego juego;
	List<ImageView> listaReferencias;
	List<ImageView> listaReferenciasSuperficies;
	VistaTableroController vistatablerocontroller;
	ImageView[][] superficiestierra;
	ImageView[][] superficiescielo;
	
	public ImageView imagenBumblebee;
	
	public ImageView imagenOptimus;
	public ImageView imagenRatchet;
	public ImageView imagenMegatron;
	public ImageView imagenBonecrusher;
	
	public ImageView imagenFrenzy;
	public ImageView imagenMenasor;
	public ImageView imagenSuperion;
	
	 ImageView imagenChispa;
	
	VistaMenasor vistaMenasor;
	VistaSuperion vistaSuperion;

	
	public TableroController(Juego juegoencurso) {
		// TODO Auto-generated constructor stub
		juego = juegoencurso;
		listaReferencias = new ArrayList<ImageView>();
		listaReferenciasSuperficies = new ArrayList<ImageView>();
	}
	
	public void inicializar(ImageView[][] suptierra, ImageView[][] supcielo) throws Exception{
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("Tablero.fxml"));
		loader.load();
		
		vistatablerocontroller = loader.getController();
		
		superficiestierra = suptierra;
		superficiescielo = supcielo;
		
		dibujarTierra();
	}	
	
	public void dibujarTierra() {
		// TODO Auto-generated method stub
			for( int fila = 0; fila < 50; fila++){
				for( int columna = 0; columna < 50; columna ++){	
					vistatablerocontroller.getTablero().add(superficiestierra[fila][columna], columna, fila);		
				}
			}
	}

	public void dibujarCielo() {
		// TODO Auto-generated method stub
			for( int fila = 0; fila < 50; fila++){
				for( int columna = 0; columna < 50; columna ++){			
					vistatablerocontroller.getTablero().add(superficiescielo[fila][columna], columna, fila);		
				}
			}
	}
	
	public void borrarTierra(){
			for( int fila = 0; fila < 50; fila++){
				for( int columna = 0; columna < 50; columna ++){			
					vistatablerocontroller.getTablero().getChildren().remove(superficiestierra[fila][columna]);		
				}
			}
	}
	
	public void borrarCielo(){
		
		for( int fila = 0; fila < 50; fila++){
			for( int columna = 0; columna < 50; columna ++){			
				vistatablerocontroller.getTablero().getChildren().remove(superficiescielo[fila][columna]);		
			}
		}
	}
	
	public void cargarAlgoformers(Autobots autobots, Decepticons decepticons) throws Exception{
			cargarAutobots(autobots);
			cargarDecepticons(decepticons);
	}



	private void cargarDecepticons(Decepticons decepticons) throws Exception{
		VistaMegatron vistaMegatron = new VistaMegatron(decepticons.getMegatron(), this);
		vistaMegatron.cargar();
		vistaMegatron.cargarAlterno();
		imagenMegatron = vistaMegatron.getVista();
		
		VistaFrenzy vistaFrenzy = new VistaFrenzy(decepticons.getFrenzy(), this);
		vistaFrenzy.cargar();
		vistaFrenzy.cargarAlterno();
		
		imagenFrenzy = vistaFrenzy.getVista();
		
		VistaBonecrusher vistaBonecrusher = new VistaBonecrusher(decepticons.getBonecrusher(), this);
		vistaBonecrusher.cargar();
		vistaBonecrusher.cargarAlterno();
		
		imagenBonecrusher = vistaBonecrusher.getVista();
		
		 vistaMenasor=new VistaMenasor(null,this);
		 vistaMenasor.cargar();
		 
		 imagenMenasor=vistaMenasor.getVista();
		
		
	}

	public void dibujarNodo(ImageView imagen, int columna, int fila) {
		// TODO Auto-generated method stub
		vistatablerocontroller.getTablero().add(imagen, columna, fila);
	}

	public void setReferenciasObjetivoMovimiento(List<ImageView> nuevalista) {
		// TODO Auto-generated method stub
		listaReferencias.addAll(nuevalista);
	}
	
	

	public Node getVistaTablero() {
		// TODO Auto-generated method stub
		return vistatablerocontroller.getVistaTablero();
	}



	public void cargarAutobots(Autobots autobots) throws Exception{
		// TODO Auto-generated method stub
		VistaBumblebee vistaBumblebee = new VistaBumblebee(autobots.getBumblebee(), this);
		vistaBumblebee.cargar();
		vistaBumblebee.cargarAlterno();
		imagenBumblebee = vistaBumblebee.getVista();

		VistaOptimus vistaOptimus = new VistaOptimus(autobots.getOptimus(), this);
		vistaOptimus.cargar();
		vistaOptimus.cargarAlterno();
		imagenOptimus = vistaOptimus.getVista();
		
		VistaRatchet vistaRatchet = new VistaRatchet(autobots.getRatchet(), this);
		vistaRatchet.cargar();
		vistaRatchet.cargarAlterno();
		imagenRatchet = vistaRatchet.getVista();
		
		vistaSuperion =new VistaSuperion(null,this);
		vistaSuperion.cargar();
		imagenSuperion=vistaSuperion.getVista();

	}


	public void dibujarAlgoformers() {
		// TODO Auto-generated method stub
		
		
		if(juego.getAutobots().getBumblebee().getVida()>0){
			
			vistatablerocontroller.getTablero().add(imagenBumblebee, Bumblebee.getBumblebee().getPosicion().getColumna(),Bumblebee.getBumblebee().getPosicion().getFila());		
		}
		
		if(juego.getAutobots().getRatchet().getVida()>0){
			vistatablerocontroller.getTablero().add(imagenRatchet, Ratchet.getRatchet().getPosicion().getColumna(), Ratchet.getRatchet().getPosicion().getFila());		
		}
		
		if(juego.getAutobots().getOptimus().getVida()>0){
			vistatablerocontroller.getTablero().add(imagenOptimus, Optimus.getOptimus().getPosicion().getColumna(), Optimus.getOptimus().getPosicion().getFila());		
		}
		if(vistaSuperion.getSuperion()!=null){//VistaSuperion tiene algof asociado(alguien creo un superion), cuando lo desarmo lo seteo en null
			if(vistaSuperion.getSuperion().getVida()!=0){
				dibujarSuperion();
				}
			
		}
		
		if(juego.getDecepticons().getBonecrusher().getVida()>0){
			vistatablerocontroller.getTablero().add(imagenBonecrusher, Bonecrusher.getBonecrusher().getPosicion().getColumna(), Bonecrusher.getBonecrusher().getPosicion().getFila());		
		}
		if(juego.getDecepticons().getMegatron().getVida()>0){
			vistatablerocontroller.getTablero().add(imagenMegatron, Megatron.getMegatron().getPosicion().getColumna(), Megatron.getMegatron().getPosicion().getFila());		
		}
		
		
		if(juego.getDecepticons().getFrenzy().getVida()>0){
			vistatablerocontroller.getTablero().add(imagenFrenzy,Frenzy.getFrenzy().getPosicion().getColumna(), Frenzy.getFrenzy().getPosicion().getFila());		
		}
		if(vistaMenasor.getSuperion()!=null){//VistaMenasor tiene algof asociado(alguien creo un Menasor), cuando lo desarmo lo seteo en null
			if(vistaMenasor.getSuperion().getVida()!=0){
				dibujarMenasor();
				}
		}
	}

	public void borrarAlgoformers(){
		vistatablerocontroller.getTablero().getChildren().remove(imagenBumblebee);
		vistatablerocontroller.getTablero().getChildren().remove(imagenMegatron);
		vistatablerocontroller.getTablero().getChildren().remove(imagenOptimus);
		vistatablerocontroller.getTablero().getChildren().remove(imagenBonecrusher);	
		vistatablerocontroller.getTablero().getChildren().remove(imagenRatchet);
		vistatablerocontroller.getTablero().getChildren().remove(imagenFrenzy);
		vistatablerocontroller.getTablero().getChildren().remove(imagenSuperion);
		vistatablerocontroller.getTablero().getChildren().remove(imagenMenasor);
	
		
	}

	public void borrarZonaObjetivoMovimiento() {
		// TODO Auto-generated method stub
		java.util.Iterator<ImageView> iter = listaReferencias.iterator();
		
		while(iter.hasNext()){
			vistatablerocontroller.getTablero().getChildren().remove(iter.next());
		}
		listaReferencias.clear();
	}

	public void redibujarAlgoformers() {
		// TODO Auto-generated method stub
		borrarAlgoformers();
		dibujarAlgoformers();
	}

	public void setReferenciasObjetivoAtaque(List<ImageView> nuevalista) {
		// TODO Auto-generated method stub
		listaReferencias.addAll(nuevalista);
	}

	public void borrarZonaObjetivoAtaque() {
		// TODO Auto-generated method stub
				java.util.Iterator<ImageView> iter = listaReferencias.iterator();
				
				while(iter.hasNext()){
					vistatablerocontroller.getTablero().getChildren().remove(iter.next());
				}
				listaReferencias.clear();		
	}

	public void cargarChispa() throws Exception {
		VistaChispa vistachispa = new VistaChispa();
		vistachispa.cargar();
		imagenChispa = vistachispa.getVista();
	}

	public void dibujarChispa() {
		// TODO Auto-generated method stub
		vistatablerocontroller.getTablero().getChildren().remove(imagenChispa);
		vistatablerocontroller.getTablero().add(imagenChispa, juego.getPosicionChispa().getFila(), juego.getPosicionChispa().getFila());		

	}
	public void setReferenciaSuperalgoformer(Algoformer algof){
		
		if(algof.comparteEquipoCon(Megatron.getMegatron())){
			vistaMenasor.setAlgoformer(algof);
		}else{
			vistaSuperion.setAlgoformer(algof);
		}
	}
	public void dibujarSuperion(){
		vistatablerocontroller.getTablero().getChildren().remove(imagenBumblebee);
		vistatablerocontroller.getTablero().getChildren().remove(imagenRatchet);
		vistatablerocontroller.getTablero().getChildren().remove(imagenOptimus);
		vistatablerocontroller.getTablero().getChildren().remove(imagenSuperion);
		
		
		vistatablerocontroller.getTablero().add(imagenSuperion,vistaSuperion.getSuperion().getPosicion().getColumna(),vistaSuperion.getSuperion().getPosicion().getFila());
	}
	public void dibujarMenasor(){
		vistatablerocontroller.getTablero().getChildren().remove(imagenBonecrusher);
		vistatablerocontroller.getTablero().getChildren().remove(imagenMegatron);
		vistatablerocontroller.getTablero().getChildren().remove(imagenFrenzy);
		vistatablerocontroller.getTablero().getChildren().remove(imagenMenasor);
		
		vistatablerocontroller.getTablero().add(imagenMenasor,vistaMenasor.getSuperion().getPosicion().getColumna(),vistaMenasor.getSuperion().getPosicion().getFila());
	}
}
