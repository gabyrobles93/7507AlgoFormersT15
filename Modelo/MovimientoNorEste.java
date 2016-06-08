package Modelo;


public class MovimientoNorEste extends MovimientoDiagonal {

	public MovimientoNorEste(movil unMovil,int unaDistancia) {
		super(unMovil);
		distancia=unaDistancia;
	}
	@Override
	public int getSignoDireccionX(){
		return 1;
	}
	@Override
	public int getSignoDireccionY(){
		return -1;
	}
	@Override
	public void Avanzar() {
		Posicion posAux=new Posicion(movil.getPosicion().getFila()-1,movil.getPosicion().getColumna()+1);
		unTablero.getCasillero(posAux).getSuperficie().afectarAlgoformer((afectable)movil);
		if(((afectable)movil).getEfecto().afectavelocidad == 999){
			ErrorAlgoformerHumanoideNoPuedePasarPorPantano err = new ErrorAlgoformerHumanoideNoPuedePasarPorPantano();
			throw err;
		}
		unTablero.ubicarMovil(movil,posAux);
		
	}
}
