package Modelo;

public class Casillero {
	private movil movilOcupa;
	public Superficie superficie;
	
	public Casillero(){
	movilOcupa=null;

	}
	public movil getMovilOcupa() {
	
		superficie = new SuperficieRocosa(); // Por default la superficie es rocosa
		return  movilOcupa;
	}
	public void setMovilOcupa(movil unmovil) {
		
		movilOcupa=unmovil;
	}
	public boolean estaOcupado() {
		
		return (movilOcupa!=null);
	}
	public Superficie getSuperficie() {
		return superficie;
	}

	
	

}


