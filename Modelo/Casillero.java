package Modelo;

public class Casillero {
	private movil movilOcupa;
	public SuperficieTierra tierra;
	public SuperficieCielo cielo;
	
	public Casillero(){
<<<<<<< HEAD
	movilOcupa=null;
	tierra = new SuperficieRocosa();
	cielo = new SuperficieNubosa();
	}
	public movil getMovilOcupa() {
	
		
=======
		superficie = new SuperficieRocosa(); // Por default la superficie es rocosa
		movilOcupa=null;
	}
	public movil getMovilOcupa() {	
>>>>>>> d4ae88627390addbd80469dd578c2e53f167de90
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
	

}


