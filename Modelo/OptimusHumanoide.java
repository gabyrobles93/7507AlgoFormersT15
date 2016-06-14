package Modelo;

public class OptimusHumanoide extends Optimus {

	public OptimusHumanoide(){
		super();
		vida=500;
		ataque=50;
		alcance=2;
		velocidad=2;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public OptimusHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=50;
		velocidad=2;
		alcance=2;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Autobots();
	}
	
	@Override
	public Algoformer cambiarModo() {
		return new OptimusAlterno(miPosicion,vida);
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
