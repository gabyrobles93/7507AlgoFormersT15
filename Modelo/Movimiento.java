package Modelo;

public abstract class Movimiento {

	protected movil movil;
	protected int distancia;
	private static Tablero unTablero;
	public abstract Movimiento identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas);
	public abstract int getSignoDireccionX();
	public abstract int getSignoDireccionY();
	public boolean caminoLibre(movil unMovil, Posicion posDestino) {
	//PATRON TEMPLATE--- getSignoDireccion() se redefine en cada mov para modificar la direccion de la iteracion;
		boolean caminoInterrumpido;
		
		for(int i=1;i<=this.getDistancia();i++){
		Posicion posAux=
				new Posicion(unMovil.getPosicion().getFila()+getSignoDireccionY()*i,unMovil.getPosicion().getColumna()+getSignoDireccionX()*i);
			 
	
		caminoInterrumpido=unTablero.getCasillero(posAux).estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		return true;
	}
	
	public static Movimiento crearMovimiento(movil unMovil, Posicion pos2) {
		
	int	distanciaFila=pos2.getFila()-unMovil.getPosicion().getFila();
	int distanciaColumna=pos2.getColumna()-unMovil.getPosicion().getColumna();
		
		Movimiento mov;
		
		if((distanciaFila==0&&distanciaColumna==0)){
			throw new ErrorNoHayMovimiento();
		}
		
		if(distanciaFila==0){//misma fila, mov horizontal
		
			mov= new MovimientoHorizontal(unMovil);
			
		}else if(distanciaColumna==0){//misma col, mov vertical
			mov=  new MovimientoVertical(unMovil);
			
		}else if(Math.abs(distanciaFila)==Math.abs(distanciaColumna)){// mov diagonal
			
			mov= new MovimientoDiagonal(unMovil);
		
		}else {
			throw new ErrorCasillerosNoConectadosPorLineaRecta();
		}
		
		mov= mov.identificarDireccion(distanciaFila, distanciaColumna);
		mov.validarDistancia();
		if(!mov.caminoLibre(unMovil, pos2)){
			throw new ErrorCasillerOcupado();
		}
		return mov;
	}
	private void validarDistancia() {
		if(movil.distanciaPosible(distancia)==false){
			throw new ErrorVelocidadDelMovilInsuficiente();
		}
		
	}
	public int getDistancia() {
	
		return distancia;
	}
	public static void setTablero(Tablero tab) {
		unTablero=tab;
		
	}
	public abstract void Avanzar();
}
