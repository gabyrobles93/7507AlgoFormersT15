package Modelo;

public class OptimusAlterno extends Optimus {

	public OptimusAlterno(){
		vida=500;
		ataque=15;
		alcance=4;
		velocidad=5;
		
	}
	public OptimusAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new OptimusHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}


}
