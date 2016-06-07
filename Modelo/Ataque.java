package Modelo;

public class Ataque {

	private Tablero tablero;
	public void hacer(Algoformer victima, int ataque) {
	
		victima.atacate(ataque);
		
	}

	public void validar(Algoformer victima, Algoformer atacante) {
		
		if(fueraDeRango(victima, atacante)) {
			
			ErrorDistanciaDeAtaqueInsuficiente error = new ErrorDistanciaDeAtaqueInsuficiente(); 
			throw error;
		}
		
		/* SE DEBE VALIDAR DE NO ESTAR ATACANDO A UN MIEMBRO DE TU MISMO EQUIPO::: COMOOO????? */
	}

	private boolean fueraDeRango(Algoformer victima, Algoformer atacante) {
		
	Tablero subTab=tablero.getArea(atacante.getPosicion(), atacante.getDistanciaDeAtaque());
	return !subTab.existeMovil(victima);
	}

}
