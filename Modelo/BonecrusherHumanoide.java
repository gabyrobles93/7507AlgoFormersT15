package Modelo;

public class BonecrusherHumanoide extends Bonecrusher {

	public BonecrusherHumanoide(){
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=1;
		
	}
	public BonecrusherHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new BonecrusherAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
