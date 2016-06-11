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

	public void setSuperficie(Superficie nuevasuperficie){
		superficie = nuevasuperficie;
	}
	public Superficie getSuperficie(){
		return superficie;
	}
	

}


