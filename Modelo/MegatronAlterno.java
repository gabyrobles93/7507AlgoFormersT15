package Modelo;

public class MegatronAlterno extends Megatron {
	
	
	public MegatronAlterno(){
		vida=550;
		ataque=55;
		alcance=2;
		velocidad=8;
		
	}
	public MegatronAlterno(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
	miPosicion=unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
	return new MegatronHumanoide(miPosicion,vida,ataque,velocidad,alcance);
	}

}
