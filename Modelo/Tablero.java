package Modelo;

import java.util.Arrays;

public  class Tablero{
protected  Casillero matriz[][];
private int CantidadCasilleros=50;

public Tablero(){
	matriz=new Casillero[CantidadCasilleros][CantidadCasilleros];
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	matriz[i][j]=new Casillero();
		}
	}
}
public Tablero(int cantidadCasilleros){
	matriz=new Casillero[cantidadCasilleros][cantidadCasilleros];
	for(int i=0;i<cantidadCasilleros;i++){
		for(int j=0;j<cantidadCasilleros;j++){
	matriz[i][j]=new Casillero();
		}
	}
	CantidadCasilleros=cantidadCasilleros;
}

public void ubicarMovil(movil unMovil,Posicion pos)throws ErrorCasillerOcupado {
	if(matriz[pos.getFila()][pos.getColumna()].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	matriz[pos.getFila()][pos.getColumna()].setMovilOcupa(unMovil);
	unMovil.cambiarPosicion(pos);
	
}

public boolean existeMovil(movil unMovil) {
	boolean encontrado=false;
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	
			if(matriz[i][j].getMovilOcupa()==unMovil) return true;
		}
	}
	return false;
}

public Casillero getCasillero(Posicion pos) {
	return matriz[pos.getFila()][pos.getColumna()];//metodo usado en tests;
}
public void setCasillero(Casillero casillero,Posicion pos){
	matriz[pos.getFila()][pos.getColumna()]=casillero;
}

public void moverMovil(movil unMovil,Posicion posicionDestino) {
	
	
	boolean movimientoPermitido=false;
	Posicion posicionInicial=unMovil.getPosicion();
	
	
	try{
		matriz[posicionInicial.getFila()][posicionInicial.getColumna()].setMovilOcupa(null);//lo borro del casillero inicial
		
		movimientoPermitido=movimientoPosible(unMovil,posicionDestino);
		
		ubicarMovil(unMovil,posicionDestino);
		
	}catch(RuntimeException e){
		//si algo fallo lo vuelvo a poner donde estaba(no tira excp porq lo borre al principio->casillero desocup)
		ubicarMovil(unMovil,posicionInicial);
		throw e;
		
	}
	
	
	
}

public boolean movimientoPosible(movil unMovil, Posicion posicionDestino)throws RuntimeException {
	
	boolean caminoInterrumpido=false;
 int distanciaFila=posicionDestino.getFila()-unMovil.getPosicion().getFila();
 int distanciaColumna=posicionDestino.getColumna()-unMovil.getPosicion().getColumna();
 if(distanciaFila==0&&distanciaColumna<0){//misma fila, mov horizontal
	 for(int i=1;i<=Math.abs(distanciaColumna);i++){
		 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()][unMovil.getPosicion().getColumna()-i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaColumna))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaFila==0&&distanciaColumna>0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=distanciaColumna;i++){
		 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()][unMovil.getPosicion().getColumna()+i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaColumna))){
	 return !caminoInterrumpido;}//se puede mover
	 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaColumna==0&&unMovil.distanciaPosible(Math.abs(distanciaFila))&&distanciaFila<0){//misma col, mov vertical->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaFila);i++){
		 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()-i][unMovil.getPosicion().getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaColumna==0&&distanciaFila>0){//misma col,mov vertical ->velocidadPermitida
	 for(int i=1;i<=distanciaFila;i++){
		 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()+i][unMovil.getPosicion().getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 
 else if(Math.abs(distanciaColumna)==Math.abs(distanciaFila)){//movimiento en diagonal
	 if(distanciaColumna<0&&distanciaFila>0){//mov hacia izq abajo
		 for(int i=1;i<=distanciaFila;i++){
			 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()+i][unMovil.getPosicion().getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna<0&&distanciaFila<0){//mov hacia izq arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()-i][unMovil.getPosicion().getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila<0){//mov hacia derecha arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()+i][unMovil.getPosicion().getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila>0){//mov hacia derecha abajo
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getPosicion().getFila()+i][unMovil.getPosicion().getColumna()+i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
 }
 else throw new ErrorCasillerosNoConectadosPorLineaRecta();
return !caminoInterrumpido;//nunca llega aca, pero me obliga a tener un return en el ambito de la funcion
}

public Tablero getArea(Posicion posicionCentral,int distancia)throws RuntimeException{
	if(distancia<0||posicionCentral.getColumna()<distancia||posicionCentral.getFila()<distancia||
			posicionCentral.getFila()+distancia>CantidadCasilleros
			||posicionCentral.getColumna()+distancia>CantidadCasilleros){
		throw new ErrorAreaFueraDeRangoPosible();
	}
		
	Tablero subTablero=new Tablero(2*distancia+1);
	
	for(int i=0;i<=2*distancia;i++){
		for(int j=0;j<=2*distancia;j++){
			Posicion posicionActual=new Posicion(i,j);
		subTablero.setCasillero(this.matriz[posicionCentral.getFila()-distancia+i][posicionCentral.getColumna()-distancia+j],posicionActual);
		}
	}
	return subTablero;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	return true;
}


/*Esta SubArea No deberia poder modificar los casilleros del original no?*/
}
