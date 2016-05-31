package Modelo;

import java.awt.List;
import java.util.ArrayList;


public class Equipo {

	private Algoformer equipo[];
	private int vida;
	;private int cantidadMiembrosVivos;
	private boolean tieneChispaSuprema; 
	
	public Equipo(Algoformer algof1,Algoformer algof2,Algoformer algof3){
		equipo=new Algoformer[3];
		equipo[0]=algof1;
		equipo[1]=algof2;
		equipo[2]=algof3;
		vida=getAlgoformer(0).getVida()+getAlgoformer(1).getVida()+getAlgoformer(2).getVida();
		tieneChispaSuprema=false;
		cantidadMiembrosVivos=3;
	}
	
	public void jugarTurno(){
	}

	public Algoformer getAlgoformer(int numeroDeAlgoformer){
		
		return equipo[numeroDeAlgoformer]; 
	}
	
	public void setTieneChispaSuprema(boolean tieneChispa){
		
		tieneChispaSuprema=tieneChispa;
	}
	
	public boolean getTieneChispaSuprema(){
		
		return tieneChispaSuprema;
	}
	
	public int getVidaTotal(){
		
		return vida;
	}
	
	public void setVidaTotal(int vidaDeEquipo){
		vida=vidaDeEquipo;
		
	}
	
	public int getCantidadMiembrosVivos(){
		return cantidadMiembrosVivos;
	}
	
}
