package Modelo;

public abstract class SuperficieTierra extends Superficie{

	int factorvelocidad; 		// pantano
	int factorataque;			// tormenta psionica
	int turnosdeespera;			// nebulosa de andromeda
	int factorda�oporespinas;	// espinas
	
	public SuperficieTierra(){
		
		factorvelocidad = 0;
		factorataque = 0;
		turnosdeespera = 0;
		factorda�oporespinas = 0;
	}
	
	public abstract void afectarAlgoformer(Algoformer algoformer);

}
