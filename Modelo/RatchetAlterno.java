package Modelo;

public class RatchetAlterno extends Ratchet {

	public RatchetAlterno(){
		super();
		vida=150;
		ataque=35;
		alcance=2;
		velocidad=8;
		
	}
	public RatchetAlterno(Posicion unaPos, int unaVida) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=35;
		velocidad=8;
		alcance=2;
		
	}
	@Override
	public Algoformer cambiarModo() {
	return new RatchetHumanoide(miPosicion,vida);
	}

	// UNIDAD AEREA //
	@Override
	public void afectarPorEspinas(double danioporespinas) {
		// Unidad aerea no es afectada por esto
	}
	@Override
	public void afectarPorPantano(double coeficiente) {
		// Unidad aerea no es afectada por esto
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
		// Unidad aerea no es afectada por esto
	}
	@Override
	public void afectarPorSuperficieNubosa(float coeficiente) {
		efecto.afectavelocidad = coeficiente;
	}

}
