package Modelo;

public class FrenzyAlterno extends Frenzy {

	public FrenzyAlterno(){
		vida=400;
		ataque=25;
		alcance=2;
		velocidad=6;
		
	}
	public FrenzyAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new FrenzyHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}


}
