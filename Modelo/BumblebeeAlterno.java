package Modelo;

public class BumblebeeAlterno extends Bumblebee {

	public BumblebeeAlterno(){
		super();
		vida=350;
		ataque=20;
		alcance=3;
		velocidad=5;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public BumblebeeAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=20;
		velocidad=5;
		alcance=3;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Autobots();
	}
	
	@Override
	public Algoformer cambiarModo() {
	return new BumblebeeHumanoide(miPosicion,vida);
	}

	@Override
	public void afectarPorEspinas(double danioporespinas) {
		vida = vida - (int)(danioporespinas * vida);
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		efecto.velocidadAfectada = efecto.velocidadAfectada - 1;	// Con 999 representamos que no puede pasar por pantano
	}
	@Override
	public void afectarPorNebulosaDeAndromeda(int cantidadturnos) {
		//Unidad terrestre, no es afectada por esto.
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
