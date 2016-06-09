package Modelo;

public class FrenzyAlterno extends Frenzy {

	public FrenzyAlterno(){
		super();
		vida=400;
		ataque=25;
		alcance=2;
		velocidad=6;
		efecto.velocidadAfectada=velocidad;
		
	}
	public FrenzyAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=25;
		velocidad=6;
		alcance=2;
		efecto.velocidadAfectada=velocidad;
		
	}
	

	@Override
	public Algoformer cambiarModo() {
	return new FrenzyHumanoide(miPosicion,vida);
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
