package Modelo;


public class Area{

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

	private void setAreaTierra(Tablero tablero, Superficie superficie){
		
		int i,j;
		
		for(i=filainicial; i<=filafinal; i++){
			
			for(j=columnainicial; j<=columnafinal; j++){
				
				Posicion pos = new Posicion(i,j);
				tablero.setSuperficieTierraEnCasillero(pos, superficie);
				
			}
		}
		
		
	}
	
	private void setAreaCielo(Tablero tablero, Superficie superficie){
		
		int i,j;
		
		for(i=filainicial; i<=filafinal; i++){
			
			for(j=columnainicial; j<=columnafinal; j++){
				
				Posicion pos = new Posicion(i,j);
				tablero.setSuperficieCieloEnCasillero(pos, superficie);
				
			}
		}
		
		
	}
	
	public void setAreaRocosa(Tablero tablero){
	
		Superficie superficie = new SuperficieRocosa();
		setAreaTierra(tablero, superficie);
	}
	
	public void setAreaPantanosa(Tablero tablero){
		
		Superficie superficie = new SuperficiePantanosa();
		setAreaTierra(tablero, superficie);
	}
	
	public void setAreaEspinosa(Tablero tablero){
		
		Superficie superficie = new SuperficieEspinosa();
		setAreaTierra(tablero, superficie);
	}
	
	public void setAreaNubosa(Tablero tablero){
		
		Superficie superficie = new SuperficieNubosa();
		setAreaCielo(tablero, superficie);
	}
	
	public void setAreaNebulosaDeAndromeda(Tablero tablero){
		
		Superficie superficie = new SuperficieNebulosaDeAndromeda();
		setAreaCielo(tablero, superficie);
	}
	
	public void setAreaTormentaPsionica(Tablero tablero){
		
		Superficie superficie = new SuperficieTormentaPsionica();
		setAreaCielo(tablero, superficie);
	}
	
}
