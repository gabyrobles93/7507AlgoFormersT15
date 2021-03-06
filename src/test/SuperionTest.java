package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.Equipo;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorDistanciaExcesivaParaFormarSuperion;
import modelo.ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.ErrorVidaSuperionInsuficienteParaSepararse;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Ratchet;
import modelo.Superion;
import modelo.Tablero;

public class SuperionTest {

	@Test
	public void test01SuperionAtacaEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 Megatron.ResetearInstancia();
		 
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
		
	
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos4);//Coloco enemigo a maxima distancia alcanzada
		
		superion.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==450);
	}

	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test02SuperionNoPuedeAtacarDecepticonFueraDeRango(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 Megatron.ResetearInstancia();
		 
	 
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos4=new Posicion(6,3);
		tab.ubicarMovil(megatron, pos4);
		
		superion.atacar(megatron);	
	}
	
	
	@Test
	public void test03SuperionSeMueve(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		
		 
	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
		
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		Posicion posFin=new Posicion(3,6);
		
		superion.mover(posFin);
	
		Assert.assertTrue(superion.getPosicion().equals(posFin));
	
	}

	

	 @Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test04SuperionTieneLimiteDeVelocidad(){
		 Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
		 

		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		Posicion posFin=new Posicion(3,7);
		
		superion.mover(posFin);
	
	} 


	@Test
	public void test05SuperionEsAtacadoPorEnemigoHumanoide(){
		
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 Megatron.ResetearInstancia();
		 
		 
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		

		Megatron.getMegatron().cambiarModo();
		Algoformer megatron =Megatron.getMegatron();
		Posicion pos4=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos4);	
		
		megatron.atacar(superion);
		
		Assert.assertTrue(superion.getVida()==990);
	}

	
	@Test
	public void test06SuperionAtacaEnemigoAlterno(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 Megatron.ResetearInstancia();
		
		 
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos4);//Coloco enemigo a maxima distancia alcanzada
		
		superion.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==450);	
	}
	
	@Test
	public void test07SuperionEsAtacadoPorEnemigoAlterno(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
	 
	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos4);
		
		
		megatron.atacar(superion);
		
		Assert.assertTrue(superion.getVida()==945);

	}
	
	 @Test(expected=ErrorDistanciaExcesivaParaFormarSuperion.class)
		public void test08SuperionNoPuedeFormarsePorAutobotsQueNoSeEncuentrenEnUnCuadradoDe7x7(){
		 Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
	
		 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		
		Posicion pos2  =new Posicion(4,3);
		tab.ubicarMovil(bumblebee,pos2);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		
		Posicion pos3  =new Posicion(10,3);//la distancia de a pares debe ser menor a 7
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
	 @Test(expected=ErrorDistanciaExcesivaParaFormarSuperion.class)
		public void test08SuperionNoPuedeFormarsePorAutobotsQueNoSeEncuentrenEnUnCuadradoDe7x7b(){
		 Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
	
			Equipo autobots=new Autobots();
			Optimus.getOptimus().setEquipo(autobots);
			Bumblebee.getBumblebee().setEquipo(autobots);
			Ratchet.getRatchet().setEquipo(autobots);
			
	
		 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(1,1);
		tab.ubicarMovil(optimus,pos1);
		
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		
		Posicion pos2  =new Posicion(0,1);
		tab.ubicarMovil(bumblebee,pos2);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		
		Posicion pos3  =new Posicion(7,7);//la distancia de a pares debe ser menor a 5
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
	 @Test
		public void test08SuperionPuedeFormarsePorAutobotsHumanoides(){
		 Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
	
		 
	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
		 

		 @Test
		public void test09SuperionPuedeFormarsePorAutobotsAlternos(){
			 Ratchet.ResetearInstancia();
			 Optimus.ResetearInstancia();
			 Bumblebee.ResetearInstancia();	
			 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);	
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet =Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
		
		
		 @Test
		public void test10SuperionPuedeFormarsePorAutobotsEnDiferentesModos(){
			
			 Ratchet.ResetearInstancia();
			 Optimus.ResetearInstancia();
			 Bumblebee.ResetearInstancia();
			 
			 
			Equipo autobots=new Autobots();
			Optimus.getOptimus().setEquipo(autobots);
			Bumblebee.getBumblebee().setEquipo(autobots);
			Ratchet.getRatchet().setEquipo(autobots);
					
				 
			Tablero tab=new Tablero();
			Posicion.setTablero(tab);
			
			Optimus.getOptimus().cambiarModo();
			Algoformer optimus = Optimus.getOptimus();
			
			Posicion pos1  =new Posicion(3,3);
			tab.ubicarMovil(optimus,pos1);
			Algoformer bumblebee =  Bumblebee.getBumblebee();
			Posicion pos2  =new Posicion(6,3);
			tab.ubicarMovil(bumblebee,pos2);
			
			Ratchet.getRatchet().cambiarModo();
			Algoformer ratchet = Ratchet.getRatchet();
			
			Posicion pos3  =new Posicion(5,3);
			tab.ubicarMovil(ratchet,pos3);
			Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
			 
			Assert.assertTrue(superion.getVida()==1000);
		
		 }
	
		 
		 @Test
		public void test11SuperionNaceEnPosicionElegidaDeSusFormadores(){
			 Ratchet.ResetearInstancia();
			 Optimus.ResetearInstancia();
			 Bumblebee.ResetearInstancia();
			 
			 
		
			Equipo autobots=new Autobots();
			Optimus.getOptimus().setEquipo(autobots);
			Bumblebee.getBumblebee().setEquipo(autobots);
			Ratchet.getRatchet().setEquipo(autobots);
			
			 
			Tablero tab=new Tablero();
			Posicion.setTablero(tab);
			
			Optimus.getOptimus().cambiarModo();	
			Algoformer optimus = Optimus.getOptimus();
			
			Posicion pos1  =new Posicion(3,3);
			tab.ubicarMovil(optimus,pos1);
			
			Bumblebee.getBumblebee().cambiarModo();
			Algoformer bumblebee = Bumblebee.getBumblebee();
			
			Posicion pos2  =new Posicion(6,3);
			tab.ubicarMovil(bumblebee,pos2);
			
			Ratchet.getRatchet().cambiarModo();
			Algoformer ratchet = Ratchet.getRatchet();
			
			Posicion pos3  =new Posicion(5,3);
			tab.ubicarMovil(ratchet,pos3);
			Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
			 
			//Verifico que este en la posicion que se encontraba optimus
			Assert.assertTrue(superion.getPosicion()==pos1);
		
		 }
		 
	@Test(expected=ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores.class)
		public void test12SuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores(){
		
			Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
		 

		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		
			Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet =Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Posicion otraPosicion=new Posicion(4,4);
		
		Algoformer Superion = new Superion(optimus,bumblebee,ratchet,otraPosicion);
		 
		 }
		 
		@Test
		public void test13SuperionSeSepara(){
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
		 

		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();	
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Superion superion = new Superion(optimus,bumblebee,ratchet,pos1);
			
		superion.separar();//FALTA CREAR

		//VERFICO QUE LA VIDA DE CADA WACHIN SEA LA DEL Superion DIVIDIDO 3
		Assert.assertTrue(optimus.getVida()==Math.round(1000/3));
		Assert.assertTrue(bumblebee.getVida()==Math.round(1000/3));
		Assert.assertTrue(ratchet.getVida()==Math.round(1000/3));

		}
		 
	 @Test(expected=ErrorVidaSuperionInsuficienteParaSepararse.class)
		public void test14SuperionConVidaInsuficeinteNoPuedeSeperarse(){
		
		
		Ratchet.ResetearInstancia();
		 Optimus.ResetearInstancia();
		 Bumblebee.ResetearInstancia();
		 
	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.getRatchet().setEquipo(autobots);
			
		 
		Tablero tab=new Tablero();
		 Posicion.setTablero(tab);
		
		
			Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet =Ratchet.getRatchet();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Superion superion = new Superion(optimus,bumblebee,ratchet,pos1);
		superion.setVida(2);

		superion.separar();//FALTA CREAR
		}
		 
		 /*@Test
		public void test15SuperionPuedeAgarrarChispaSuprema(){
	//ESTO QUIZAS VA EN CHISPASUPREMA TEST SOLO TIRO LA IDEA
		*/	
}
