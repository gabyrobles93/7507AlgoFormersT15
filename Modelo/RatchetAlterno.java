package Modelo;

public class RatchetAlterno extends Ratchet {

	public RatchetAlterno(){
		vida=150;
		ataque=35;
		alcance=2;
		velocidad=8;
		
	}
	public RatchetAlterno(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=35;
		velocidad=8;
		alcance=2;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new RatchetHumanoide(miPosicion,vida);
	}


}
