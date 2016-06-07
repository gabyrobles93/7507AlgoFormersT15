package Modelo;

public class BonecrusherAlterno extends Bonecrusher {

	public BonecrusherAlterno(){
		super();
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=8;
		
		
	}
	public BonecrusherAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=30;
		velocidad=8;
		alcance=3;
		
	}

		
	
	@Override
	public Algoformer cambiarModo() {
	return new BonecrusherHumanoide(miPosicion,vida);
	}
	


}
