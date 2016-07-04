package Modelo;

public class Casillero {
	private movil movilOcupa;
	private Superficie superficietierra;
	private Superficie superficiecielo;
	
	
	public Casillero(){

	movilOcupa=null;
	superficietierra = new SuperficieRocosa();
	superficiecielo = new SuperficieNubosa();
	
	}
	
	public movil getMovilOcupa() {	
		return  movilOcupa;
	}
	public void setMovilOcupa(movil unmovil) {
		
		movilOcupa=unmovil;
	}
	public boolean estaOcupado() {
		
		return (movilOcupa!=null);
	}

	public void setSuperficieTierra(Superficie nuevasuperficie){
		
		superficietierra = nuevasuperficie;
	}
	
	public void setSuperficieCielo(Superficie nuevasuperficie){
		
		superficiecielo = nuevasuperficie;
	}

	public void afectar(afectable algoformer) {
		superficietierra.afectarAlgoformer(algoformer);
		superficiecielo.afectarAlgoformer(algoformer);
	}
	
	/*TEST USED ONLY*/
	public Superficie getSuperficieTierra() {
		return superficietierra;
	}
	
	/*TEST USED ONLY*/
	public Superficie getSuperficieCielo() {
		return superficiecielo;
	}
}


