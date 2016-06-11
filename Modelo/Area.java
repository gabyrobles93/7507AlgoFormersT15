package Modelo;

import Modelo.Casillero;

public abstract class Area{

	protected int filainicial;
	protected int filafinal;
	protected int columnainicial;
	protected int columnafinal;
	

	public Area(){
		
		filainicial = 0;
		filafinal = 0;
		columnainicial = 0;
		columnafinal = 0;
	}
	
	public Area(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
	
		filainicial = filainicialarea;
		filafinal = filafinalarea;
		columnainicial = columnainicialarea;
		columnafinal = columnafinalarea;
		
	

	}

	private void setArea(Tablero tablero, Superficie superficie){
		
		int i,j;
		
		for(i=filainicial; i<=filafinal; i++){
			
			for(j=columnainicial; j<=columnafinal; j++){
				
				Posicion pos = new Posicion(i,j);
				tablero.setSuperficieEnCasillero(pos, superficie);
				
			}
		}
		
		
	}
	
	public void setAreaRocosa(Tablero tablero){
	
		Superficie superficie = new SuperficieRocosa();
		setArea(tablero, superficie);
	}
	
	public void setAreaPantanosa(Tablero tablero){
		
		Superficie superficie = new SuperficiePantanosa();
		setArea(tablero, superficie);
	}
	
	public void setAreaEspinosa(Tablero tablero){
		
		Superficie superficie = new SuperficieEspinosa();
		setArea(tablero, superficie);
	}
	
	public void setAreaNubosa(Tablero tablero){
		
		Superficie superficie = new SuperficieNubosa();
		setArea(tablero, superficie);
	}
	
	public void setAreaNebulosaDeAndromeda(Tablero tablero){
		
		Superficie superficie = new SuperficieNebulosaDeAndromeda();
		setArea(tablero, superficie);
	}
	
	public void setAreaTormentaPsionica(Tablero tablero){
		
		Superficie superficie = new SuperficieTormentaPsionica();
		setArea(tablero, superficie);
	}
	
}
