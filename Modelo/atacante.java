package Modelo;

public interface atacante {

	public void atacar(atacable victima);

	public int getDistanciaDeAtaque(movil victima);

	public boolean alcancePosible(int alcance);
}
