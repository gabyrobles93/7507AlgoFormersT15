package Modelo;

public class CreadorDeMovimiento {
	
	public static Movimiento getMovimiento(int distanciaColumna,int distanciaFila)throws RuntimeException{
		
		if((distanciaFila==0&&distanciaColumna==0)||distanciaFila<0||distanciaColumna<0){
			throw new ErrorNoHayMovimiento();
		}
		
		if(distanciaFila==0){//misma fila, mov horizontal
		
			return new MovimientoHorizontal();
			
		}else if(distanciaColumna==0){//misma col, mov vertical
			
			return  new MovimientoVertical();
			
		}else if(distanciaFila==distanciaColumna){// mov diagonal
			
			return new MovimientoDiagonal();
		
		}else {
			throw new ErrorCasillerosNoConectadosPorLineaRecta();
		}
	}
}
