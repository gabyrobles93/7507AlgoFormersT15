package Modelo;

public interface movil {
	
	public void mover(Posicion posicionDestino);
	public boolean distanciaPosible(int abs);
	public Posicion getPosicion();
	public void cambiarPosicion(Posicion pos);//metodo que usa Movimiento

}
