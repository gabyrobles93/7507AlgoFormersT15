package Modelo;

public class RatchetAlterno extends Ratchet {

	public RatchetAlterno(){
		vida=150;
		ataque=35;
		alcance=2;
		velocidad=8;
		
	}
	public RatchetAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new RatchetHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}


}
