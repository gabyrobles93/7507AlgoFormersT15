package Modelo;

public class MovimientoHorizontal extends Movimiento {

	
	public int getSignoDireccionX(){return 0;}//nunca lo llamo}
	public int getSignoDireccionY(){return 0;}
	@Override
	public MovimientoHorizontal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		if(diferenciaEntreColumnas<0 )return new MovimientoOeste();
		else return new MovimientoEste();

	}

	


}
