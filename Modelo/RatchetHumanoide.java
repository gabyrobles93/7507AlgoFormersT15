package Modelo;

public class RatchetHumanoide extends Ratchet {

	public RatchetHumanoide(){
		vida=150;
		ataque=5;
		alcance=5;
		velocidad=1;
		
	}
	public RatchetHumanoide(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=5;
		velocidad=1;
		alcance=5;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new RatchetAlterno(miPosicion,vida);
	}

}
