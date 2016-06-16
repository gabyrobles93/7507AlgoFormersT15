package Modelo;



public  class Optimus extends Algoformer {
	private static Optimus INSTANCE=new Optimus().new OptimusAlterno();
	
	
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
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
		INSTANCE= new OptimusHumanoide(miPosicion,vida,efecto.afectaataque);
		miEquipo.algof1=INSTANCE;
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
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
			INSTANCE= new OptimusAlterno(miPosicion,vida);
			miEquipo.algof1=INSTANCE;
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

}
