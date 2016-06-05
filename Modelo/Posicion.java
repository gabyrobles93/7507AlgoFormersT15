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
	


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Posicion other = (Posicion) obj;
	if (Columna != other.Columna)
		return false;
	if (Fila != other.Fila)
		return false;
	return true;
}

}
