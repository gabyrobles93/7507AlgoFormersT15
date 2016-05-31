package Modelo;

public class MegatronAlterno extends Megatron {
	
	
	public MegatronAlterno(){
		vida=550;
		ataque=55;
		alcance=2;
		velocidad=8;
		
	}
	public MegatronAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
	return new MegatronHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
