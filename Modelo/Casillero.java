package Modelo;

public class Casillero {
	private movil movilOcupa;
	public SuperficieTierra tierra;
	public SuperficieCielo cielo;
	
	public Casillero(){
	movilOcupa=null;

	}
	public movil getMovilOcupa() {
	
		tierra = new SuperficieRocosa();
		cielo = new SuperficieNubosa();
		return  movilOcupa;
	}
	public void setMovilOcupa(movil unmovil) {
		
		movilOcupa=unmovil;
	}
	public boolean estaOcupado() {
		
		return (movilOcupa!=null);
	}

	
	

}


