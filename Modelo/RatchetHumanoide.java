package Modelo;

public class RatchetHumanoide extends Ratchet {

	public RatchetHumanoide(){
		vida=150;
		ataque=5;
		alcance=5;
		velocidad=1;
		
	}
	public RatchetHumanoide(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new RatchetAlterno(Fila,Columna,vida,ataque,velocidad,alcance);
	}

}
