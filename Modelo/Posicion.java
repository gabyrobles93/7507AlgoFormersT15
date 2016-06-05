package Modelo;

public class Posicion {
private int Fila;
private int Columna;

public Posicion(int fila, int columna) {
	Fila=fila;
	Columna=columna;
}
public int getFila(){
	return Fila;
}
public int getColumna(){
	return Columna;
}
}
