package Modelo;


public class Autobots extends Equipo {

	public Autobots(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		algof1=optimus;
		algof2=bumblebee;
		algof3=ratchet;
		
		vida=algof1.getVida()+algof2.getVida()+algof3.getVida();
		cantidadMiembrosVivos=3;
	}
	
	public Optimus getOptimus(){
		return (Optimus) algof1;
	}

	public Bumblebee getBumblebee() {
		
		return (Bumblebee) algof2;
	}

	public Ratchet getRatchet() {
		
		return (Ratchet) algof3;
	}
	
}

