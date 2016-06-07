package Modelo;

public class OptimusHumanoide extends Optimus {

	public OptimusHumanoide(){
		vida=500;
		ataque=50;
		alcance=2;
		velocidad=2;
		
	}
	public OptimusHumanoide(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=50;
		velocidad=2;
		alcance=2;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new OptimusAlterno(miPosicion,vida);
	}

}
