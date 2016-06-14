package Modelo;

public class MegatronAlterno extends Megatron {
	
	
	public MegatronAlterno(){
		super();
		vida=550;
		ataque=55;
		alcance=2;
		velocidad=8;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	public MegatronAlterno(Posicion unaPos, int unaVida, double afectaAtaque) {
		super();
		miPosicion=unaPos;
		vida=unaVida;
		ataque=55 - (int)(afectaAtaque*55);
		velocidad=8;
		alcance=2;
		efecto.velocidadAfectada=velocidad;
		setEquipo();
	}
	
	private void setEquipo(){
		miEquipo=new Decepticons();
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
		// Unidad aerea no es afectada por pantano
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
		// Unidad aerea no es afectada por superficie rocosa
	}
	@Override
	public void afectarPorSuperficieNubosa(float coeficiente) {
		efecto.afectavelocidad = coeficiente;
	}
	
}
