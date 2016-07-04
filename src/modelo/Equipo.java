package modelo;





public abstract class  Equipo {

	protected Algoformer algof1;
	protected Algoformer algof2;
	protected Algoformer algof3;
	protected Algoformer superalgof;
	protected int vida;
	protected int cantidadMiembrosVivos; 

	
	
	
	public void jugarTurno(){
		
		
	}
	
	public int getVidaTotal(){
		
		return vida;
	}
	
	public void setVidaTotal(int vidaDeEquipo){
		vida=vidaDeEquipo;
		if(vidaDeEquipo==0)
			cantidadMiembrosVivos=0;
		
	}
	
	public int getCantidadMiembrosVivos(){
		return cantidadMiembrosVivos;
	}

	public boolean existeAlgoformer(Algoformer algo) {
		if(algo.equals(algof1))
			return true;
		if(algo.equals(algof2))
			return true;
		if(algo.equals(algof3))
			return true;
		return false;
	}
	
	public void ubicarMoviles(Tablero tablero, Posicion posAlgof1, Posicion posAlgof2, Posicion posAlgof3) {
		
		tablero.ubicarMovil(algof1, posAlgof1);
		tablero.ubicarMovil(algof2, posAlgof2);
		tablero.ubicarMovil(algof3, posAlgof3);
	}


	public boolean tieneChispaSuprema(){
		
		return algof1.tieneChispaSuprema()|algof2.tieneChispaSuprema()|algof3.tieneChispaSuprema();
	
	}
	
	public boolean tieneMiembrosVivos(){
		
		return algof1.estaVivo()|algof2.estaVivo()|algof3.estaVivo();
		
	}

	public Algoformer combinar(Posicion posCombiner) {
		// TODO Auto-generated method stub
		//sobreescrito en Decep y Autob
		return null;
	}
public boolean puedeJugar(){
	if(algof1.getEfecto().esperaturnos!=0&&algof2.getEfecto().esperaturnos!=0&&algof3.getEfecto().esperaturnos!=0){
	
		return false;
	}else{
		return true;
	}
}
	

}
