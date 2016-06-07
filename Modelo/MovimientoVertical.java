package Modelo;

public class MovimientoVertical extends Movimiento {
	
	
	
	public MovimientoVertical(movil unMovil){
		movil=unMovil;
	}

	@Override
	public MovimientoVertical identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		distancia=Math.abs(diferenciaEntreFilas);
		
		if(diferenciaEntreFilas<0 )return new MovimientoNorte(movil,distancia);
		else return new MovimientoSur(movil,distancia);

	}



	@Override
	public int getSignoDireccionX() {
		
		return 0;
	}

	@Override
	public int getSignoDireccionY() {
		
		return 0;
	}

	@Override
	public void Avanzar() {
		// TODO Auto-generated method stub
		
	}
}
