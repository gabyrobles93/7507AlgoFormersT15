package Modelo;

public class MovimientoHorizontal extends Movimiento {

	
	protected int getSignoColumna(){return 0;}//nunca lo llamo}
	@Override
	public MovimientoHorizontal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		if(diferenciaEntreColumnas<0 )return new MovimientoOeste();
		else return new MovimientoEste();

	}

	@Override
	public boolean caminoLibre(movil unMovil, Tablero unTablero,Posicion posDestino) {
		//TEMPLATE--- getSignoColumna() se redefine en movOeste y Este para modificar la direccion de la iteracion;
		boolean caminoInterrumpido;
		
		for(int i=1;i<=this.getDistancia();i++){
			Posicion posAux=new Posicion(unMovil.getPosicion().getFila(),unMovil.getPosicion().getColumna()+getSignoColumna()*i);
			 caminoInterrumpido=unTablero.getCasillero(posAux).estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		return true;
	}

}
