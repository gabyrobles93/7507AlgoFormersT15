package Modelo;

public class FrenzyHumanoide extends Frenzy {

	public FrenzyHumanoide(){
		vida=400;
		ataque=10;
		alcance=5;
		velocidad=2;
		
	}
	public FrenzyHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new FrenzyAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
