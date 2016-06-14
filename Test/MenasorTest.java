package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Menasor;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.Tablero;

public class MenasorTest {

	/*
	 @Test
	public void test01MenasorAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer menasor = new Menasor();
		menasor.setEquipo(decepticons);
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(menasor,pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}
	 */
	
	/*
	 @Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MenasorNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		
		Algoformer menasor = new Menasor();
		menasor.setEquipo(decepticons);
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(menasor, pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		menasor.atacar(optimus);
	}
	
	 */
	
	/*
	 @Test
	public void test06MenasorSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer menasor = new Menasor();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(menasor,posIni);
		Posicion posFin=new Posicion(3,4);
		
		menasor.mover(posFin);
	
		Assert.assertTrue(menasor.getPosicion().equals(posFin));
	
	}
	
	 */
	
	/*
	 @Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MenasorTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer menasor = new Menasor();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(menasor,posIni);
		Posicion posFin=new Posicion(4,4);
		
		menasor.mover(posFin);
	
	}
	 */
	/*
	 @Test
	public void test08MenasorEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer menasor = new Menasor();
		menasor.setEquipo(decepticons);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(menasor, pos1);


		
		Algoformer optimus = new OptimusHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(menasor);
	
		Assert.assertTrue(menasor.getVida()==1100);
	} 
	 */
	
	/*
	 @Test
	public void test09MenasorAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer menasor = new Menasor();
		menasor.setEquipo(decepticons);
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(menasor, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}
	
	 */
	
	/*
	 @Test
	public void test10MenasorEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer menasor = new Menasor();
		menasor.setEquipo(autobots);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(menasor, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		optimus.setEquipo(decepticons);
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(menasor);
		
		Assert.assertTrue(menasor.getVida()==1135);
	}
	 */
}