package Modelo;

public class MegatronHumanoide extends Megatron {
	
	public MegatronHumanoide(){
		vida=550;
		ataque=10;
		alcance=3;
		velocidad=1;
	}

	public MegatronHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new MegatronAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
