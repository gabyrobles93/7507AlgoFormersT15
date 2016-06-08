package Modelo;

import Modelo.Area;
import Modelo.Casillero;
import Modelo.Superficie;
import Modelo.SuperficieEspinosa;

public class AreaEspinosa extends Area {

	public AreaEspinosa(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficieespinosa = new SuperficieEspinosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficieespinosa);
			}
		}
	}
	
	
	public AreaEspinosa(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficieespinosa = new SuperficieEspinosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficieespinosa);
			}
		}
	}
	
}
