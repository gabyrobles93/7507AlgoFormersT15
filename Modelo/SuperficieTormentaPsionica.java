package Modelo;

public class SuperficieTormentaPsionica extends SuperficieCielo{

	public SuperficieTormentaPsionica(){
		
		super();
		factorataque = 0.4; // 40%
	}
	
	@Override
	public void afectarAlgoformer(afectable serafectable) {
		serafectable.afectarPorTormentaPsionica(factorataque);
	}

}
