package modelo;

public class SuperficieNebulosaDeAndromeda extends SuperficieCielo{

	public SuperficieNebulosaDeAndromeda(){
		super();
		turnosdeespera = 3;
	}
	public void afectarAlgoformer(afectable serafectable) {
		serafectable.afectarPorNebulosaDeAndromeda(turnosdeespera);		
	}

}
