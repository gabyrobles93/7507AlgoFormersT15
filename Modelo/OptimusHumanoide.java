package Modelo;

public class OptimusHumanoide extends Optimus {

	public OptimusHumanoide(){
		vida=500;
		ataque=50;
		alcance=2;
		velocidad=2;
		
	}
	public OptimusHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new OptimusAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
