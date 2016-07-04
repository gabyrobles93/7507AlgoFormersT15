package modelo;

public class MovimientoHorizontal extends Movimiento {

	public MovimientoHorizontal(movil unMovil){
		movil=unMovil;
	}
	
	
	public int getSignoDireccionX(){return 0;}//}-->Solo se llaman en caso de que no esten sobre cargados.
	public int getSignoDireccionY(){return 0;}//}-->
	@Override
	public MovimientoHorizontal identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas) {
		
		distancia=Math.abs(diferenciaEntreColumnas);
		
		if(diferenciaEntreColumnas<0 )return new MovimientoOeste(movil,distancia);
		else return new MovimientoEste(movil,distancia);

	}


	@Override
	public void Avanzar() {
		// TODO Auto-generated method stub
		
	}

	


}
