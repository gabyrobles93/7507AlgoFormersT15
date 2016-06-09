package Modelo;

public class AreaTormentaPsionica extends Area {
public AreaTormentaPsionica(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficie = new SuperficieTormentaPsionica();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficie);
			}
		}
	}
	
	
	public AreaTormentaPsionica(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficie= new SuperficieTormentaPsionica();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficie);
			}
		}
	}
	

}
