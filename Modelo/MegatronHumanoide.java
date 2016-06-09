package Modelo;

public class MegatronHumanoide extends Megatron {
	
	public MegatronHumanoide(){
		super();
		vida=550;
		ataque=10;
		alcance=3;
		velocidad=1;
		efecto.velocidadAfectada=velocidad;
	}

	public MegatronHumanoide(Posicion unaPos, int unaVida) {
		super();
		miPosicion= unaPos;
		vida=unaVida;
		ataque=10;
		velocidad=1;
		efecto.velocidadAfectada=velocidad;
		alcance=3;
		
	}

	@Override
	public Algoformer cambiarModo() {
		Algoformer mega =new MegatronAlterno(miPosicion,vida,efecto.afectaataque);
		miEquipo.algof1=mega;
		return mega;
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
		// Unidad terrestre, no es afectada por esto
	}
}
