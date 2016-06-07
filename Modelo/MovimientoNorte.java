package Modelo;

public class MovimientoNorte extends MovimientoVertical {


	public MovimientoNorte(movil unMovil, int unaDistancia) {
		super(unMovil);
		distancia=unaDistancia;
	}
	@Override
	public int getSignoDireccionY(){
		return -1;
	}
	@Override
	public void Avanzar() {
		Posicion posAux=new Posicion(movil.getPosicion().getFila()-1,movil.getPosicion().getColumna());
		unTablero.ubicarMovil(movil,posAux);
		
	}
}
