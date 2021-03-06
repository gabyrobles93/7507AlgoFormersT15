package modelo;

public class Menasor extends Algoformer{

		private int distanciaDeFormacion=3;
	public Menasor(Algoformer megatron, Algoformer bonecrusher, Algoformer frenzy,Posicion posMenasor) {
		if(posicionesValidas(megatron,bonecrusher,frenzy)==false){
			throw new ErrorDistanciaExcesivaParaFormarMenasor();
		}
		
		ataque=115;
		alcance=2;
		velocidad=2;
		vida=megatron.getVida()+bonecrusher.getVida()+frenzy.getVida();
		efecto.velocidadAfectada=velocidad;
		setEquipo(megatron.getEquipo());
		actualizarPosiciones(megatron,bonecrusher,frenzy,posMenasor);
	}
	private boolean posicionesValidas(Algoformer megatron, Algoformer bonecrusher, Algoformer frenzy) {
		return	megatron.getPosicion().validarDistanciaSuperAlgoformer(bonecrusher,frenzy,distanciaDeFormacion);
	}
	private void actualizarPosiciones(Algoformer megatron, Algoformer bonecrusher, Algoformer frenzy,
			Posicion posMenasor) {
		if(posMenasor!=megatron.getPosicion()&&posMenasor!=bonecrusher.getPosicion()&&posMenasor!=frenzy.getPosicion()){
			throw new ErrorMenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores();
		}
		
		megatron.borrarDeTablero();
		bonecrusher.borrarDeTablero();
		frenzy.borrarDeTablero();
		posMenasor.setMovilOcupa(this);//lo ubica en tablero
		miPosicion=posMenasor;
		
	}
	public int vidaAlSeparar() {
		if(vida<3){
			throw new ErrorVidaMenasorInsuficienteParaSepararse();
		}
		return Math.round(vida/3); 
	}
	public void setVida(int i) {//metodo usado en test
		vida=i;
		
	}
	public void separar(){
		miEquipo.superalgof=null;
		this.borrarDeTablero();
		Frenzy.getFrenzy().ExtirparDesdeMenasor(this);
		Bonecrusher.getBonecrusher().ExtirparDesdeMenasor(this);
		Megatron.getMegatron().ExtirparDesdeMenasor(this);
	}
	
	public void setEquipo(Equipo eq){
		miEquipo=eq;
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
	public void capturarChispa(){
		ChispaSuprema aux=miPosicion.validarDistanciaChispa();
		if(aux==null){
			throw new ErrorDistanciaExcesivaParaCapturarChispa();
		}else{
			this.chispa=aux;
		}
		
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
	public Algoformer cambiarModo() {
		return null;
		
	}
	@Override
	public void atacate(int danio){
		if(vida<=danio){
			vida=0;
			miEquipo.algof1.vida=0;
			miEquipo.algof2.vida=0;
			miEquipo.algof3.vida=0;//si muere superion se termina el juego;
			this.borrarDeTablero();
		}
		else vida=vida-danio;
	}


}
