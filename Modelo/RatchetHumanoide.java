package Modelo;

public class RatchetHumanoide extends Ratchet {

	public RatchetHumanoide(){
		vida=150;
		ataque=5;
		alcance=5;
		velocidad=1;
		
	}
	public RatchetHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new RatchetAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
