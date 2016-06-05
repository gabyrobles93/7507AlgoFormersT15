package Modelo;

public class FrenzyAlterno extends Frenzy {

	public FrenzyAlterno(){
		vida=400;
		ataque=25;
		alcance=2;
		velocidad=6;
		
	}
	public FrenzyAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new FrenzyHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}


}
