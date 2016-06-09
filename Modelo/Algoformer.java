package Modelo;

public abstract class Algoformer implements movil,atacable,atacante,afectable  {
	
	protected int vida;
	protected Posicion miPosicion;
	protected int ataque;
	protected int velocidad;
	protected int alcance;
	protected Efecto efecto;
	protected Equipo miEquipo;
	
	public abstract Algoformer cambiarModo();
	
	public Algoformer(){
		
		efecto = new Efecto();
		efecto.afectaataque = 0;
		efecto.afectavelocidad = 0;
		efecto.esperaturnos = 0;
	
	}
	
	public Posicion getPosicion(){
	
		return miPosicion;
			
	}
	
	public void mover(Posicion pos){
		
		Posicion posicionInicial = miPosicion;
		
		try{
				
				Movimiento mov = Movimiento.crearMovimiento(this, pos);//valida todo
				
				for(int i=0;i<mov.getDistancia();i++){
					mov.Avanzar();
					if(distanciaPosible(mov.getDistancia())==false){
						efecto.velocidadAfectada=velocidad;
						throw new ErrorVelocidadDelMovilInsuficiente();
					}
					
				}
				efecto.velocidadAfectada=velocidad;
				
		}catch(RuntimeException e){
			cambiarPosicion(posicionInicial);//lo pongo donde estaba
			throw e; //no se pudo mover
			
		}
		
		
	}
	


	public void cambiarPosicion(Posicion pos){//metodo que usa movimiento
		miPosicion=pos;
	}




	public boolean distanciaPosible(int distancia) {
		
		return (distancia<=efecto.velocidadAfectada);
		
	}
	
	public int getVida(){
		
		return vida;
	}
	
	public void atacate(int danio){
		if(vida<=danio)vida=0;
		vida=vida-danio;
		
	}
	
	public void atacar(Algoformer victima){

		Ataque ataque = new Ataque();
		
		try{
			ataque.validar(victima, this);
		}
		catch(ErrorDistanciaDeAtaqueInsuficiente err){
			throw err;
		}
		catch(ErrorNoSePuedeAtacarIntegranteDeEquipo err){
			throw err;
		}
		
		ataque.hacer(victima, this.getAtaque());
		
	}

	public int getAtaque() {//lo hago publico para test
		
		return (int)(ataque - ataque * this.getEfectoAtaque());
		
	}

	private double getEfectoAtaque() {
		
		return this.efecto.afectaataque;
	}

	public int getDistanciaDeAtaque(){
		
		return alcance;
	}

	//Setter de Posicion creado para utilizar en test
	public void setPosicion(Posicion unaPosicion) {
		miPosicion=unaPosicion;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alcance;
		result = prime * result + ataque;
		result = prime * result + velocidad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Algoformer other = (Algoformer) obj;
		if (alcance != other.alcance)
			return false;
		if (ataque != other.ataque)
			return false;
		if (velocidad != other.velocidad)
			return false;
		return true;
	}

	public void setEquipo(Equipo unEquipo) {
		miEquipo=unEquipo;
		
	}

	public boolean comparteEquipoCon(Algoformer otroalgoformer) {
		
		return (this.getEquipo() == otroalgoformer.getEquipo());
	}

	private Object getEquipo() {
		return miEquipo;
	}
	
	public Efecto getEfecto(){
		return efecto;
	}

}
