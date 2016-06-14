package Modelo;

public class OptimusAlterno extends Optimus {

	public OptimusAlterno(){
		super();
		vida=500;
		ataque=15;
		alcance=4;
		velocidad=5;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public OptimusAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=15;
		velocidad=5;
		alcance=4;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Autobots();
	}
	
	@Override
	public Algoformer cambiarModo() {
	return new OptimusHumanoide(miPosicion,vida);
	}

	
	@Override
	public void afectarPorEspinas(double danioporespinas) {
		vida = vida - (int)(danioporespinas * vida);
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		efecto.velocidadAfectada = velocidad-(int)coeficiente*velocidad;		// Con 999 representamos que no puede pasar por pantano
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
