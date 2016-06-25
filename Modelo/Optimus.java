package Modelo;



public  class Optimus extends Algoformer {
	private static Optimus INSTANCE=new Optimus().new OptimusHumanoide();
	
	
	private Optimus(){
		
	}
	private class OptimusAlterno extends Optimus {

		public OptimusAlterno(){
			super();
			vida=500;
			ataque=15;
			alcance=4;
			velocidad=5;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		public OptimusAlterno(Posicion unaPos, int unaVida) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=15;
			velocidad=5;
			alcance=4;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
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
		INSTANCE= new OptimusHumanoide(miPosicion,vida,efecto.afectaataque);
		miEquipo.algof1=INSTANCE;
		return INSTANCE;
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
		public Algoformer getInstance(){
			return getOptimus();
		}

	}
	private class OptimusHumanoide extends Optimus {

		public OptimusHumanoide(){
			super();
			vida=500;
			ataque=50;
			alcance=2;
			velocidad=2;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		public OptimusHumanoide(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=50;
			velocidad=2;
			alcance=2;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
			setEquipo();
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
			INSTANCE= new OptimusAlterno(miPosicion,vida);
			miEquipo.algof1=INSTANCE;
			return INSTANCE;
		}

		@Override
		public void afectarPorEspinas(double danioporespinas) {
			vida = vida - (int)(danioporespinas * vida);
		}
		@Override
		public void afectarPorPantano(double coeficiente) {
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
	public static Optimus getOptimus() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Optimus().new OptimusAlterno();//metodo para independizar tests
		
	}
	public void ExtirparDesdeSuperion(Superion superion) {
		INSTANCE.vida=superion.vidaAlSeparar();
		INSTANCE.miPosicion=posicionAlDesarmarSuperion(superion.getPosicion());
		
		miPosicion.setMovilOcupa(this);
	}
	private Posicion posicionAlDesarmarSuperion(Posicion posicion) {
		// se regenera en la posicion del superion, no chequeo nada pq se que es valida
				return posicion;
			
	}

}
