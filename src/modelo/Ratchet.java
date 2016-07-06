package modelo;



public  class Ratchet extends Algoformer {
	private static Ratchet INSTANCE=new Ratchet().new RatchetHumanoide();
	
	private Ratchet(){
		Posicion posicioninicial = new Posicion(2,0);
		miPosicion = posicioninicial;
	}
	private class RatchetAlterno extends Ratchet {

		public RatchetAlterno(){
			super();
			vida=150;
			ataque=35;
			alcance=2;
			velocidad=8;
			efecto.velocidadAfectada=velocidad;
			
		}
		public RatchetAlterno(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=35;
			velocidad=8;
			alcance=2;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
			
		}
		@Override
		public void capturarChispa(){
			throw new ErrorEnModoAlternoNoSePuedeCapturarChispa();
			
		}
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public Algoformer cambiarModo() {
			INSTANCE.miPosicion.LiberarPosicion();
		INSTANCE=new  RatchetHumanoide(miPosicion,vida);
		INSTANCE.miPosicion.setMovilOcupa(INSTANCE);
		INSTANCE.miEquipo=miEquipo;
		INSTANCE.miEquipo.algof3=INSTANCE;
		return INSTANCE;
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
		throw new ErrorAlgoformerAtascadoEnNebulosaDeAndromeda();
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
	private class RatchetHumanoide extends Ratchet {

		
		public RatchetHumanoide(){
			super();
			vida=150;
			ataque=5;
			alcance=5;
			velocidad=1;
			efecto.velocidadAfectada=velocidad;
			
		}
		public RatchetHumanoide(Posicion unaPos, int unaVida) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=5;
			velocidad=1;
			alcance=5;
			efecto.velocidadAfectada=velocidad;
			
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
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public Algoformer cambiarModo() {
			INSTANCE.miPosicion.LiberarPosicion();
			INSTANCE =new RatchetAlterno(miPosicion,vida,efecto.afectaataque);
			INSTANCE.miPosicion.setMovilOcupa(INSTANCE);
			INSTANCE.miEquipo=miEquipo;
			INSTANCE.miEquipo.algof3=INSTANCE;
			return INSTANCE;
		}

		@Override
		public void afectarPorEspinas(double danioporespinas) {
			vida = vida - (int)(danioporespinas * vida);
		}
		@Override
		public void afectarPorPantano(double coeficiente) {
			miPosicion.LiberarPosicion();
			RuntimeException err = new ErrorAlgoformerHumanoideNoPuedePasarPorPantano();
			throw err;
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
	public static Ratchet getRatchet() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Ratchet().new RatchetAlterno();//metodo para independizar tests
		
	}
	public void ExtirparDesdeSuperion(Superion superion) {//solo deberia ser visible por superion
		INSTANCE.vida=superion.vidaAlSeparar();
		INSTANCE.miPosicion=posicionAlDesarmarSuperion(superion.getPosicion());
		miPosicion.setMovilOcupa(this);
	}
	private Posicion posicionAlDesarmarSuperion(Posicion posicion) {
		// se regenera 2 casilleros a la izq del superion, sinopuede uno a la derecha
		Posicion posAux;
		try{
			posAux=new Posicion(posicion.getFila(),posicion.getColumna()-2);
		}catch(ErrorPosicionInvalida e){
			posAux=new Posicion(posicion.getFila(),posicion.getColumna()+1);
		}
		
		return posAux;
	}

}
