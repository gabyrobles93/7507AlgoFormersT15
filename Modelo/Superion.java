package Modelo;

public class Superion extends Algoformer{

	public Superion(Algoformer optimus, Algoformer bumblebee, Algoformer ratchet,Posicion posSuperion) {
		ataque=100;
		alcance=2;
		velocidad=3;
		vida=optimus.getVida()+bumblebee.getVida()+ratchet.getVida();
		efecto.velocidadAfectada=velocidad;
		setEquipo();
		
		actualizarPosiciones(optimus,bumblebee,ratchet,posSuperion);
	}

	private void actualizarPosiciones(Algoformer optimus, Algoformer bumblebee, Algoformer ratchet,
			Posicion posSuperion) {
		if(posSuperion!=optimus.getPosicion()&&posSuperion!=bumblebee.getPosicion()&&posSuperion!=ratchet.getPosicion()){
			throw new ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores();
		}
		
		optimus.borrarDeTablero();
		bumblebee.borrarDeTablero();
		ratchet.borrarDeTablero();
		posSuperion.setMovilOcupa(this);
		miPosicion=posSuperion;
		
	}

	private void  setEquipo(){
		miEquipo=new Autobots();
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
	public void separar(){
		this.borrarDeTablero();
		Ratchet.getRatchet().ExtirparDesdeSuperion(this);
		Bumblebee.getBumblebee().ExtirparDesdeSuperion(this);
		Optimus.getOptimus().ExtirparDesdeSuperion(this);
	}

	public int vidaAlSeparar() {
		if(vida<3){
			throw new ErrorVidaSuperionInsuficienteParaSepararse();
		}
		return Math.round(vida/3); 
	}

	public void setVida(int i) {//metodo usado en test
		vida=i;
		
	}

}
