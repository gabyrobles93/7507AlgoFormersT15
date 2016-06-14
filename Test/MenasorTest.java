package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorMenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.ErrorVidaMenasorInsuficienteParaSepararse;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Menasor;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.Tablero;

public class MenasorTest {


	@Test
	public void test01MenasorAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);

		Algoformer optimus=new OptimusHumanoide();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos4);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}

	

	 @Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test02MenasorNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos4=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos4);
		
		menasor.atacar(optimus);
	}
	
	
	
	
	 @Test
	public void test03MenasorSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Posicion posFin=new Posicion(3,5);
		
		menasor.mover(posFin);
	
		Assert.assertTrue(menasor.getPosicion().equals(posFin));
	
	}
	
	
	

	 @Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test04MenasorTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Posicion posFin=new Posicion(3,6);
		
		menasor.mover(posFin);
	
	}
	
	
/*	 @Test
	public void test05MenasorEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos4=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos4);	
		
		optimus.atacar(menasor);
	
		Assert.assertTrue(menasor.getVida()==1100);
	} 
*/
	

	 @Test
	public void test06MenasorAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus = new OptimusAlterno();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(optimus, pos4);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}
	
	
	
	/*
	 @Test
	public void test07MenasorEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus = new OptimusAlterno();
		Posicion pos2=new Posicion(3,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(menasor);
		
		Assert.assertTrue(menasor.getVida()==1135);
	}
	 */
	 
		
	 @Test
	public void test08MenasorPuedeFormarsePorDecepticonsHumanoides(){
		
	Tablero tab=new Tablero();
		
	Algoformer megatron=new MegatronHumanoide();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherHumanoide();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	}
	 

	 @Test
	public void test09MenasorPuedeFormarsePorDecepticonsAlternos(){
		
	Tablero tab=new Tablero();
		
	Algoformer megatron=new MegatronAlterno();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyAlterno();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	
	}
	 
	
	 @Test
	public void test10MenasorPuedeFormarsePorDecepticonsEnDiferentesModos(){
		
	Tablero tab=new Tablero();
		
	Algoformer megatron=new MegatronHumanoide();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	
	 }
	 
	 
	 @Test
	public void test11MenasorNaceEnPosicionElegidaDeSusFormadores(){
		
	Tablero tab=new Tablero();
		
	Algoformer megatron=new MegatronHumanoide();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getPosicion()==pos1);
	
	 }
	 
	/*@Test(expected=ErrorMenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores.class)
	public void test12MenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores(){
		
	Tablero tab=new Tablero();
		
	Algoformer megatron=new MegatronHumanoide();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Posicion otraPosicion=new Posicion(4,4);
	
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,otraPosicion);
	 
	 }*/
	 
	/* @Test
	public void test13MenasorSeSepara(){
	Tablero tab=new Tablero()
		 
	Algoformer megatron=new MegatronHumanoide();	
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
	menasor.separar();//FALTA CREAR
	
	//VERFICO QUE LA VIDA DE CADA WACHIN SEA LA DEL MENASOR DIVIDIDO 3
	Assert.assertTrue(megatron.getVida()==round(1000/3));
	Assert.assertTrue(bonecrusher.getVida()==round(1000/3));
	Assert.assertTrue(frenzy.getVida()==round(1000/3));
	}*/
	 
	/*@Test(expected=ErrorVidaMenasorInsuficienteParaSepararse.class)
	public void test14MenasorConVidaInsuficeinteNoPuedeSeperarse(){
	Tablero tab=new Tablero()

	Algoformer megatron=new MegatronHumanoide();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=new BonecrusherAlterno();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=new FrenzyHumanoide();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	menasor.setVida(2);

	menasor.separar();//FALTA CREAR
	}*/
	 
	 /*@Test
	public void test15MenasorPuedeAgarrarChispaSuprema(){
//ESTO QUIZAS VA EN CHISPASUPREMA TEST SOLO TIRO LA IDEA
	*/	
}
