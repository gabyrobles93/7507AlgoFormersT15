package Modelo;



public  class  Bonecrusher extends Algoformer {
	private static Bonecrusher INSTANCE=new Bonecrusher().new BonecrusherAlterno();
	
	private Bonecrusher(){
		
	}
	private class BonecrusherAlterno extends Bonecrusher {

		public BonecrusherAlterno(){
			super();
			vida=200;
			ataque=30;
			alcance=3;
			velocidad=8;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		public BonecrusherAlterno(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=30;
			velocidad=8;
			alcance=3;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
			setEquipo();
		}
		@Override
		public void capturarChispa(){
			throw new ErrorEnModoAlternoNoSePuedeCapturarChispa();
			
		}
		private void setEquipo(){
			miEquipo=new Decepticons();
		}

			
		
		@Override
		public Algoformer cambiarModo() {
		INSTANCE= new BonecrusherHumanoide(miPosicion,vida,efecto.afectaataque);
		miEquipo.algof2=INSTANCE;
		return INSTANCE;
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
	private class BonecrusherHumanoide extends Bonecrusher {

		public BonecrusherHumanoide(){
			super();
			vida=200;
			ataque=30;
			alcance=3;
			velocidad=1;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		public BonecrusherHumanoide(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=30;
			velocidad=1;
			alcance=3;
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
			miEquipo=new Decepticons();
		}

		@Override
		public Algoformer cambiarModo() {
			INSTANCE= new BonecrusherAlterno(miPosicion,vida,efecto.afectaataque);
			miEquipo.algof2=INSTANCE;
			return INSTANCE;
		}

		@Override
		public void afectarPorEspinas(double danioporespinas) {
			vida = vida - (int)(danioporespinas * vida);
		}
		@Override
		public void afectarPorPantano(double coeficiente){
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
			// Superficie rocosa no afecta la velocidad
		}
		
	}
	public static Bonecrusher getBonecrusher() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
		public static  void ResetearInstancia(){
		INSTANCE=new Bonecrusher().new BonecrusherAlterno();//metodo para independizar tests
		
	}
		public void ExtirparDesdeMenasor(Menasor menasor) {
			INSTANCE.vida=menasor.vidaAlSeparar();
			INSTANCE.miPosicion=posicionAlDesarmarMenasor(menasor.getPosicion());
			miPosicion.setMovilOcupa(this);
			
		}
		private Posicion posicionAlDesarmarMenasor(Posicion posicion) {
			// se regenera 2 casilleros a la der del menasor, si no puede, se reg uno a la izq del superion
			Posicion posAux;
			try{
				posAux=new Posicion(posicion.getFila(),posicion.getColumna()+2);
			}catch(ErrorPosicionInvalida e){
				posAux=new Posicion(posicion.getFila(),posicion.getColumna()-1);
			}
			
			return posAux;
		}

		}

