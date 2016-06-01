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

public void ubicarAlgoformer(Algoformer unAlgoformer,int fila, int columna)throws ErrorCasillerOcupado {
	if(matriz[fila][columna].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	matriz[fila][columna].setAlgoformerOcupa(unAlgoformer);
	unAlgoformer.setFila(fila);
	unAlgoformer.setColumna(columna);
}

public boolean existeAlgoformer(Algoformer unAlgoformer) {
	boolean encontrado=false;
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	
			if(matriz[i][j].getAlgoformerOcupa()==unAlgoformer) return true;
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

public void moverAlgoformer(Algoformer megatron, int filaDestino, int columnaDestino) {
	boolean movimientoPermitido=false;
	try{
		movimientoPermitido=movimientoPosible(megatron,filaDestino,columnaDestino);
		megatron.setFila(filaDestino);
		megatron.setColumna(columnaDestino);
		matriz[filaDestino][columnaDestino].setAlgoformerOcupa(megatron);
	}catch(RuntimeException e){
		throw e;
		
	}
	
}

public boolean movimientoPosible(Algoformer unAlgoformer, int filaDestino, int columnaDestino)throws RuntimeException {
	if(filaDestino>CantidadCasilleros||columnaDestino>CantidadCasilleros){
		throw new ErrorCasilleroInvalido();
	}
	boolean caminoInterrumpido=false;
 int distanciaFila=filaDestino-unAlgoformer.getFila();
 int distanciaColumna=columnaDestino-unAlgoformer.getColumna();
 if(distanciaFila==0&&distanciaColumna<0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaColumna);i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()][unAlgoformer.getColumna()-i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unAlgoformer.distanciaPosible(Math.abs(distanciaColumna))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
 }
 else if(distanciaFila==0&&distanciaColumna>0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=distanciaColumna;i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()][unAlgoformer.getColumna()+i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unAlgoformer.distanciaPosible(Math.abs(distanciaColumna))){
	 return !caminoInterrumpido;}//se puede mover
	 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
 }
 else if(distanciaColumna==0&&unAlgoformer.distanciaPosible(Math.abs(distanciaFila))&&distanciaFila<0){//misma col, mov vertical->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaFila);i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()-i][unAlgoformer.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
 }
 else if(distanciaColumna==0&&distanciaFila>0){//misma col,mov vertical ->velocidadPermitida
	 for(int i=1;i<=distanciaFila;i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
	 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
		 return !caminoInterrumpido;}//se puede mover
		 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
 }
 
 else if(Math.abs(distanciaColumna)==Math.abs(distanciaFila)){//movimiento en diagonal
	 if(distanciaColumna<0&&distanciaFila>0){//mov hacia izq abajo
		 for(int i=1;i<=distanciaFila;i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
	 }
	 if(distanciaColumna<0&&distanciaFila<0){//mov hacia izq arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()-i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila<0){//mov hacia derecha arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
	 }
	 if(distanciaColumna>0&&distanciaFila>0){//mov hacia derecha abajo
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()+i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
		 if(unAlgoformer.distanciaPosible(Math.abs(distanciaFila))){
			 return !caminoInterrumpido;}//se puede mover
			 else throw new ErrorVelocidadDelAlgoformerInsuficiente();
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
<<<<<<< HEAD
public boolean atacarPosible(Algoformer atacante,Algoformer victima){
	
	
	int distanciaColumna=Math.abs(atacante.getColumna()-victima.getColumna());
	
	int distanciaFila= Math.abs(atacante.getFila()-victima.getFila());
	
	int alcance=(distanciaFila>=distanciaColumna)?distanciaFila:distanciaColumna;//alcance es la mayor de las distancias
	
	
	return atacante.alcancePosible(alcance);
	
	
	
}
=======

	public boolean ataquePosible(){
		
		return true;
	}
>>>>>>> 0e13acb5afddfa127ebc6f278fb4c42c80b1c3d7
/*Esta SubArea No deberia poder modificar los casilleros del original no?*/
}
