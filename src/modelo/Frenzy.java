package modelo;



public  class Frenzy extends Algoformer {
	private static Frenzy INSTANCE=new Frenzy().new FrenzyHumanoide();

	private Frenzy(){
		Posicion posicioninicial = new Posicion(49,47);
		miPosicion = posicioninicial;
	}
	private class FrenzyAlterno extends Frenzy {

		public FrenzyAlterno(){
			super();
			vida=400;
			ataque=25;
			alcance=2;
			velocidad=6;
			efecto.velocidadAfectada=velocidad;
			
		}
		public FrenzyAlterno(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=25;
			velocidad=6;
			alcance=2;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
		
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
			INSTANCE.miPosicion.LiberarPosicion();
		INSTANCE= new FrenzyHumanoide(miPosicion,vida);
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
		
	}
	private class FrenzyHumanoide extends Frenzy {

		public FrenzyHumanoide(){
			super();
			vida=400;
			ataque=10;
			alcance=5;
			velocidad=2;
			efecto.velocidadAfectada=velocidad;
			
			
		}
		public FrenzyHumanoide(Posicion unaPos, int unaVida) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=10;
			velocidad=2;
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
			miEquipo=new Decepticons();
		}
		
		@Override
		public Algoformer cambiarModo() {
			INSTANCE.miPosicion.LiberarPosicion();
			INSTANCE= new FrenzyAlterno(miPosicion,vida,efecto.afectaataque);
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
	public static Frenzy getFrenzy() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Frenzy().new FrenzyAlterno();//metodo para independizar tests
		
	}
	public void ExtirparDesdeMenasor(Menasor menasor) {
		INSTANCE.vida=menasor.vidaAlSeparar();
		INSTANCE.miPosicion=posicionAlDesarmarMenasor(menasor.getPosicion());
		miPosicion.setMovilOcupa(this);
		
	}
	private Posicion posicionAlDesarmarMenasor(Posicion posicion) {
		// se regenera 2 casilleros a la izq del menasor, sinopuede uno a la derecha
				Posicion posAux;
				try{
					posAux=new Posicion(posicion.getFila(),posicion.getColumna()-2);
				}catch(ErrorPosicionInvalida e){
					posAux=new Posicion(posicion.getFila(),posicion.getColumna()+1);
				}
				
				return posAux;
			}
	}


