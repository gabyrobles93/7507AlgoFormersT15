package Modelo;

public class MovimientoNorOeste extends MovimientoDiagonal {

	public MovimientoNorOeste(movil unMovil,int unaDistancia) {
		super(unMovil);
		distancia=unaDistancia;
	}
	@Override
	public int getSignoDireccionX(){
		return -1;
	}
	@Override
	public int getSignoDireccionY(){
		return -1;
	}
	@Override
	public void Avanzar() {
		Posicion posAux=new Posicion(movil.getPosicion().getFila()-1,movil.getPosicion().getColumna()-1);
		unTablero.ubicarMovil(movil,posAux);
		
	}
}
