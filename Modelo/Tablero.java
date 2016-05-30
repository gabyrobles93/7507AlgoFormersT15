package Modelo;

public  class Tablero{
protected  Casillero matriz[][];
private int CantidadCasilleros=50;

public Tablero(){
	matriz=new Casillero[CantidadCasilleros][CantidadCasilleros];
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	matriz[i][j]=new Casillero();
		}
	}
}

public void ubicarAlgoformer(AlgoFormer unAlgoformer,int fila, int columna)throws ErrorCasillerOcupado {
	if(matriz[fila][columna].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	matriz[fila][columna].setAlgoformerOcupa(unAlgoformer);
	unAlgoformer.setPosicion(matriz[fila][columna]);
}

public boolean existeAlgoFormer(AlgoFormer unAlgoformer) {
	boolean encontrado=false;
for(int i=0;i<CantidadCasilleros;i++){
	for(int j=0;j<CantidadCasilleros;j++){
	
	if(matriz[i][j].getAlgoformerOcupa()==unAlgoformer) return true;
	}
}
return false;
}

public Casillero getCasillero(int fila, int columna) {
	return matriz[fila][columna];//metodo usado en tests;
}
}
