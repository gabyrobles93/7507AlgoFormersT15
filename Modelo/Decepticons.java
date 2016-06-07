package Modelo;


public class Decepticons extends Equipo {
	
	//Constructor utilizado solo para Testing
	public Decepticons(){
		
	}
	
	
	public Decepticons(Megatron megatron,Bonecrusher bonecrusher,Frenzy frenzy){
		algof1=megatron;
		algof2=bonecrusher;
		algof3=frenzy;
		
		algof1.setEquipo(this);
		algof2.setEquipo(this);
		algof3.setEquipo(this);
		
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
