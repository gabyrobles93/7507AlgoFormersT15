package Modelo;

import java.util.Random;

public class Juego {
	public Autobots autobots;//se cambio la visibilidad por problemas en pruebas.
	public Decepticons decepticons;//idem.igual no se si estaria mal.
	private Equipo ganador;
	private Tablero	tablero;
	
	private Equipo turnoDelEquipo;

	public void setAutobots(){
		
		autobots= new Autobots(Optimus.getOptimus(),Bumblebee.getBumblebee(),Ratchet.getRatchet());
	}
	public void setDecepticons(){
		
	
		decepticons= new Decepticons(Megatron.getMegatron(),Bonecrusher.getBonecrusher(),Frenzy.getFrenzy());
	}
	public void setTablero(){
		
	tablero= new Tablero();
	
	Movimiento.setTablero(tablero);
	}

	public Juego(){
		setTablero();
		setAutobots();
		setDecepticons();
		ubicarDecepticons();
		ubicarAutobots();
		turnoDelEquipo=this.getDecepticons();
		
	}
	
	private void ubicarAutobots() {
	
		Posicion posOptimus=new Posicion(2,2);
		Posicion posRatchet=new Posicion(0,2);
		Posicion posBumblebee=new Posicion(2,0);
		
		autobots.ubicarMoviles(tablero,posOptimus,posBumblebee,posRatchet);
	}
	private void ubicarDecepticons() {
		
		Posicion posMegatron=new Posicion(47,47);
		Posicion posBonecrusher=new Posicion(49,47);
		Posicion posFrenzy=new Posicion(47,49);
		
		decepticons.ubicarMoviles(tablero, posMegatron, posBonecrusher, posFrenzy);
	}
	public Autobots getAutobots(){
		
		return autobots;
	}
	
	public Decepticons getDecepticons(){
		
		return decepticons;
	}
	

	
	public void setGanador(Equipo unEquipo){
		
		ganador=unEquipo;
	
	}
	


	

	
	private void setProximoTurno(Equipo unEquipo){
		
		turnoDelEquipo=unEquipo;
	}
	
	public void setPrimerTurno(Equipo unEquipo){
		
		setProximoTurno(unEquipo);
	}
	
	public void cambiarTurno(){
		if(turnoDelEquipo==autobots){
			setProximoTurno(decepticons);
		}
		else{
			setProximoTurno(autobots);
		}
	}
//Getter exclusiamente usado para test
	public Equipo getEjecutorDeTurnoActual(){
		
		return turnoDelEquipo;
	}

	public  void jugarTurno(){
		turnoDelEquipo.jugarTurno();//CAMBIAR POR EL ATRIBUTOS
		cambiarTurno();
		
	}
/*	
	public Equipo getGanador(){
		
		if((autobots.getVidaTotal()==0)||(decepticons.getTieneChispaSuprema())||(autobots.cantidadMiembrosVivos==0)){
			return decepticons;
		}
		if((decepticons.getVidaTotal()==0)||(autobots.getTieneChispaSuprema())||(decepticons.cantidadMiembrosVivos==0)){
			return autobots;
		}
		return null;
	}
	*/
	public Tablero getTablero() {
		
		return tablero;
	}


	
	/*public void atacar(Algoformer atacante,Algoformer enemigo)throws RuntimeException{
		
		//Deben ser de diferentes equipos
		if(!(decepticons.existeAlgoformer(atacante)^decepticons.existeAlgoformer(enemigo))){
			//OPERACION XOR, SI AMBOS DAN VERDADERO O AMBOS FALSOS->a^b =0
			throw new ErrorNoSePuedeAtacarIntegranteDeEquipo();
		}
		//Debe estar dentro del rango de ataque
		if(tablero.ataquePosible(atacante,enemigo)==false){
			throw  new ErrorDistanciaDeAtaqueInsuficiente();
		}
		//Atacar
		atacante.atacar(enemigo);
	}
	
	

	/*Posiblles cosas a Refactorizar:
	 1)estaIniciado no tiene mucho sentido menos teniendo estaFinalizado
	 2)en cambiar turno se necesito un if.
	 3)muchos getters y setters.
	 */
	
	
}
