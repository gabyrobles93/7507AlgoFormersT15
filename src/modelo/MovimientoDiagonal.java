package modelo;

public class MovimientoDiagonal extends Movimiento {

	public MovimientoDiagonal(movil unMovil){
		movil=unMovil;
	}	
	
	
public MovimientoDiagonal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
	
	distancia= Math.abs(diferenciaEntreFilas);//da lo mismo cualq, son iguales.
										
	
		if(diferenciaEntreColumnas<0&&diferenciaEntreFilas<0 )return new MovimientoNorOeste(movil,distancia);
		else if(diferenciaEntreColumnas>0&&diferenciaEntreFilas>0 )return new MovimientoSurEste(movil,distancia);
		else if(diferenciaEntreColumnas>0&&diferenciaEntreFilas<0 )return new MovimientoNorEste(movil,distancia);
		return new MovimientoSurOeste(movil,distancia);
		

	}

@Override
public int getSignoDireccionX() {
	// TODO Auto-generated method stub----->sobrecargados en las hijas
	return 0;
}

@Override
public int getSignoDireccionY() {
	// TODO Auto-generated method stub---->sobrecargados en las hijas
	return 0;
}


@Override
public void Avanzar() {
	// TODO Auto-generated method stub
	
}

}
