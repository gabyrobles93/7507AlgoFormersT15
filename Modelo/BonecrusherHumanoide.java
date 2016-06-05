package Modelo;

public class BonecrusherHumanoide extends Bonecrusher {

	public BonecrusherHumanoide(){
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=1;
		
	}
	public BonecrusherHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new BonecrusherAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
