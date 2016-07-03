package modelo;

public abstract class Superficie {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(factorataque);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(factordanioporespinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(factorvelocidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + turnosdeespera;
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
		Superficie other = (Superficie) obj;
		if (Double.doubleToLongBits(factorataque) != Double.doubleToLongBits(other.factorataque))
			return false;
		if (Double.doubleToLongBits(factordanioporespinas) != Double.doubleToLongBits(other.factordanioporespinas))
			return false;
		if (Double.doubleToLongBits(factorvelocidad) != Double.doubleToLongBits(other.factorvelocidad))
			return false;
		if (turnosdeespera != other.turnosdeespera)
			return false;
		return true;
	}

	double factorvelocidad; 		// pantano
	double factorataque;			// tormenta psionica
	int turnosdeespera;			// nebulosa de andromeda
	double factordanioporespinas;	// espinas
	
	public abstract void afectarAlgoformer(afectable serafectable);

	public Superficie(){
		
		factorvelocidad = 0;
		factorataque = 0;
		turnosdeespera = 0;
		factordanioporespinas = 0;
	}
	
}
