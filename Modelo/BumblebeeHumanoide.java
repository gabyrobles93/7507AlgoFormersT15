package Modelo;

public class BumblebeeHumanoide extends Bumblebee {

	public BumblebeeHumanoide(){
		vida=350;
		ataque=40;
		alcance=1;
		velocidad=2;
		
	}
	public BumblebeeHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new BumblebeeAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
