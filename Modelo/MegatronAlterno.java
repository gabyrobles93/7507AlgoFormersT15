package Modelo;

public class MegatronAlterno extends Megatron {
	
	
	public MegatronAlterno(){
		super();
		vida=550;
		ataque=55;
		alcance=2;
		velocidad=8;
		
	}
	public MegatronAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=55;
		velocidad=8;
		alcance=2;
		
	}

	@Override
	public Algoformer cambiarModo() {
	return new MegatronHumanoide(miPosicion,vida);
	}

}
