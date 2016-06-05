package Modelo;

public class MovimientoVertical extends Movimiento {

	@Override
protected MovimientoVertical identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		if(diferenciaEntreFilas<0 )return new MovimientoNorte();
		else return new MovimientoSur();

	}

	@Override
	public boolean caminoLibre(movil unMovil, Tablero unTablero, int distanciaFila, int distanciaColumna) {
		
		boolean caminoInterrumpido;
		
		for(int i=1;i<=Math.abs(distanciaColumna);i++){
			 caminoInterrumpido=unTablero.getCasillero(unMovil.getFila(),unMovil.getColumna()-i).estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		return true;
	}
}
