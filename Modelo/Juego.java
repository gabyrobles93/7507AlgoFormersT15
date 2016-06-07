package Modelo;

import java.util.Random;

public class Juego {
	public Autobots autobots;//se cambio la visibilidad por problemas en pruebas.
	public Decepticons decepticons;//idem.igual no se si estaria mal.
	private Equipo ganador;
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
	
	Movimiento.setTablero(tablero);
	}

	public Juego(){
		setTablero();
		setAutobots();
		setDecepticons();
		ubicarDecepticons();
		ubicarAutobots();
		
		
	}
	
	private void ubicarAutobots() {
	
		Posicion posOptimus=new Posicion(2,2);
		Posicion posRatchet=new Posicion(0,2);
		Posicion posBumblebee=new Posicion(2,0);
		
		tablero.ubicarMovil(((Autobots) autobots).getOptimus(), posOptimus);
		tablero.ubicarMovil(((Autobots) autobots).getRatchet(), posRatchet);
		tablero.ubicarMovil(((Autobots) autobots).getBumblebee(), posBumblebee);
	}
	private void ubicarDecepticons() {
		
		Posicion posMegatron=new Posicion(47,47);
		Posicion posBonecrusher=new Posicion(49,47);
		Posicion posFrenzy=new Posicion(47,49);

		tablero.ubicarMovil(((Decepticons) decepticons).getMegatron(), posMegatron);
		tablero.ubicarMovil(((Decepticons) decepticons).getBonecrusher(), posBonecrusher);
		tablero.ubicarMovil(((Decepticons) decepticons).getFrenzy(), posFrenzy);
		
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

	public void moverAlgoformer(Algoformer unAlgoformer,Posicion posicionDestino){
		
		try{ tablero.moverMovil(unAlgoformer, posicionDestino);
		}catch(RuntimeException e){
			throw e;
		}
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
