package Modelo;

import Test.Area;

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

public Tablero(int cantidadCasilleros){
	matriz=new Casillero[cantidadCasilleros][cantidadCasilleros];
	for(int i=0;i<cantidadCasilleros;i++){
		for(int j=0;j<cantidadCasilleros;j++){
	matriz[i][j]=new Casillero();
		}
	}
	CantidadCasilleros=cantidadCasilleros;
}

public void ubicarMovil(movil unMovil,Posicion pos)throws ErrorCasillerOcupado {
	
	Posicion posicionInicial=unMovil.getPosicion();
	
	if(matriz[pos.getFila()][pos.getColumna()].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	if(posicionInicial!=null){
	matriz[posicionInicial.getFila()][posicionInicial.getColumna()].setMovilOcupa(null);
	}
	matriz[pos.getFila()][pos.getColumna()].setMovilOcupa(unMovil);
	unMovil.cambiarPosicion(pos);
	
}

public boolean existeMovil(movil unMovil) {
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	
			if(matriz[i][j].getMovilOcupa()==unMovil) return true;
		}
	}
	return false;
}

public Casillero getCasillero(Posicion pos) {
	return matriz[pos.getFila()][pos.getColumna()];//metodo usado en tests;
}
public void setCasillero(Casillero casillero,Posicion pos){
	matriz[pos.getFila()][pos.getColumna()]=casillero;
}





public Tablero getArea(Posicion posicionCentral,int distancia)throws RuntimeException{
	if(distancia<0){
		throw new ErrorAreaFueraDeRangoPosible();
	}
	int distanciaX=distancia;
	int	distanciaY=distancia;
	if(posicionCentral.getColumna()<distancia){
		distanciaX=posicionCentral.getColumna();
	}
	
	if(posicionCentral.getFila()<distancia){
		distanciaY=posicionCentral.getFila();
	}
	if(posicionCentral.getFila()+distancia>CantidadCasilleros){
		distanciaY=CantidadCasilleros-posicionCentral.getFila();
	}
	
	if(posicionCentral.getColumna()+distancia>CantidadCasilleros){
		distanciaX=CantidadCasilleros -posicionCentral.getColumna();
	}
		
	Tablero subTablero=new Tablero(2*distancia+1);
	
	for(int i=0;i<=2*distanciaY;i++){
		for(int j=0;j<=2*distanciaX;j++){
			Posicion posicionActual=new Posicion(i,j);
		subTablero.setCasillero(this.matriz[posicionCentral.getFila()-distanciaY+i][posicionCentral.getColumna()-distanciaX+j],posicionActual);
		}
	}
	return subTablero;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	return true;
}

public void setAreaDeSuperficie(Area arearocosa) {
	
	int i,j,x,z;
	
	for(x=0, i=arearocosa.getFilaInicial(); i<arearocosa.getFilaFinal();i++,x++){
		
		for(z=0, j=arearocosa.getColumnaInicial(); i<arearocosa.getColumnaFinal();j++,z++){
			
			this.setCasillero(i, j, arearocosa.getMatriz()[x][z]);
		}
	}
	
}

/*De uso exclusivamente interno*/
private void setCasillero(int fila, int columna, Casillero casillero){
	matriz[fila][columna] = casillero;
}

/*Esta SubArea No deberia poder modificar los casilleros del original no?*/
}
