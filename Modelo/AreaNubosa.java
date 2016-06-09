package Modelo;

public class AreaNubosa extends Area {

public AreaNubosa(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficienubosa = new SuperficieNubosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficienubosa);
			}
		}
	}
	
	
	public AreaNubosa(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficienubosa = new SuperficieNubosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficienubosa);
			}
		}
	}
	
	
}
