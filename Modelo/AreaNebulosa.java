package Modelo;

public class AreaNebulosa extends Area {
public AreaNebulosa(){
		
		super();
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficienubosa = new SuperficieNebulosaDeAndromeda();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficienubosa);
			}
		}
	}
	
	
	public AreaNebulosa(int filainicialarea, int filafinalarea, int columnainicialarea, int columnafinalarea){
		
		super(filainicialarea, filafinalarea, columnainicialarea, columnafinalarea);
		int i,j;
		
		for(i = 0;i<cantidadfilas;i++){
			for(j=0;j<cantidadcolumnas;j++){
				Superficie superficienubosa = new SuperficieNebulosaDeAndromeda();
				matriz[i][j] = new Casillero();
				matriz[i][j].setSuperficie(superficienubosa);
			}
		}
	}
	
}
