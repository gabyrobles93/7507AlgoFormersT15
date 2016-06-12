package Modelo;

public class RatchetHumanoide extends Ratchet {

	public RatchetHumanoide(){
		super();
		vida=150;
		ataque=5;
		alcance=5;
		velocidad=1;
		efecto.velocidadAfectada=velocidad;
		
	}
	public RatchetHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=5;
		velocidad=1;
		alcance=5;
		efecto.velocidadAfectada=velocidad;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new RatchetAlterno(miPosicion,vida);
	}

	@Override
	public void afectarPorEspinas(double danioporespinas) {
		vida = vida - (int)(danioporespinas * vida);
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		RuntimeException err = new ErrorAlgoformerHumanoideNoPuedePasarPorPantano();
		throw err;
	}
	@Override
	public void afectarPorNebulosaDeAndromeda(int cantidadturnos) {
		// Unidad terrestre, no es afectada por esto.
	}
	@Override
	public void afectarPorTormentaPsionica(double coeficiente) {
		// Unidad terrestre, no es afectada por esto.
		
	}
	@Override
	public void afectarPorSuperficieRocosa(float coeficiente) {
		efecto.afectavelocidad = 0;	// Superficie rocosa no afecta la velocidad
	}
	@Override
	public void afectarPorSuperficieNubosa(float coeficiente) {
		// Unidad terrestre, no es afectada por esto.
	}
	
}
