package Modelo;

public class FrenzyHumanoide extends Frenzy {

	public FrenzyHumanoide(){
		vida=400;
		ataque=10;
		alcance=5;
		velocidad=2;
		
	}
	public FrenzyHumanoide(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=10;
		velocidad=2;
		alcance=5;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new FrenzyAlterno(miPosicion,vida);
	}

}
