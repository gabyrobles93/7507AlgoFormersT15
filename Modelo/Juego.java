package Modelo;

import java.util.Random;

public class Juego {
	public Equipo autobots;//se cambio la visibilidad por problemas en pruebas.
	public Equipo decepticons;//idem.igual no se si estaria mal.
	private Equipo ganador;
	private boolean estaIniciado=false;
	private boolean estaFinalizado=true;
	private Tablero	tablero;

	private Equipo turnoDelEquipo;

	public void setAutobots(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();
		autobots= new Autobots(optimus,bumblebee,ratchet);
	}
	public void setDecepticons(){
		
		Megatron megatron=new MegatronHumanoide();
		Bonecrusher bonecrusher=new BonecrusherHumanoide();
		Frenzy frenzy=new FrenzyHumanoide();
		decepticons= new Decepticons(megatron,bonecrusher,frenzy);
	}
	public void setTablero(){
		
		tablero= new Tablero();
	}

	public Juego(){
		setTablero();
		setAutobots();
		setDecepticons();
		ubicarDecepticons();
		ubicarAutobots();
		
		
	}
	
	private void ubicarAutobots() {
	
		tablero.ubicarAlgoformer(autobots.getAlgoformer("optimus"), 2, 2);
		tablero.ubicarAlgoformer(autobots.getAlgoformer("ratchet"), 0, 2);
		tablero.ubicarAlgoformer(autobots.getAlgoformer("bumblebee"), 2, 0);
	}
	private void ubicarDecepticons() {

		tablero.ubicarAlgoformer(decepticons.getAlgoformer("megatron"), 47, 47);
		tablero.ubicarAlgoformer(decepticons.getAlgoformer("bonecrusher"), 49,47);
		tablero.ubicarAlgoformer(decepticons.getAlgoformer("frenzy"), 47, 49);
		
	}
	public Equipo getAutobots(){
		
		return autobots;
	}
	
	public Equipo getDecepticons(){
		
		return decepticons;
	}
	

	public void iniciar(){
		
		estaIniciado=true;
		estaFinalizado=false;
	}
	
	public void setGanador(Equipo unEquipo){
		
		ganador=unEquipo;
		finalizar();
	}
	
	public void finalizar(){
		
		estaFinalizado=true;
		estaIniciado=false;
	}
	
	public boolean estaIniciado(){
		
		return estaIniciado;
	}
	
	public boolean estaFinalizado(){
		
		return estaFinalizado;
	}
	
	private void setProximoTurno(Equipo unEquipo){
		
		turnoDelEquipo=unEquipo;
	}
	
	public void setPrimerTurno(Equipo unEquipo){
		
		setProximoTurno(unEquipo);
	}
	
	public void cambiarTurno(){
		if(getEjecutorDeTurnoActual()==autobots){
			setProximoTurno(decepticons);
		}
		else{
			setProximoTurno(autobots);
		}
	}

	public Equipo getEjecutorDeTurnoActual(){
		
		return turnoDelEquipo;
	}
	
	public  void jugarTurno(){
		getEjecutorDeTurnoActual().jugarTurno();
		cambiarTurno();
		
	}
	
	public Equipo getGanador(){
		
		if((autobots.getVidaTotal()==0)||(decepticons.getTieneChispaSuprema())||(autobots.cantidadMiembrosVivos==0)){
			return decepticons;
		}
		if((decepticons.getVidaTotal()==0)||(autobots.getTieneChispaSuprema())||(decepticons.cantidadMiembrosVivos==0)){
			return autobots;
		}
		return null;
	}
	
	public Tablero getTablero() {
		
		return tablero;
	}
	public void moverAlgoformer(Algoformer unAlgoformer,int filaDestino,int columnaDestino){
		
		try{ tablero.moverAlgoformer(unAlgoformer, filaDestino, columnaDestino);
		}catch(RuntimeException e){
			throw e;
		}
	}
	/*Posiblles cosas a Refactorizar:
	 1)estaIniciado no tiene mucho sentido menos teniendo estaFinalizado
	 2)en cambiar turno se necesito un if.
	 3)muchos getters y setters.
	 */
	
	
}
