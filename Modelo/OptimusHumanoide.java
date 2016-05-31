package Modelo;

public class OptimusHumanoide extends Optimus {

	public OptimusHumanoide(){
		vida=500;
		ataque=50;
		alcance=2;
		velocidad=2;
		
	}
	public OptimusHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new OptimusAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
