package Modelo;

public class FrenzyHumanoide extends Frenzy {

	public FrenzyHumanoide(){
		vida=400;
		ataque=10;
		alcance=5;
		velocidad=2;
		
	}
	public FrenzyHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new FrenzyAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
