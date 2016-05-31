package Modelo;

public class Juego {
	public Equipo autobots;//se cambio la visibilidad por problemas en pruebas.
	public Equipo decepticons;//idem.igual no se si estaria mal.
	private Equipo ganador;
	private boolean estaIniciado=false;
	private boolean estaFinalizado=true;
	private TableroCielo tableroCielo;
	private TableroTierra tableroTierra;
	private Equipo turnoDelEquipo;

	public void setAutobots(){
		MegatronAlterno mega1=new MegatronAlterno();
		MegatronAlterno mega2=new MegatronAlterno();
		MegatronAlterno mega3=new MegatronAlterno();
		autobots= new Equipo(mega1,mega2,mega3);
	}
	public void setDesepticons(){
		
		MegatronAlterno mega1=new MegatronAlterno();
		MegatronAlterno mega2=new MegatronAlterno();
		MegatronAlterno mega3=new MegatronAlterno();
		decepticons= new Equipo(mega1,mega2,mega3);
	}
	public void setTableroCielo(){
		
		tableroCielo= new TableroCielo();
	}
	public void setTableroTierra(){
		
		tableroTierra= new TableroTierra();
	}
	
	public Juego(){

		setAutobots();
		setDesepticons();
		setTableroCielo();
		setTableroTierra();
	}
	
	public Equipo getAutobots(){
		
		return autobots;
	}
	
	public Equipo getDecepticons(){
		
		return decepticons;
	}
	
	public TableroTierra getTableroTierra(){
		
		return tableroTierra;
	}
	
	public TableroCielo getTableroCielo(){
		
		return tableroCielo;
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
		
		return ganador;
	}
	
	/*Posiblles cosas a Refactorizar:
	 1)estaIniciado no tiene mucho sentido menos teniendo estaFinalizado
	 2)en cambiar turno se necesito un if.
	 3)muchos getters y setters.
	 */
	
	
}
