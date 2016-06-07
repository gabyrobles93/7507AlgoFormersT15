package Modelo;

public abstract class Movimiento {

	
	private static Tablero Tablero;
	public abstract Movimiento identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas);
	public abstract int getSignoDireccionX();
	public abstract int getSignoDireccionY();
	public boolean caminoLibre(movil unMovil, Tablero unTablero,Posicion posDestino) {
	//PATRON TEMPLATE--- getSignoDireccion() se redefine en movOeste y movEste para modificar la direccion de la iteracion;
		boolean caminoInterrumpido;
		
		for(int i=1;i<=this.getDistancia();i++){
		Posicion posAux=
				new Posicion(unMovil.getPosicion().getFila()+getSignoDireccionX()*i,unMovil.getPosicion().getColumna()+getSignoDireccionY()*i);
			 
	
		caminoInterrumpido=unTablero.getCasillero(posAux).estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		return true;
	}
	
	public static Movimiento crearMovimiento(movil unMovil, Posicion pos2) {
		
	int	distanciaFila=pos2.getFila()-unMovil.getPosicion().getFila();
	int distanciaColumna=pos2.getColumna()-unMovil.getPosicion().getColumna();
		
		Movimiento mov;
		
		if((distanciaFila==0&&distanciaColumna==0)||distanciaFila<0||distanciaColumna<0){
			throw new ErrorNoHayMovimiento();
		}
		
		if(distanciaFila==0){//misma fila, mov horizontal
		
			mov= new MovimientoHorizontal();
			
		}else if(distanciaColumna==0){//misma col, mov vertical
			mov=  new MovimientoVertical();
			
		}else if(distanciaFila==distanciaColumna){// mov diagonal
			
			mov= new MovimientoDiagonal();
		
		}else {
			throw new ErrorCasillerosNoConectadosPorLineaRecta();
		}
		return mov.identificarDireccion(distanciaFila, distanciaColumna);
	}
	public int getDistancia() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void setTablero(Tablero tab) {
		Tablero=tab;
		
	}
	public void Avanzar() {
		// TODO Auto-generated method stub
		
	}
}
