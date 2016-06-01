package Modelo;

public interface movil {
	public int getFila();
	public int getColumna();
	public void mover(int fila,int columna);
	public boolean distanciaPosible(int abs);

}
