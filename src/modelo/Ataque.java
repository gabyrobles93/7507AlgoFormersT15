package modelo;

public class Ataque {

	private static Tablero tablero;
	
	static public void setTablero(Tablero unTablero){
		tablero=unTablero;
	}
	
	public void hacer(Algoformer victima, int ataque) {
	
		victima.atacate(ataque);
		
	}

	public void validar(Algoformer victima, Algoformer atacante) {
		
		if(victima==null){
			throw new ErrorAlgoformerInexistente();
		}
		
		if(fueraDeRango(victima, atacante)) {
			
			ErrorDistanciaDeAtaqueInsuficiente error = new ErrorDistanciaDeAtaqueInsuficiente(); 
			throw error;
		}
		
		if(atacaCompaniero(victima, atacante))  {
			ErrorNoSePuedeAtacarIntegranteDeEquipo error = new ErrorNoSePuedeAtacarIntegranteDeEquipo();
			throw error;
		}
	}

	private boolean atacaCompaniero(Algoformer victima, Algoformer atacante) {
		
		return atacante.comparteEquipoCon(victima);
	}

	private boolean fueraDeRango(Algoformer victima, Algoformer atacante) {
	
		Tablero subTab=tablero.getArea(atacante.getPosicion(), atacante.getDistanciaDeAtaque());
		return !subTab.existeMovil(victima);
	}

}
