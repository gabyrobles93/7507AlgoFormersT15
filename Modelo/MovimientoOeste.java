package Modelo;

public class MovimientoOeste extends MovimientoHorizontal {

	public MovimientoOeste(movil unMovil,int unaDistancia) {
		super(unMovil);
		distancia=unaDistancia;
	}

	@Override
	public int getSignoDireccionX(){
		return 1;
	}
	@Override
	public void Avanzar() {
		Posicion posAux=new Posicion(movil.getPosicion().getFila(),movil.getPosicion().getColumna()-1);
		movil.cambiarPosicion(posAux);
		
	}
}
