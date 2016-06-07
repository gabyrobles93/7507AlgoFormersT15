package Modelo;

public class Ataque {

	private Tablero tablero;
	public void hacer(Algoformer victima, int ataque) {
	
		victima.atacate(ataque);
		
	}

	public void validar(Algoformer victima, Algoformer atacante) {
		
		if(fueraDeRango(victima.getPosicion(), atacante.getPosicion())) {
			
			ErrorDistanciaDeAtaqueInsuficiente error = new ErrorDistanciaDeAtaqueInsuficiente(); 
			throw error;
		}
		
		/* SE DEBE VALIDAR DE NO ESTAR ATACANDO A UN MIEMBRO DE TU MISMO EQUIPO::: COMOOO????? */
	}

	private boolean fueraDeRango(Posicion posicion, Posicion posicion2) {
		
		/* LOGICA NECESARIA PARA DETECTAR QUE ESTA FUERA DE RANGO */
		
		return false;
	}

}
