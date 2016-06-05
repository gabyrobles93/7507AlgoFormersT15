package Modelo;

public class OptimusAlterno extends Optimus {

	public OptimusAlterno(){
		vida=500;
		ataque=15;
		alcance=4;
		velocidad=5;
		
	}
	public OptimusAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new OptimusHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}


}
