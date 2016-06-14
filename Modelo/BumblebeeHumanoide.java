package Modelo;

public class BumblebeeHumanoide extends Bumblebee {

	public BumblebeeHumanoide(){
		super();
		vida=350;
		ataque=40;
		alcance=1;
		velocidad=2;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public BumblebeeHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=40;
		velocidad=2;
		alcance=1;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Autobots();
	}
	
	@Override
	public Algoformer cambiarModo() {
		return new BumblebeeAlterno(miPosicion,vida);
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
