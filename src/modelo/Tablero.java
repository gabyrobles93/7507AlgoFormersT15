package modelo;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	this.fijarSuperficiesIniciales();
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
	Posicion posicionInicial=unMovil.getPosicion();
	if(posicionInicial==null){
		unMovil.cambiarPosicion(pos);
		matriz[pos.getFila()][pos.getColumna()].setMovilOcupa(unMovil);
		return;
	}
	
	if(posicionInicial!=null){
	matriz[posicionInicial.getFila()][posicionInicial.getColumna()].setMovilOcupa(null);
	
	matriz[pos.getFila()][pos.getColumna()].setMovilOcupa(unMovil);
	unMovil.cambiarPosicion(pos);
	}
}

public boolean existeMovil(movil unMovil) {
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

/* Test-Used Only */
public Casillero getCasillero(int fila, int columna) {
	return matriz[fila][columna];//metodo usado en tests;
}

public void setCasillero(Casillero casillero,Posicion pos){
	matriz[pos.getFila()][pos.getColumna()]=casillero;
}





public Tablero getArea(Posicion posicionCentral,int distancia)throws RuntimeException{
	if(distancia<0){
		throw new ErrorAreaFueraDeRangoPosible();
	}
	int columnaMin=posicionCentral.getColumna()-distancia;
	int	columnaMax=posicionCentral.getColumna()+distancia;
	
	int FilaMin=posicionCentral.getFila()-distancia;
	int	FilaMax=posicionCentral.getFila()+distancia;
	
	if(columnaMin<0){
		columnaMin=0;
	}
	
	if(FilaMin<0){
		FilaMin=0;
	}
	if(columnaMax>=CantidadCasilleros){
		columnaMax=CantidadCasilleros-1;
	}
	
	if(FilaMax>=CantidadCasilleros){
		FilaMax=CantidadCasilleros-1;
	}
		Tablero subTablero=new Tablero(2*distancia+1);
		
		for(int FilaOriginal=FilaMin,i=0;FilaOriginal<=FilaMax&&i<=2*distancia;FilaOriginal++,i++){
			for(int ColumnaOriginal=columnaMin,j=0;ColumnaOriginal<=columnaMax&&j<=2*distancia;ColumnaOriginal++,j++){
				Posicion posicionActual=new Posicion(i,j);
			subTablero.setCasillero(this.matriz[FilaOriginal][ColumnaOriginal],posicionActual);
			}
		}
		return subTablero;
	}
/*	
	int distanciaX=distancia;
	int	distanciaY=distancia;
	if(posicionCentral.getColumna()<distancia){
		distanciaX=posicionCentral.getColumna();
	}
	
	if(posicionCentral.getFila()<distancia){
		distanciaY=posicionCentral.getFila();
	}
	if(posicionCentral.getFila()+distancia>CantidadCasilleros){
		distanciaY=CantidadCasilleros-posicionCentral.getFila();
	}
	
	if(posicionCentral.getColumna()+distancia>CantidadCasilleros){
		distanciaX=CantidadCasilleros -posicionCentral.getColumna();
	}
		
	Tablero subTablero=new Tablero(2*distancia+1);
	
	for(int i=0;i<=2*distanciaY;i++){
		for(int j=0;j<=2*distanciaX;j++){
			Posicion posicionActual=new Posicion(i,j);
		subTablero.setCasillero(this.matriz[posicionCentral.getFila()-distanciaY+i][posicionCentral.getColumna()-distanciaX+j],posicionActual);
		}
	}
	return subTablero;
*/




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


public void setSuperficieTierraEnCasillero(Posicion pos, Superficie superficie) {	
	matriz[pos.getFila()][pos.getColumna()].setSuperficieTierra(null);
	matriz[pos.getFila()][pos.getColumna()].setSuperficieTierra(superficie);	
}

public void setSuperficieCieloEnCasillero(Posicion pos, Superficie superficie) {	
	matriz[pos.getFila()][pos.getColumna()].setSuperficieCielo(superficie);	
}

public void afectar(movil algoformer) {
	
	this.getCasillero(algoformer.getPosicion()).afectar((afectable) algoformer);
}

public void LiberarCasillero(Posicion posicion) {
	matriz[posicion.getFila()][posicion.getColumna()].setMovilOcupa(null);
	
}
private void fijarSuperficiesIniciales(){
/*
	Posicion pos1 = new Posicion(10,10);
	Posicion pos2 = new Posicion(40,40);
	Posicion pos3 = new Posicion(10,40);
	Posicion pos4 = new Posicion(40,10);
	
	SuperficieNubosa supCielo=new SuperficieNubosa();
	SuperficieRocosa supRoca=new SuperficieRocosa();
		this.setearSuperficieCielo(supCielo);
		this.setearSuperficieTierra(supRoca);
	
SuperficieEspinosa supEsp=new SuperficieEspinosa();	
Tablero subtab=this.getArea(pos1, 2);
subtab.setearSuperficieTierra(supEsp);

SuperficiePantanosa supPant=new SuperficiePantanosa();
Tablero subtab2=this.getArea(pos2, 2);
subtab2.setearSuperficieTierra(supPant);


SuperficieNebulosaDeAndromeda supNeb=new SuperficieNebulosaDeAndromeda();
Tablero subtab3=this.getArea(pos3, 2);
subtab3.setearSuperficieCielo(supNeb);

SuperficieTormentaPsionica supTorm=new SuperficieTormentaPsionica();
Tablero subtab4=this.getArea(pos4, 2);
subtab4.setearSuperficieCielo(supTorm);
		
*/

	
	for( int fila = 0; fila < 50; fila++){
		
		// seteo superficies tierra 
		for( int columna = 0; columna < 50; columna ++){
			
			int randomNum = 0 + (int)(Math.random() * 15);	
			
			if(randomNum == 4 || randomNum == 8 ){
				Superficie suppant = new SuperficiePantanosa();
				matriz[fila][columna].setSuperficieTierra(suppant);
				
			}else
				
			if(randomNum == 5 || randomNum == 15){  
				Superficie supesp = new SuperficieEspinosa();
				matriz[fila][columna].setSuperficieTierra(supesp);
			
			}else{
				Superficie suproc = new SuperficieRocosa();
				matriz[fila][columna].setSuperficieTierra(suproc);
			
			}
		}	
	}
	
	for( int fila = 0; fila < 50; fila++){
		
		for( int columna = 0; columna < 50; columna ++){
			
			int randomNum = 0 + (int)(Math.random() * 15);
			
			if(randomNum == 4 || randomNum == 8 ){
				Superficie suptormpsio = new SuperficieTormentaPsionica();
				matriz[fila][columna].setSuperficieCielo(suptormpsio);
			}else
				
			if(randomNum == 5 || randomNum == 15){  
				Superficie supnebandr = new SuperficieNebulosaDeAndromeda();
				matriz[fila][columna].setSuperficieCielo(supnebandr);
			
			}else{
				Superficie supnub = new SuperficieNubosa();
				matriz[fila][columna].setSuperficieCielo(supnub);
			
			}
		}	
	}
	
	
/*

		
		// En torno a la chispa en el cielo 
		for( int fila = 20; fila < 30; fila++){
			for( int columna = 20; columna < 30; columna ++){
				
				int randomNum = 0 + (int)(Math.random() * 20);
				
				if(randomNum == 4 || randomNum == 8 ){

					pos.setPosicion(fila,columna);
					this.setSuperficieCieloEnCasillero(pos, suptormpsio);
				}
				
				if(randomNum == 5 || randomNum == 15){
				    
					pos.setPosicion(fila,columna);
					this.setSuperficieCieloEnCasillero(pos, supnebandr);
				}	
			}
		}

		
		// En torno a la chispa en la tierra 
		for( int fila = 20; fila < 30; fila++){
	
			// seteo superficies tierra 
			for( int columna = 20; columna < 30; columna ++){
				
				int randomNum = 0 + (int)(Math.random() * 20);
				
				if(randomNum == 4 || randomNum == 8){

					pos.setPosicion(fila,columna);
					this.setSuperficieTierraEnCasillero(pos, suppant);
				}
				
				if(randomNum == 5 || randomNum == 15){
				    
					pos.setPosicion(fila,columna);
					this.setSuperficieTierraEnCasillero(pos, supesp);
				}
			
			}
			
		
		}
		*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	
	
	Posicion pos1 = new Posicion(10,10);
	Posicion pos2 = new Posicion(40,40);
	Posicion pos3 = new Posicion(10,40);
	Posicion pos4 = new Posicion(40,10);
	
	SuperficieNubosa supCielo=new SuperficieNubosa();
	SuperficieRocosa supRoca=new SuperficieRocosa();
		this.setearSuperficieCielo(supCielo);
		this.setearSuperficieTierra(supRoca);
	
SuperficieEspinosa supEsp=new SuperficieEspinosa();	
Tablero subtab=this.getArea(pos1, 2);
subtab.setearSuperficieTierra(supEsp);

SuperficiePantanosa supPant=new SuperficiePantanosa();
Tablero subtab2=this.getArea(pos2, 2);
subtab2.setearSuperficieTierra(supPant);


SuperficieNebulosaDeAndromeda supNeb=new SuperficieNebulosaDeAndromeda();
Tablero subtab3=this.getArea(pos3, 2);
subtab3.setearSuperficieCielo(supNeb);

SuperficieTormentaPsionica supTorm=new SuperficieTormentaPsionica();
Tablero subtab4=this.getArea(pos4, 2);
subtab4.setearSuperficieCielo(supTorm);

	*/


private void setearSuperficieTierra(SuperficieTierra sup){
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	
			matriz[i][j].setSuperficieTierra(sup);
		}
	}
	
}
private void setearSuperficieCielo(SuperficieCielo sup){
	for(int i=0;i<CantidadCasilleros;i++){
		for(int j=0;j<CantidadCasilleros;j++){
	
			matriz[i][j].setSuperficieCielo(sup);
		}
	}
	
}
}
