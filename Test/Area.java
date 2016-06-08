package Test;

import Modelo.Casillero;
import Modelo.Tablero;

public abstract class Area extends Tablero{

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
		
		cantidadfilas = filafinalarea - filainicialarea;
		cantidadcolumnas = columnafinalarea - columnainicialarea;
		
		matriz = new Casillero[cantidadfilas][cantidadcolumnas];

	}
	
	public int getFilaInicial(){
		return filainicial;
	}
	
	public int getFilaFinal(){
		return filainicial;
	}
	
	public int getColumnaInicial(){
		return filainicial;
	}
	
	public int getColumnaFinal(){
		return filainicial;
	}
	
	public Casillero[][] getMatriz(){
		return matriz;
	}
}
