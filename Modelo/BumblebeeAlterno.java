package Modelo;

public class BumblebeeAlterno extends Bumblebee {

	public BumblebeeAlterno(){
		vida=350;
		ataque=20;
		alcance=3;
		velocidad=5;
		
	}
	public BumblebeeAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new BumblebeeHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}


}
