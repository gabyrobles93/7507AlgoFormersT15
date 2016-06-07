package Modelo;

public class BonecrusherHumanoide extends Bonecrusher {

	public BonecrusherHumanoide(){
		super();
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=1;
		
	}
	public BonecrusherHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=30;
		velocidad=1;
		alcance=3;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new BonecrusherAlterno(miPosicion,vida);
	}

}
