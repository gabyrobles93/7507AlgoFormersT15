package Modelo;

public class MovimientoHorizontal extends Movimiento {

	
	protected int getSignoFila(){return 0;}//nunca lo llamo}
	@Override
	public MovimientoHorizontal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		if(diferenciaEntreColumnas<0 )return new MovimientoOeste();
		else return new MovimientoEste();

	}

	@Override
	public boolean caminoLibre(movil unMovil, Tablero unTablero, int distanciaFila, int distanciaColumna) {
		
		boolean caminoInterrumpido;
		
		for(int i=1;i<=Math.abs(distanciaColumna);i++){
			 caminoInterrumpido=unTablero.getCasillero(unMovil.getFila(),unMovil.getColumna()+getSignoFila()*i).estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		return true;
	}

}
