package Modelo;

public class AlgoFormer {
	protected Casillero posicion;
	protected int vida;
	protected int ataque;
	protected int velocidad;
	protected int alcance;
	
	
	public void setPosicion(Casillero unaPosicion){
	
		posicion=unaPosicion;
			
	}
	
	public Casillero getPosicion(){
		return posicion;
	}


}
