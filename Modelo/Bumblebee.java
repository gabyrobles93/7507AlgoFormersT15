package Modelo;



public  class Bumblebee extends Algoformer {
	private static Bumblebee INSTANCE=new Bumblebee().new BumblebeeAlterno();
	
	private Bumblebee(){
		
	}
	private class BumblebeeHumanoide extends Bumblebee {

		public BumblebeeHumanoide(){
			super();
			vida=350;
			ataque=40;
			alcance=1;
			velocidad=2;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
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
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
			INSTANCE= new BumblebeeAlterno(miPosicion,vida,efecto.afectaataque);
			miEquipo.algof2=INSTANCE;
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

	private class BumblebeeAlterno extends Bumblebee {

		public BumblebeeAlterno(){
			super();
			vida=350;
			ataque=20;
			alcance=3;
			velocidad=5;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
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
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
		INSTANCE=new BumblebeeHumanoide(miPosicion,vida,efecto.afectaataque);
		miEquipo.algof2=INSTANCE;
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
}
