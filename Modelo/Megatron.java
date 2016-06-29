package Modelo;

public  class Megatron extends Algoformer {
	private  static Megatron INSTANCE=new Megatron().new MegatronHumanoide();

	
	
	public static  Megatron getMegatron(){
		return INSTANCE;
	}

	private Megatron(){
		
	}
	public static  void ResetearInstancia(){
		INSTANCE=new Megatron().new MegatronAlterno();//metodo para independizar tests
		
	}
	@Override
	public Algoformer cambiarModo() {
	return null;
	}
	private class MegatronAlterno extends Megatron {
		
		
		@Override
		public Algoformer cambiarModo() {
			INSTANCE =new MegatronHumanoide(miPosicion,vida,efecto.afectaataque);
			
			miEquipo.algof1=INSTANCE;
			return INSTANCE;
			
		}
		public MegatronAlterno(){
			super();
			vida=550;
			ataque=55;
			alcance=2;
			velocidad=8;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		public MegatronAlterno(Posicion unaPos, int unaVida, double afectaAtaque) {
			super();
			miPosicion=unaPos;
			vida=unaVida;
			ataque=55 - (int)(afectaAtaque*55);
			velocidad=8;
			alcance=2;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}
		@Override
		public void capturarChispa(){
			throw new ErrorEnModoAlternoNoSePuedeCapturarChispa();
			
		}
		
		private void setEquipo(){
			miEquipo=new Decepticons();
		}

		

		// UNIDAD AEREA //
		@Override
		public void afectarPorEspinas(double danioporespinas) {
			// Unidad aerea no es afectada por espinas
		}
		@Override
		public void afectarPorPantano(double coeficiente) {
			// Unidad aerea no es afectada por pantano
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
			// Unidad aerea no es afectada por superficie rocosa
		}
		@Override
		public void afectarPorSuperficieNubosa(float coeficiente) {
			efecto.afectavelocidad = coeficiente;
		}
		
	}
	private class MegatronHumanoide extends Megatron {
		
		
		
		public MegatronHumanoide(){
			super();
			vida=550;
			ataque=10;
			alcance=3;
			velocidad=1;
			efecto.velocidadAfectada=velocidad;
			setEquipo();
		}

		public MegatronHumanoide(Posicion unaPos, int unaVida,double afectaataque) {
			super();
			miPosicion= unaPos;
			vida=unaVida;
			ataque=10;
			velocidad=1;
			efecto.velocidadAfectada=velocidad;
			alcance=3;
			efecto.afectaataque=afectaataque;
			setEquipo();
		}
		
		private void setEquipo(){
			miEquipo=new Decepticons();
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
		public Algoformer cambiarModo() {
			INSTANCE =new MegatronAlterno(miPosicion,vida,efecto.afectaataque);
			
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
			// Unidad terrestre, no es afectada por esto
		}
	}
	public void ExtirparDesdeMenasor(Menasor menasor) {
		INSTANCE.vida=menasor.vidaAlSeparar();
		INSTANCE.miPosicion=posicionAlDesarmarMenasor(menasor.getPosicion());
		miPosicion.setMovilOcupa(this);
		
	}

	private Posicion posicionAlDesarmarMenasor(Posicion posicion) {
		// se regenera en la posicion del menasor, no chequeo nada pq se que es valida
		return posicion;
	
	}

	

}
