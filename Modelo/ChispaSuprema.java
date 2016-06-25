package Modelo;

public class ChispaSuprema implements movil{
	
	private Posicion posicion=new Posicion(25,25);
	
	public void ubicarEnCentro(Tablero tab){
		try{
		tab.ubicarMovil(this, posicion);
		}catch(RuntimeException e){
			throw new ErrorChispaYaUbicada();
		}
	}

	@Override
	public void mover(Posicion posicionDestino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean distanciaPosible(int abs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return posicion;
	}

	@Override
	public void cambiarPosicion(Posicion pos) {
		// TODO Auto-generated method stub
		
	}
}
