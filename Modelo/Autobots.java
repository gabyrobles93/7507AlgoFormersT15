package Modelo;


public class Autobots extends Equipo {

	//Constructor utilizado para Testing
	public Autobots(){
		
	}
	
	public Autobots(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		algof1=optimus;
		algof2=bumblebee;
		algof3=ratchet;
		algof1.setEquipo(this);
		algof2.setEquipo(this);
		algof3.setEquipo(this);
		
		
		
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

