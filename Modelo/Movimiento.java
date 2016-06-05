package Modelo;

public abstract class Movimiento {

	
	public abstract Movimiento identificarDireccion(int diferenciaEntreFilas,int diferenciaEntreColumnas);
	public abstract boolean caminoLibre(movil unMovil,Tablero unTablero,int filaDestino,int columnaDestino);
}
