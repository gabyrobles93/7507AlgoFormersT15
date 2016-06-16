package Modelo;

public class Menasor extends Algoformer{

	public Menasor(Algoformer megatron, Algoformer bonecrusher, Algoformer frenzy,Posicion posMenasor) {
		ataque=115;
		alcance=2;
		velocidad=2;
		vida=megatron.getVida()+bonecrusher.getVida()+frenzy.getVida();
		efecto.velocidadAfectada=velocidad;
		setEquipo();
		miPosicion=posMenasor;
	}

	
	private void setEquipo(){
		miEquipo=new Decepticons();
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


	@Override
	public void cambiarModo() {
		// TODO Auto-generated method stub
		
	}
	


}
