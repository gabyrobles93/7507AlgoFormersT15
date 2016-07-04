package Modelo;

/*public class Posicion {

private int Fila;
private int Columna;
private static Tablero tablero;

public Posicion(int fila, int columna) {
	if(fila<0&&fila>49&&columna>49&&columna<0){
		throw new ErrorPosicionInvalida();
	}
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
public void afectar(movil algoformer) {
	
	tablero.afectar(algoformer);
}
public static void setTablero(Tablero tab) {
	tablero = tab;
}
public void LiberarPosicion() {
	tablero.LiberarCasillero(this);
	
}
public void setMovilOcupa(movil superion) {
	tablero.ubicarMovil(superion, this);
	
}
public boolean validarDistanciaSuperAlgoformer(Algoformer bumblebee, Algoformer ratchet, int distanciaDeFormacion) {
	int FilaAux,ColumnaAux;
	for(int i=-distanciaDeFormacion;i<=distanciaDeFormacion;i++){
		for(int j=-distanciaDeFormacion;j<=distanciaDeFormacion;j++){
	 FilaAux=(Fila+i<0)?0:Fila+i;		
	 FilaAux=(Fila+i>49)?49:Fila+i;	//para que no se generen filas nicolumnas invalidas
	 ColumnaAux=(Columna+j<0)?0:Columna+j;		
	 ColumnaAux=(Columna+j>49)?49:Columna+j;	
			
	Posicion posAux=new Posicion(FilaAux,ColumnaAux);
	Tablero subtab=tablero.getArea(posAux, distanciaDeFormacion);
	if(subtab.existeMovil(bumblebee)&&subtab.existeMovil(ratchet)){
		return true;
	}
		}
	}
	return false;
}
public ChispaSuprema validarDistanciaChispa() {
	Tablero subtab=tablero.getArea(this, Juego.distanciaParaCapturarChispa);
	
	if(subtab.existeMovil(Juego.chispa)){
		return Juego.chispa;
	}else{
		return null;
	}
	
}

}
