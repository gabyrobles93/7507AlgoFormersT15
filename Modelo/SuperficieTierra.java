package Modelo;

public abstract class SuperficieTierra extends Superficie{

	int factorvelocidad; 		// pantano
	int factorataque;			// tormenta psionica
	int turnosdeespera;			// nebulosa de andromeda
	int factordañoporespinas;	// espinas
	
	public SuperficieTierra(){
		
		factorvelocidad = 0;
		factorataque = 0;
		turnosdeespera = 0;
		factordañoporespinas = 0;
	}
	
	public abstract void afectarAlgoformer(Algoformer algoformer);

}
