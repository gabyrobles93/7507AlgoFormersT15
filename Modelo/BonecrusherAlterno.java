package Modelo;

public class BonecrusherAlterno extends Bonecrusher {

	public BonecrusherAlterno(){
		super();
		vida=200;
		ataque=30;
		alcance=3;
		velocidad=8;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public BonecrusherAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=30;
		velocidad=8;
		alcance=3;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Decepticons();
	}

		
	
	@Override
	public Algoformer cambiarModo() {
	return new BonecrusherHumanoide(miPosicion,vida);
	}
	
	
	@Override
	public void afectarPorEspinas(double danioporespinas) {
		vida = vida - (int)(danioporespinas * vida);
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		efecto.velocidadAfectada = velocidad-(int)coeficiente*velocidad;		
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
		// Unidad terrestre, no es afectada por esto
	}



}
