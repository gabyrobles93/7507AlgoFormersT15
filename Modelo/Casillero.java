package Modelo;

public class Casillero {
	private AlgoFormer algoformerOcupa;
	public Casillero(){
	algoformerOcupa=null;
	}
	public AlgoFormer getAlgoformerOcupa() {
	
		return  algoformerOcupa;
	}
	public void setAlgoformerOcupa(AlgoFormer unAlgoformer) {
		
		algoformerOcupa=unAlgoformer;
	}
	public boolean estaOcupado() {
		
		return (algoformerOcupa!=null);
	}
	
	

}


