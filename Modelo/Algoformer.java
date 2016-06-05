package Modelo;

public abstract class Algoformer implements movil,atacable,atacante  {
	
	protected int vida;
	protected Posicion miPosicion;
	protected int ataque;
	protected int velocidad;
	protected int alcance;
	
	public abstract Algoformer cambiarModo();
	
	public Posicion getPosicion(){
	
		return miPosicion;
			
	}
	public void mover(Posicion pos){
		miPosicion=pos;
	}
	




	public boolean distanciaPosible(int distancia) {
		
		return (distancia<=velocidad);
		
	}
	
	public int getVida(){
		
		return vida;
	}
	
	public void atacate(int danio){
		if(vida<=danio)vida=0;
		vida=vida-danio;
		
	}
	
	public  void atacar(atacable unEnemigo){
		unEnemigo.atacate(ataque);
	}

	public boolean alcancePosible(int alcance2) {
		
		return (alcance2<=alcance);
	}
	public int getDistanciaDeAtaque(movil unMovil){
		
		
		
		int distanciaColumna=Math.abs(this.getPosicion().getColumna()-unMovil.getPosicion().getColumna());
		
		int distanciaFila= Math.abs(this.getPosicion().getFila()-unMovil.getPosicion().getFila());
		
		return (distanciaFila>=distanciaColumna)?distanciaFila:distanciaColumna;//alcance es la mayor de las distancias
		
	}

}
