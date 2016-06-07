package Modelo;





public abstract class  Equipo {

	protected Algoformer algof1;
	protected Algoformer algof2;
	protected Algoformer algof3;	
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

}
