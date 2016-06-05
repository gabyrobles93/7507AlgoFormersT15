package Modelo;

public class MegatronHumanoide extends Megatron {
	
	public MegatronHumanoide(){
		vida=550;
		ataque=10;
		alcance=3;
		velocidad=1;
	}

	public MegatronHumanoide(Posicion unaPos, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		miPosicion= unaPos;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new MegatronAlterno(miPosicion,vida,ataque,velocidad,alcance);
	}

}
