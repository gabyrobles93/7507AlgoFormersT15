package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Bonecrusher;

import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorDistanciaExcesivaParaFormarMenasor;
import Modelo.ErrorMenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.ErrorVidaMenasorInsuficienteParaSepararse;
import Modelo.Frenzy;

import Modelo.Megatron;

import Modelo.Menasor;
import Modelo.Movimiento;
import Modelo.Optimus;

import Modelo.Posicion;
import Modelo.Tablero;

public class MenasorTest {


	@Test
	public void test01MenasorAtacaEnemigoHumanoide(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Bonecrusher.getBonecrusher().cambiarModo();
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus=Optimus.getOptimus();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos4);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}

	

	 @Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test02MenasorNoPuedeAtacarAutobotFueraDeRango(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Bonecrusher.getBonecrusher().cambiarModo();
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus= Optimus.getOptimus();
		Posicion pos4=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos4);
		
		menasor.atacar(optimus);
	}
	
	
	
	
	 @Test
	public void test03MenasorSeMueve(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Bonecrusher.getBonecrusher().cambiarModo();
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Posicion posFin=new Posicion(3,5);
		
		menasor.mover(posFin);
	
		Assert.assertTrue(menasor.getPosicion().equals(posFin));
	
	}
	
	
	

	 @Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test04MenasorTieneLimiteDeVelocidad(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Bonecrusher.getBonecrusher().cambiarModo();
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		Posicion posFin=new Posicion(3,6);
		
		menasor.mover(posFin);
	
	}
	
	
	 @Test
	public void test05MenasorEsAtacadoPorEnemigoHumanoide(){
		Megatron.ResetearInstancia();
		Frenzy.ResetearInstancia();
		Bonecrusher.ResetearInstancia();
		Optimus.ResetearInstancia();
		 
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos4=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos4);	
		
		optimus.atacar(menasor);
	
		Assert.assertTrue(menasor.getVida()==1100);
	} 

	

	 @Test
	public void test06MenasorAtacaEnemigoAlterno(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Bonecrusher.getBonecrusher().cambiarModo();
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(optimus, pos4);//Coloco enemigo a maxima distancia alcanzada
		
		menasor.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==385);
		
	}
	
	
	
	
	 @Test
	public void test07MenasorEsAtacadoPorEnemigoAlterno(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(6,3);
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos4=new Posicion(3,2);
		
		tab.ubicarMovil(optimus, pos4);
		
		
		optimus.atacar(menasor);
		
		Assert.assertTrue(menasor.getVida()==1135);
	}
	 
	 
		
	 @Test
	public void test08MenasorPuedeFormarsePorDecepticonsHumanoides(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	
	Megatron.getMegatron().cambiarModo();
	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Frenzy.getFrenzy().cambiarModo();
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	}
	 

	 @Test
	public void test09MenasorPuedeFormarsePorDecepticonsAlternos(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	
	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	
	}
	 
	 @Test(expected=ErrorDistanciaExcesivaParaFormarMenasor.class)
		public void test09MenasorNoPuedeFormarseSiLos3AlgoformersNoEstanIncluidosEnCuadradoDe7x7(){
			 Megatron.ResetearInstancia();
			 Frenzy.ResetearInstancia();
			 Bonecrusher.ResetearInstancia();
			 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
			
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(5,3);
		tab.ubicarMovil(bonecrusher,pos2);
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos3=new Posicion(10,3);//la distancia de a pares debe ser menor a 7
		tab.ubicarMovil(frenzy,pos3);
		Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		 
		
		
		}
		 
	
	 @Test
	public void test10MenasorPuedeFormarsePorDecepticonsEnDiferentesModos(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	Megatron.getMegatron().cambiarModo();
	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Frenzy.getFrenzy().cambiarModo();
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getVida()==1150);
	
	 }
	 
	 
	 @Test
	public void test11MenasorNaceEnPosicionElegidaDeSusFormadores(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
		
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	Megatron.getMegatron().cambiarModo();
	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Frenzy.getFrenzy().cambiarModo();
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	 
	Assert.assertTrue(menasor.getPosicion()==pos1);
	
	 }
	 
	@Test(expected=ErrorMenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores.class)
	public void test12MenasorNoPuedeNacerFueraDeLasPosicionesDeSusFormadores(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 	
		
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	Movimiento.setTablero(tab);
	
	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Posicion otraPosicion=new Posicion(4,4);
	
	Algoformer menasor = new Menasor(megatron,bonecrusher,frenzy,otraPosicion);
	 
	 }
	 
	@Test
	public void test13MenasorSeSepara(){
		 Megatron.ResetearInstancia();
		 Frenzy.ResetearInstancia();
		 Bonecrusher.ResetearInstancia();
		 
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);
	
		 
	Algoformer megatron=Megatron.getMegatron();	
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Menasor menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
		
	menasor.separar();//FALTA CREAR
	
	//VERFICO QUE LA VIDA DE CADA WACHIN SEA LA DEL MENASOR DIVIDIDO 3
	Assert.assertTrue(megatron.getVida()==Math.round(1150/3));
	Assert.assertTrue(bonecrusher.getVida()==Math.round(1150/3));
	Assert.assertTrue(frenzy.getVida()==Math.round(1150/3));
	}
	 
	@Test(expected=ErrorVidaMenasorInsuficienteParaSepararse.class)
	public void test14MenasorConVidaInsuficeinteNoPuedeSeperarse(){
	Tablero tab=new Tablero();
	Posicion.setTablero(tab);

	Algoformer megatron=Megatron.getMegatron();
	Posicion pos1=new Posicion(3,3);
	tab.ubicarMovil(megatron,pos1);
	Algoformer bonecrusher=Bonecrusher.getBonecrusher();
	Posicion pos2=new Posicion(5,3);
	tab.ubicarMovil(bonecrusher,pos2);
	Algoformer frenzy=Frenzy.getFrenzy();
	Posicion pos3=new Posicion(6,3);
	tab.ubicarMovil(frenzy,pos3);
	Menasor menasor = new Menasor(megatron,bonecrusher,frenzy,pos1);
	menasor.setVida(2);

	menasor.separar();
	}
	 
	 /*@Test
	public void test15MenasorPuedeAgarrarChispaSuprema(){
//ESTO QUIZAS VA EN CHISPASUPREMA TEST SOLO TIRO LA IDEA
	*/	
}
