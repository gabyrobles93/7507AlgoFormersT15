package Modelo;


public class Decepticons extends Equipo {
	public Decepticons(Megatron megatron,Bonecrusher bonecrusher,Frenzy frenzy){
		algof1=megatron;
		algof2=bonecrusher;
		algof3=frenzy;
		
		vida=megatron.getVida()+bonecrusher.getVida()+frenzy.getVida();
		cantidadMiembrosVivos=3;
	}

	public Megatron getMegatron() {

		return (Megatron) algof1;
	}

	public Bonecrusher getBonecrusher() {

		return (Bonecrusher) algof2;
	}

	public Frenzy getFrenzy() {
		
		return (Frenzy) algof3;
	}

}
