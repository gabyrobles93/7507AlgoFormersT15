package Modelo;

public class BonecrusherAlterno extends Bonecrusher {

	public BonecrusherAlterno(){
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=8;
		
	}
	public BonecrusherAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

		
	
	@Override
	public Algoformer cambiarModo() {
	return new BonecrusherHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}
	


}
