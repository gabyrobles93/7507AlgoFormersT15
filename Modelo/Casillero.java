package Modelo;

public class Casillero {
	private Algoformer algoformerOcupa;
	
	public Casillero(){
	algoformerOcupa=null;

	}
	public Algoformer getAlgoformerOcupa() {
	
		return  algoformerOcupa;
	}
	public void setAlgoformerOcupa(Algoformer unAlgoformer) {
		
		algoformerOcupa=unAlgoformer;
	}
	public boolean estaOcupado() {
		
		return (algoformerOcupa!=null);
	}

	
	

}


