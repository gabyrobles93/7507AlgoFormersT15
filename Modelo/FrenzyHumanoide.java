package Modelo;

public class FrenzyHumanoide extends Frenzy {

	public FrenzyHumanoide(){
		super();
		vida=400;
		ataque=10;
		alcance=5;
		velocidad=2;
		efecto.velocidadAfectada=velocidad;
		
		
	}
	public FrenzyHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=10;
		velocidad=2;
		alcance=5;
		efecto.velocidadAfectada=velocidad;
		
	}
	@Override
	public Algoformer cambiarModo() {
		return new FrenzyAlterno(miPosicion,vida);
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
