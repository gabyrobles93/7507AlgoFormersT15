package Modelo;

public class BonecrusherAlterno extends Bonecrusher {

	public BonecrusherAlterno(){
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=8;
		
	}
	public BonecrusherAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}

		
	
	@Override
	public Algoformer cambiarModo() {
	return new BonecrusherHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}
	


}
