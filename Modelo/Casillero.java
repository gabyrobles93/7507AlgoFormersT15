package Modelo;

public class Casillero {
	private movil movilOcupa;
	private Superficie superficie;
	
	
	public Casillero(){

	movilOcupa=null;
	superficie = new SuperficieRocosa();
	
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


