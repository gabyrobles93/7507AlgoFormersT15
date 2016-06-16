package Modelo;



public  class Frenzy extends Algoformer {
	private static Frenzy INSTANCE=new Frenzy().new FrenzyAlterno();

	private Frenzy(){
		
	}
	private class FrenzyAlterno extends Frenzy {

		public FrenzyAlterno(){
			super();
			vida=400;
			ataque=25;
			alcance=2;
			velocidad=6;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
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
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Decepticons();
		}
		

		@Override
		public void cambiarModo() {
		INSTANCE= new FrenzyHumanoide(miPosicion,vida);
		miEquipo.algof3=INSTANCE;
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
			setEquipo();
			
		}
		public FrenzyHumanoide(Posicion unaPos, int unaVida) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=10;
			velocidad=2;
			alcance=5;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Decepticons();
		}
		
		@Override
		public void cambiarModo() {
			INSTANCE= new FrenzyAlterno(miPosicion,vida,efecto.afectaataque);
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


