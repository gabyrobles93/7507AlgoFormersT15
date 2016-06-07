package Modelo;

public class BumblebeeHumanoide extends Bumblebee {

	public BumblebeeHumanoide(){
		vida=350;
		ataque=40;
		alcance=1;
		velocidad=2;
		
	}
	public BumblebeeHumanoide(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=40;
		velocidad=2;
		alcance=1;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new BumblebeeAlterno(miPosicion,vida);
	}

}
