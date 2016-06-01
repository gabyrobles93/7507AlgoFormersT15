package Modelo;

public abstract class Algoformer implements movil,atacable,atacante  {
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
	public void mover(int nuevaFila,int nuevaColumna){
		Fila=nuevaFila;
		Columna=nuevaColumna;
	}
	
	public int getFila(){
		
		return Fila;
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
	
	public  void atacar(atacable unEnemigo){
		unEnemigo.atacate(ataque);
	}

	public boolean alcancePosible(int alcance2) {
		
		return (alcance2<=alcance);
	}
	public int getDistanciaDeAtaque(movil unMovil){
		
		int distanciaColumna=Math.abs(this.getColumna()-unMovil.getColumna());
		
		int distanciaFila= Math.abs(this.getFila()-unMovil.getFila());
		
		return (distanciaFila>=distanciaColumna)?distanciaFila:distanciaColumna;//alcance es la mayor de las distancias
		
	}

}
