package Modelo;



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
	public void setDesepticons(){
		
		Megatron megatron=new MegatronHumanoide();
		Bonecrusher bonecrusher=new BonecrusherHumanoide();
		Frenzy frenzy=new FrenzyHumanoide();
		decepticons= new Decepticons(megatron,bonecrusher,frenzy);
	}
	public void setTablero(){
		
		tablero= new Tablero();
	}

	public Juego(){

		setAutobots();
		setDesepticons();
		setTablero();
		
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
	
	/*Posiblles cosas a Refactorizar:
	 1)estaIniciado no tiene mucho sentido menos teniendo estaFinalizado
	 2)en cambiar turno se necesito un if.
	 3)muchos getters y setters.
	 */
	
	
}
