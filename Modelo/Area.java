package Modelo;

import Modelo.Casillero;

public abstract class Area{

	protected  Casillero matriz[][];
	protected int filainicial;
	protected int filafinal;
	protected int columnainicial;
	protected int columnafinal;
	
	protected int cantidadfilas;
	protected int cantidadcolumnas;
	
	public Area(){
		
		matriz = null;
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
		
		cantidadfilas = filafinalarea - filainicialarea + 1;
		cantidadcolumnas = columnafinalarea - columnainicialarea + 1;
		
		matriz = new Casillero[cantidadfilas][cantidadcolumnas];

	}
	
	public int getFilaInicial(){
		return filainicial;
	}
	
	public int getFilaFinal(){
		return filafinal;
	}
	
	public int getColumnaInicial(){
		return columnainicial;
	}
	
	public int getColumnaFinal(){
		return columnafinal;
	}
	
	public Casillero[][] getMatriz(){
		return matriz;
	}

	public Casillero getCasillero(int i, int j) {
		return matriz[i][j];
	}
	
	public int getCantidadFilas() {
		return cantidadfilas;
	}
	
	public int getCantidadColumnas() {
		return cantidadcolumnas;
	}
}
