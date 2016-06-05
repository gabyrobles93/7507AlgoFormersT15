package Modelo;

public class BumblebeeHumanoide extends Bumblebee {

	public BumblebeeHumanoide(){
		vida=350;
		ataque=40;
		alcance=1;
		velocidad=2;
		
	}
	public BumblebeeHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new BumblebeeAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
