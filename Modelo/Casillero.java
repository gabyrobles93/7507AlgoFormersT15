package Modelo;

public class Casillero {
	private movil movilOcupa;
	
	public Casillero(){
	movilOcupa=null;

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

	
	

}


