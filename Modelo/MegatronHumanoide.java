package Modelo;

public class MegatronHumanoide extends Megatron {
	
	public MegatronHumanoide(){
		super();
		vida=550;
		ataque=10;
		alcance=3;
		velocidad=1;
	}

	public MegatronHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion= unaPos;
		vida=unaVida;
		ataque=10;
		velocidad=1;
		alcance=3;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new MegatronAlterno(miPosicion,vida);
	}

}
