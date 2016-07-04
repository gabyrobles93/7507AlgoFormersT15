package modelo;


public class Autobots extends Equipo {
Superion superion;
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
	@Override
	public void jugarTurno(){
		if(algof1.efecto.esperaturnos!=0)
			algof1.efecto.esperaturnos-=1;
		if(algof2.efecto.esperaturnos!=0)
			algof2.efecto.esperaturnos-=1;
		if(algof3.efecto.esperaturnos!=0)
			algof3.efecto.esperaturnos-=1;
		if(superion!=null&&superion.efecto.esperaturnos!=0){
			superion.efecto.esperaturnos-=1;
		}
		
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Autobots))
			return false;

		return true;
	}
	@Override
	public Algoformer combinar(Posicion posCombiner) {
		try{
		superion=new Superion(algof1,algof2,algof3,posCombiner);
		superion.efecto.esperaturnos+=2;
		algof1.efecto.esperaturnos+=2;
		algof2.efecto.esperaturnos+=2;
		algof3.efecto.esperaturnos+=2;
		superalgof=superion;
		
		return superion;//el constructor lo ubica en tablero
		}catch(RuntimeException e){
			throw e;
		}
		
	}


	
	
}

