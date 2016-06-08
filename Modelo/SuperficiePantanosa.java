package Modelo;

public class SuperficiePantanosa extends SuperficieTierra{

	SuperficiePantanosa(){
		super();
		factorvelocidad = 0.5;
	}
	public void afectarAlgoformer(afectable serafectable) {
		serafectable.afectarPorPantano(factorvelocidad);
	}

}
