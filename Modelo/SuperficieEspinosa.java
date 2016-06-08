package Modelo;

public class SuperficieEspinosa extends SuperficieTierra{

	public SuperficieEspinosa(){
		super();
		factordanioporespinas = 0.05; // 5%
	}
	@Override
	public void afectarAlgoformer(afectable serafectable) {
		serafectable.afectarPorEspinas(factordanioporespinas);
	}

}
