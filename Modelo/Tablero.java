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

public void ubicarAlgoformer(AlgoFormer unAlgoformer,int fila, int columna)throws ErrorCasillerOcupado {
	if(matriz[fila][columna].estaOcupado()==true){
		throw new ErrorCasillerOcupado();
	}
	matriz[fila][columna].setAlgoformerOcupa(unAlgoformer);
	unAlgoformer.setFila(fila);
	unAlgoformer.setColumna(columna);
}

public boolean existeAlgoFormer(AlgoFormer unAlgoformer) {
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

public void moverAlgoformer(AlgoFormer megatron, int filaDestino, int columnaDestino) {
	if(movimientoPosible(megatron,filaDestino,columnaDestino)){
		megatron.setFila(filaDestino);
		megatron.setColumna(columnaDestino);
		matriz[filaDestino][columnaDestino].setAlgoformerOcupa(megatron);
	}
	
}

public boolean movimientoPosible(AlgoFormer unAlgoformer, int filaDestino, int columnaDestino)throws RuntimeException {
	if(filaDestino>CantidadCasilleros||columnaDestino>CantidadCasilleros){
		throw new ErrorCasilleroInvalido();
	}
	boolean caminoInterrumpido=false;
 int distanciaFila=filaDestino-unAlgoformer.getFila();
 int distanciaColumna=columnaDestino-unAlgoformer.getColumna();
 if(distanciaFila==0&&unAlgoformer.distanciaPosible(Math.abs(distanciaColumna))&&distanciaColumna<0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaColumna);i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()][unAlgoformer.getColumna()-i].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
 }
 if(distanciaFila==0&&unAlgoformer.distanciaPosible(Math.abs(distanciaColumna))&&distanciaColumna>0){//misma fila, mov horizontal->velocidadPermitida
	 for(int i=1;i<=distanciaColumna;i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()][unAlgoformer.getColumna()+i].estaOcupado();
	 }
 }
 if(distanciaColumna==0&&unAlgoformer.distanciaPosible(Math.abs(distanciaFila))&&distanciaFila<0){//misma col, mov vertical->velocidadPermitida
	 for(int i=1;i<=Math.abs(distanciaFila);i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()-i][unAlgoformer.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
 }
 if(distanciaColumna==0&&unAlgoformer.distanciaPosible(Math.abs(distanciaFila))&&distanciaFila>0){//misma col,mov vertical ->velocidadPermitida
	 for(int i=1;i<=distanciaFila;i++){
		 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()].estaOcupado();
		 if(caminoInterrumpido==true) return !caminoInterrumpido;
	 }
 }
 
 if(Math.abs(distanciaColumna)==Math.abs(distanciaFila)){//movimiento en diagonal
	 if(distanciaColumna<0&&distanciaFila>0){//mov hacia izq abajo
		 for(int i=1;i<=distanciaFila;i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
	 }
	 if(distanciaColumna<0&&distanciaFila<0){//mov hacia izq arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()-i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
	 }
	 if(distanciaColumna>0&&distanciaFila<0){//mov hacia derecha arriba
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()-i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
	 }
	 if(distanciaColumna>0&&distanciaFila>0){//mov hacia derecha abajo
		 for(int i=1;i<=Math.abs(distanciaFila);i++){
			 caminoInterrumpido=matriz[unAlgoformer.getFila()+i][unAlgoformer.getColumna()+i].estaOcupado();
			 if(caminoInterrumpido==true) return !caminoInterrumpido;
		 }
	 }
 }
 return !caminoInterrumpido;
}

}
