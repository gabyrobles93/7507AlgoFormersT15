package Modelo;

public class BonecrusherHumanoide extends Bonecrusher {

	public BonecrusherHumanoide(){
		super();
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=1;
		
	}
	public BonecrusherHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=30;
		velocidad=1;
		alcance=3;
		
	}

	@Override
	public Algoformer cambiarModo() {
		return new BonecrusherAlterno(miPosicion,vida);
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
		// Superficie rocosa no afecta la velocidad
	}
	
}
