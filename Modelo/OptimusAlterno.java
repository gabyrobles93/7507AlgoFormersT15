package Modelo;

public class OptimusAlterno extends Optimus {

	public OptimusAlterno(){
		vida=500;
		ataque=15;
		alcance=4;
		velocidad=5;
		
	}
	public OptimusAlterno(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=15;
		velocidad=5;
		alcance=4;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new OptimusHumanoide(miPosicion,vida);
	}


}
