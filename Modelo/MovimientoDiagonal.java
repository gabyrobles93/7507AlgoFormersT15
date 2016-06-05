package Modelo;

public class MovimientoDiagonal extends Movimiento {

protected MovimientoDiagonal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		if(diferenciaEntreColumnas<0&&diferenciaEntreFilas<0 )return new MovimientoNorOeste();
		else if(diferenciaEntreColumnas>0&&diferenciaEntreFilas>0 )return new MovimientoSurEste();
		else if(diferenciaEntreColumnas<0&&diferenciaEntreFilas>0 )return new MovimientoNorEste();
		else if(diferenciaEntreColumnas>0&&diferenciaEntreFilas<0 )return new MovimientoSurOeste();
		return null;//nunca llega hasta aca

	}

}
