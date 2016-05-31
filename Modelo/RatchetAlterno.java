package Modelo;

public class RatchetAlterno extends Ratchet {

	public RatchetAlterno(){
		vida=150;
		ataque=35;
		alcance=2;
		velocidad=8;
		
	}
	public RatchetAlterno(int unaFila, int unaColumna, int unaVida, int unAtaque, int unaVelocidad, int unAlcance) {
		Fila=unaFila;
		Columna=unaColumna;
		vida=unaVida;
		ataque=unAtaque;
		velocidad=unaVelocidad;
		alcance=unAlcance;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new RatchetHumanoide(Fila,Columna,vida,ataque,velocidad,alcance);
	}


}
