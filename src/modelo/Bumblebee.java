package modelo;



public  class Bumblebee extends Algoformer {
	private static Bumblebee INSTANCE=new Bumblebee().new BumblebeeHumanoide();
	
	private Bumblebee(){
		Posicion posicioninicial = new Posicion(0,2);
		miPosicion = posicioninicial;
	}
	private class BumblebeeHumanoide extends Bumblebee {

		public BumblebeeHumanoide(){
			super();
			vida=350;
			ataque=35;
			alcance=1;
			velocidad=4;
			efecto.velocidadAfectada=velocidad;
			
		}
		public BumblebeeHumanoide(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=40;
			velocidad=2;
			alcance=1;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
			
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
			INSTANCE= new BumblebeeAlterno(miPosicion,vida,efecto.afectaataque);
			INSTANCE.miPosicion.setMovilOcupa(INSTANCE);
			INSTANCE.miEquipo=miEquipo;
			INSTANCE.miEquipo.algof2=INSTANCE;
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

	private class BumblebeeAlterno extends Bumblebee {

		public BumblebeeAlterno(){
			super();
			vida=350;
			ataque=20;
			alcance=3;
			velocidad=5;
			efecto.velocidadAfectada=velocidad;
			
		}
		public BumblebeeAlterno(Posicion unaPos, int unaVida, double afectaataque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=20;
			velocidad=5;
			alcance=3;
			efecto.velocidadAfectada=velocidad;
			efecto.afectaataque=afectaataque;
			
		}
		@Override
		public void capturarChispa(){
			throw new ErrorEnModoAlternoNoSePuedeCapturarChispa();
			
		}
		public void setEquipo(Equipo equipo){
			miEquipo=equipo;
		}
		
		@Override
		public Algoformer cambiarModo() {
			INSTANCE.miPosicion.LiberarPosicion();
		INSTANCE=new BumblebeeHumanoide(miPosicion,vida,efecto.afectaataque);
		INSTANCE.miPosicion.setMovilOcupa(INSTANCE);
		INSTANCE.miEquipo=miEquipo;
		INSTANCE.miEquipo.algof2=INSTANCE;
		return INSTANCE;
		}

		@Override
		public void afectarPorEspinas(double danioporespinas) {
			vida = vida - (int)(danioporespinas * vida);
		}
		@Override
		public void afectarPorPantano(double coeficiente) {
			efecto.velocidadAfectada = efecto.velocidadAfectada - 1;	// Con 999 representamos que no puede pasar por pantano
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
			// Unidad terrestre, no es afectada por esto.
		}

	}

	public static Bumblebee getBumblebee() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Bumblebee().new BumblebeeAlterno();//metodo para independizar tests
		
	}
	public void ExtirparDesdeSuperion(Superion superion) {//solo deberia ser visible por superion
		INSTANCE.vida=superion.vidaAlSeparar();
		INSTANCE.miPosicion=posicionAlDesarmarSuperion(superion.getPosicion());
		miPosicion.setMovilOcupa(this);
	}
	private Posicion posicionAlDesarmarSuperion(Posicion posicion) {
		// se regenera 2 casilleros a la der del superion, si no puede, se reg uno a la izq del superion
				Posicion posAux;
				try{
					posAux=new Posicion(posicion.getFila(),posicion.getColumna()+2);
				}catch(ErrorPosicionInvalida e){
					posAux=new Posicion(posicion.getFila(),posicion.getColumna()-1);
				}
				
				return posAux;
			}
	
}
