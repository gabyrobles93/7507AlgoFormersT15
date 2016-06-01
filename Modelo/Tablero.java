package Modelo;

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

public void ubicarMovil(movil unMovil,int fila, int columna)throws ErrorCasillerOcupado {
	if(matriz[fila][columna].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	matriz[fila][columna].setMovilOcupa(unMovil);
	unMovil.mover(fila,columna);
	
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

public Casillero getCasillero(int fila, int columna) {
	return matriz[fila][columna];//metodo usado en tests;
}
public void setCasillero(Casillero casillero,int fila,int columna){
	matriz[fila][columna]=casillero;
}

public void moverMovil(movil unMovil, int filaDestino, int columnaDestino) {
	
	
	boolean movimientoPermitido=false;
	int columnaInicial=unMovil.getColumna();
	int filaInicial=unMovil.getFila();
	
	
	try{
		matriz[filaInicial][columnaInicial].setMovilOcupa(null);//lo borro del casillero inicial
		
		movimientoPermitido=movimientoPosible(unMovil,filaDestino,columnaDestino);
		
		ubicarMovil(unMovil,filaDestino,columnaDestino);
		
	}catch(RuntimeException e){
		//si algo fallo lo vuelvo a poner donde estaba(no tira excp porq lo borre al principio->casillero desocup)
		ubicarMovil(unMovil,filaInicial,columnaInicial);
		throw e;
		
	}
	
	
	
}

public boolean movimientoPosible(movil unMovil, int filaDestino, int columnaDestino)throws RuntimeException {
	if(filaDestino>CantidadCasilleros||columnaDestino>CantidadCasilleros){
		throw new ErrorCasilleroInvalido();
	}
	boolean caminoInterrumpido=false;
 int distanciaFila=filaDestino-unMovil.getFila();
 int distanciaColumna=columnaDestino-unMovil.getColumna();
 if(distanciaFila==0&&distanciaColumna<0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaColumna);i++){
		 caminoInterrumpido=matriz[unMovil.getFila()][unMovil.getColumna()-i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaColumna))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaFila==0&&distanciaColumna>0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=distanciaColumna;i++){
		 caminoInterrumpido=matriz[unMovil.getFila()][unMovil.getColumna()+i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaColumna))){
	 return !caminoInterrumpido;}//se puede mover
	 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaColumna==0&&unMovil.distanciaPosible(Math.abs(distanciaFila))&&distanciaFila<0){//misma col, mov vertical->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaFila);i++){
		 caminoInterrumpido=matriz[unMovil.getFila()-i][unMovil.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 else if(distanciaColumna==0&&distanciaFila>0){//misma col,mov vertical ->velocidadPermitida
	 for(int i=1;i<=distanciaFila;i++){
		 caminoInterrumpido=matriz[unMovil.getFila()+i][unMovil.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelMovilInsuficiente();
 }
 
 else if(Math.abs(distanciaColumna)==Math.abs(distanciaFila)){//movimiento en diagonal
	 if(distanciaColumna<0&&distanciaFila>0){//mov hacia izq abajo
		 for(int i=1;i<=distanciaFila;i++){
			 caminoInterrumpido=matriz[unMovil.getFila()+i][unMovil.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna<0&&distanciaFila<0){//mov hacia izq arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getFila()-i][unMovil.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila<0){//mov hacia derecha arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getFila()+i][unMovil.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unMovil.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelMovilInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila>0){//mov hacia derecha abajo
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unMovil.getFila()+i][unMovil.getColumna()+i].estaOcupado();
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

public Tablero getArea(int columnaCentral,int filaCentral,int distancia)throws RuntimeException{
	if(distancia<0||columnaCentral<distancia||filaCentral<distancia||filaCentral+distancia>CantidadCasilleros
			||columnaCentral+distancia>CantidadCasilleros){
		throw new ErrorAreaFueraDeRangoPosible();
	}
		
	Tablero subTablero=new Tablero(2*distancia+1);
	
	for(int i=0;i<=2*distancia;i++){
		for(int j=0;j<=2*distancia;j++){
		subTablero.setCasillero(this.matriz[filaCentral-distancia+i][columnaCentral-distancia+j],i,j);
		}
	}
	return subTablero;
}

public boolean ataquePosible(atacante unAtacante,movil victima){
	
	int alcance=unAtacante.getDistanciaDeAtaque(victima);
	
	
	
	return unAtacante.alcancePosible(alcance);
	
	
	
}


/*Esta SubArea No deberia poder modificar los casilleros del original no?*/
}
