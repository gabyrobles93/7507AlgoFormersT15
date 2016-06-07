package Modelo;

import java.util.Arrays;

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
	boolean encontrado=false;
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
	if(distancia<0||posicionCentral.getColumna()<distancia||posicionCentral.getFila()<distancia||
			posicionCentral.getFila()+distancia>CantidadCasilleros
			||posicionCentral.getColumna()+distancia>CantidadCasilleros){
		throw new ErrorAreaFueraDeRangoPosible();
	}
		
	Tablero subTablero=new Tablero(2*distancia+1);
	
	for(int i=0;i<=2*distancia;i++){
		for(int j=0;j<=2*distancia;j++){
			Posicion posicionActual=new Posicion(i,j);
		subTablero.setCasillero(this.matriz[posicionCentral.getFila()-distancia+i][posicionCentral.getColumna()-distancia+j],posicionActual);
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


/*Esta SubArea No deberia poder modificar los casilleros del original no?*/
}
