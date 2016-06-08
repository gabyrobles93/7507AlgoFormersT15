package Modelo;

public abstract class Superficie {

	double factorvelocidad; 		// pantano
	double factorataque;			// tormenta psionica
	int turnosdeespera;			// nebulosa de andromeda
	double factordanioporespinas;	// espinas
	
	public abstract void afectarAlgoformer(afectable serafectable);

	public Superficie(){
		
		factorvelocidad = 0;
		factorataque = 0;
		turnosdeespera = 0;
		factordanioporespinas = 0;
	}
	
}
