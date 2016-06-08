package Test;

import Modelo.Casillero;

public abstract class Area {

	protected  Casillero matriz[][];
	private int cantidadcasilleros;
	
	public Area(){
		matriz = null;
		cantidadcasilleros = 0;
	}
}
