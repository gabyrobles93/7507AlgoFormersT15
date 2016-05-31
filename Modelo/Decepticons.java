package Modelo;

import java.util.HashMap;

public class Decepticons extends Equipo {
	public Decepticons(Megatron megatron,Bonecrusher bonecrusher,Frenzy frenzy){
		equipo=new HashMap<String,Algoformer>();
		equipo.put("megatron", megatron);
		equipo.put("bonecrusher", bonecrusher);
		equipo.put("frenzy", frenzy);
		
		vida=getAlgoformer("frenzy").getVida()+getAlgoformer("megatron").getVida()+getAlgoformer("bonecrusher").getVida();
		tieneChispaSuprema=false;
		cantidadMiembrosVivos=3;
	}

}
