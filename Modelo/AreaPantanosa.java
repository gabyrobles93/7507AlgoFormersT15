package Modelo;

import Modelo.Superficie;
import Modelo.SuperficiePantanosa;

public class AreaPantanosa extends Area {

	public AreaPantanosa(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficiepantanosa = new SuperficiePantanosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficiepantanosa);
			}
		}
	}
	
	
	public AreaPantanosa(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficiepantanosa = new SuperficiePantanosa();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficiepantanosa);
			}
		}
	}
}
