package Modelo;

public abstract class Algoformer {
	protected int Fila;
	protected int Columna;
	protected int vida;
	protected int ataque;
	protected int velocidad;
	protected int alcance;
	
	public abstract Algoformer cambiarModo();
	
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
	
	public void atacate(int danio){
		
		vida=vida-danio;
		
	}
	
	public void atacar(Algoformer unEnemigo){
		
		unEnemigo.atacate(ataque);
		
	}

	public boolean alcancePosible(int alcance2) {
		
		return (alcance2<=alcance);
	}

}
