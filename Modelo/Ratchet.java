package Modelo;



public  class Ratchet extends Algoformer {
	private static Ratchet INSTANCE=new Ratchet().new RatchetAlterno();
	
	private Ratchet(){
		
	}
	private class RatchetAlterno extends Ratchet {

		public RatchetAlterno(){
			super();
			vida=150;
			ataque=35;
			alcance=2;
			velocidad=8;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
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
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
		INSTANCE=new  RatchetHumanoide(miPosicion,vida);
		miEquipo.algof3=INSTANCE;
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
			setEquipo();
		}
		public RatchetHumanoide(Posicion unaPos, int unaVida) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=5;
			velocidad=1;
			alcance=5;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Autobots();
		}
		
		@Override
		public void cambiarModo() {
			INSTANCE =new RatchetAlterno(miPosicion,vida,efecto.afectaataque);
			
			miEquipo.algof3=INSTANCE; 
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
	public static Ratchet getRatchet() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Ratchet().new RatchetAlterno();//metodo para independizar tests
		
	}

}
