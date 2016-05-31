package Modelo;

public class Algoformer {
	protected int Fila;
	protected int Columna;
	protected int vida;
	protected int ataque;
	protected int velocidad;
	protected int alcance;
	
	
	
	public int getColumna(){
	
		return Columna;
			
	}
	
	public int getFila(){
		return Fila;
	}

	public void setFila(int fila2) {
	Fila=fila2;
		
	}

	public void setColumna(int columna2) {
	Columna=columna2;
	}

	public boolean distanciaPosible(int distanciaColumna) {
		return (distanciaColumna<=velocidad);
		
	}
	
	public int getVida(){
		return vida;
	}

}
