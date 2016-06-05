package Modelo;

import java.util.HashMap;

public class Decepticons extends Equipo {
	public Decepticons(Megatron megatron,Bonecrusher bonecrusher,Frenzy frenzy){
		algof1=megatron;
		algof2=bonecrusher;
		algof3=frenzy;
		
		vida=megatron.getVida()+bonecrusher.getVida()+frenzy.getVida();
		tieneChispaSuprema=false;
		cantidadMiembrosVivos=3;
	}

}
