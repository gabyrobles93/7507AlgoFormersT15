package Modelo;

public class BumblebeeAlterno extends Bumblebee {

	public BumblebeeAlterno(){
		vida=350;
		ataque=20;
		alcance=3;
		velocidad=5;
		
	}
	public BumblebeeAlterno(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=20;
		velocidad=5;
		alcance=3;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new BumblebeeHumanoide(miPosicion,vida);
	}


}
