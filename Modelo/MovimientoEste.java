package Modelo;

public class MovimientoEste extends MovimientoHorizontal {

	
	public MovimientoEste(movil unMovil,int unaDistancia) {
		super(unMovil);
		distancia=unaDistancia;
	}

	@Override
	public int getSignoDireccionX(){
		return 1;
	}
	@Override
	public void Avanzar() {
		
		Posicion posAux=new Posicion(movil.getPosicion().getFila(),movil.getPosicion().getColumna()+1);
		unTablero.getCasillero(posAux).getSuperficie().afectarAlgoformer((afectable)movil);
		unTablero.ubicarMovil(movil,posAux);	
	}


}
