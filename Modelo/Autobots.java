package Modelo;


public class Autobots extends Equipo {

	public Autobots(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		algof1=optimus;
		algof2=bumblebee;
		algof3=ratchet;
		
		vida=algof1.getVida()+algof2.getVida()+algof3.getVida();
		tieneChispaSuprema=false;
		cantidadMiembrosVivos=3;
	}
}
