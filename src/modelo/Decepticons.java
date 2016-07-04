package modelo;


public class Decepticons extends Equipo {
	Menasor menasor;
	//Constructor utilizado solo para Testing
	public Decepticons(){
		
	}
	@Override
	public void jugarTurno(){
		if(algof1.efecto.esperaturnos!=0)
			algof1.efecto.esperaturnos-=1;
		if(algof2.efecto.esperaturnos!=0)
			algof2.efecto.esperaturnos-=1;
		if(algof3.efecto.esperaturnos!=0)
			algof3.efecto.esperaturnos-=1;
		if(menasor!=null&&menasor.efecto.esperaturnos!=0){
			menasor.efecto.esperaturnos-=1;
		}
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Decepticons))
			return false;

		return true;
	}
	@Override
	public Algoformer combinar(Posicion posCombiner) {
		// TODO Auto-generated method stub
		try{
			menasor=new Menasor(algof1,algof2,algof3,posCombiner);
			menasor.efecto.esperaturnos=2;
			algof1.efecto.esperaturnos+=2;
			algof2.efecto.esperaturnos+=2;
			algof3.efecto.esperaturnos+=2;
			superalgof=menasor;
			return menasor;//el constructor lo ubica en tablero
			}catch(RuntimeException e){
				throw e;
			}
	}


}
