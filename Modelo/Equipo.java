package Modelo;





public class Equipo {

	protected Algoformer algof1;
	protected Algoformer algof2;
	protected Algoformer algof3;	
	protected int vida;
	protected int cantidadMiembrosVivos; 
	protected boolean tieneChispaSuprema; //REVISAR 
	
	
	
	public void jugarTurno(){
	}

/*	public Algoformer getAlgoformer(String string)throws RuntimeException{
		Algoformer respuesta;
		if((respuesta=equipo.get(string))==null){
			throw new ErrorAlgoformerInexistente();
		}; 
		return respuesta;
	}
*/	
	public void setTieneChispaSuprema(boolean tieneChispa){
		
		tieneChispaSuprema=tieneChispa;
	}
	
	public boolean getTieneChispaSuprema(){
		
		return tieneChispaSuprema;
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
	/*public boolean existeAlgoformer(Algoformer integrante){
		
		return equipo.containsValue(integrante);
		
	}
	*/
}
