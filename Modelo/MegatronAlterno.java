package Modelo;

public class MegatronAlterno extends Megatron {
	
	
	public MegatronAlterno(){
		super();
		vida=550;
		ataque=55;
		alcance=2;
		velocidad=8;
		
	}
	public MegatronAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=55;
		velocidad=8;
		alcance=2;
		
	}

	@Override
	public Algoformer cambiarModo() {
	return new MegatronHumanoide(miPosicion,vida);
	}

	// UNIDAD AEREA //
	@Override
	public void afectarPorEspinas(double danioporespinas) {
		// Unidad aerea no es afectada por espinas
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		efecto.afectavelocidad = 0;	// Unidad aerea, no puede pasar por pantanos.
	}
	@Override
	public void afectarPorNebulosaDeAndromeda(int cantidadturnos) {
		efecto.esperaturnos = cantidadturnos;	
	}
	@Override
	public void afectarPorTormentaPsionica(double coeficiente) {
		efecto.afectaataque = coeficiente; 
		
	}
	@Override
	public void afectarPorSuperficieRocosa(float coeficiente) {
		efecto.afectavelocidad = coeficiente;	// Superficie rocosa no afecta la velocidad
	}
	@Override
	public void afectarPorSuperficieNubosa(float coeficiente) {
		efecto.afectavelocidad = coeficiente;	// La superficie nubosa no afecta la velocidad
	}
	
}
