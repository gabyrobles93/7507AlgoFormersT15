package Modelo;

import java.util.HashMap;

public class Autobots extends Equipo {

	public Autobots(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		equipo=new HashMap<String,Algoformer>();
		equipo.put("optimus", optimus);
		equipo.put("bumblebee", bumblebee);
		equipo.put("ratchet", ratchet);
		
		vida=getAlgoformer("ratchet").getVida()+getAlgoformer("bumblebee").getVida()+getAlgoformer("optimus").getVida();
		tieneChispaSuprema=false;
		cantidadMiembrosVivos=3;
	}
}
