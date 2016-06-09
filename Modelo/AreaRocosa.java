package Modelo;

import Modelo.Superficie;
import Modelo.SuperficieRocosa;

public class AreaRocosa extends Area{

	public AreaRocosa(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficierocosa = new SuperficieRocosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficierocosa);
			}
		}
	}
	
	
	public AreaRocosa(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficierocosa = new SuperficieRocosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficierocosa);
			}
		}
	}
	
}
