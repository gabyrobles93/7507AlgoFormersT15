package Modelo;

public class BumblebeeAlterno extends Bumblebee {

	public BumblebeeAlterno(){
		super();
		vida=350;
		ataque=20;
		alcance=3;
		velocidad=5;
		
	}
	public BumblebeeAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=20;
		velocidad=5;
		alcance=3;
		
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
		efecto.afectavelocidad = coeficiente;	// Con 999 representamos que no puede pasar por pantano
	}
	@Override
	public void afectarPorNebulosaDeAndromeda(int cantidadturnos) {
		efecto.esperaturnos = 0;	// Unidad terrestre, no es afectada por esto.
	}
	@Override
	public void afectarPorTormentaPsionica(double coeficiente) {
		efecto.afectaataque = 0; // Unidad terrestre, no es afectada por esto.
		
	}
	@Override
	public void afectarPorSuperficieRocosa(float coeficiente) {
		efecto.afectavelocidad = 0;	// Superficie rocosa no afecta la velocidad
	}
	@Override
	public void afectarPorSuperficieNubosa(float coeficiente) {
		efecto.afectavelocidad = 0;	// La superficie nubosa no afecta la velocidad
	}

}
