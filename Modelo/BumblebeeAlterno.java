package Modelo;

public class BumblebeeAlterno extends Bumblebee {

	public BumblebeeAlterno(){
		vida=350;
		ataque=20;
		alcance=3;
		velocidad=5;
		
	}
	public BumblebeeAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new BumblebeeHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}


}
