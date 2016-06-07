package Modelo;

public class FrenzyAlterno extends Frenzy {

	public FrenzyAlterno(){
		vida=400;
		ataque=25;
		alcance=2;
		velocidad=6;
		
	}
	public FrenzyAlterno(Posicion unaPos, int unaVida) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=25;
		velocidad=6;
		alcance=2;
		
	}
	

	@Override
	public Algoformer cambiarModo() {
	return new FrenzyHumanoide(miPosicion,vida);
	}


}
