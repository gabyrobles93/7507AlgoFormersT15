package Modelo;

public class FrenzyHumanoide extends Frenzy {

	public FrenzyHumanoide(){
		super();
		vida=400;
		ataque=10;
		alcance=5;
		velocidad=2;
		
	}
	public FrenzyHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=10;
		velocidad=2;
		alcance=5;
		
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
		efecto.afectavelocidad = 999;	// Con 999 representamos que no puede pasar por pantano
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
