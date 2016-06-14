package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.ErrorVidaSuperionInsuficienteParaSepararse;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Superion;
import Modelo.Posicion;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;

public class SuperionTest {

	@Test
	public void test01SuperionAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos4);//Coloco enemigo a maxima distancia alcanzada
		
		superion.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==450);
	}

	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test02SuperionNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
	
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos4=new Posicion(6,3);
		tab.ubicarMovil(megatron, pos4);
		
		superion.atacar(megatron);	
	}
	
	
	@Test
	public void test03SuperionSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		Posicion posFin=new Posicion(3,6);
		
		superion.mover(posFin);
	
		Assert.assertTrue(superion.getPosicion().equals(posFin));
	
	}

	

	 @Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test04SuperionTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);

		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		Posicion posFin=new Posicion(3,7);
		
		superion.mover(posFin);
	
	} 

/*
	@Test
	public void test05SuperionEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);


		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos4=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos4);	
		
		megatron.atacar(superion);
		
		Assert.assertTrue(superion.getVida()==990);
	}
*/	
	
	@Test
	public void test06SuperionAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Algoformer megatron = new MegatronAlterno();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos4);//Coloco enemigo a maxima distancia alcanzada
		
		superion.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==450);	
	}
	
	/*@Test
	public void test07SuperionEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		
		Algoformer megatron = new MegatronAlterno();
		Posicion pos4=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos4);
		
		
		megatron.atacar(superion);
		
		Assert.assertTrue(superion.getVida()==945);

	}*/
	
	 @Test
		public void test08SuperionPuedeFormarsePorAutobotsHumanoides(){
			
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
		 

		 @Test
		public void test09SuperionPuedeFormarsePorAutobotsAlternos(){
			
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusAlterno();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeAlterno();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetAlterno();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		}
		
		
		 @Test
		public void test10SuperionPuedeFormarsePorAutobotsEnDiferentesModos(){
			
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeAlterno();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		Assert.assertTrue(superion.getVida()==1000);
		
		 }
	
		 
		 @Test
		public void test11SuperionNaceEnPosicionElegidaDeSusFormadores(){
			
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		 
		//Verifico que este en la posicion que se encontraba optimus
		Assert.assertTrue(superion.getPosicion()==pos1);
		
		 }
		 
		/*@Test(expected=ErrorSuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores.class)
		public void test12SuperionNoPuedeNacerFueraDeLasPosicionesDeSusFormadores(){
			
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Posicion otraPosicion=new Posicion(4,4);
		
		Algoformer Superion = new Superion(optimus,bumblebee,ratchet,otraPosicion);
		 
		 }*/
		 
		/* @Test
		public void test13SuperionSeSepara(){
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
			
		superion.separar();//FALTA CREAR

		//VERFICO QUE LA VIDA DE CADA WACHIN SEA LA DEL Superion DIVIDIDO 3
		Assert.assertTrue(optimus.getVida()==round(1100/3));
		Assert.assertTrue(bumblebee.getVida()==round(1100/3));
		Assert.assertTrue(ratchet.getVida()==round(1100/3));

		}*/
		 
	  /*  @Test(expected=ErrorVidaSuperionInsuficienteParaSepararse.class)
		public void test14SuperionConVidaInsuficeinteNoPuedeSeperarse(){
		Tablero tab=new Tablero();
			
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Algoformer bumblebee = new BumblebeeHumanoide();
		Posicion pos2  =new Posicion(6,3);
		tab.ubicarMovil(bumblebee,pos2);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion pos3  =new Posicion(5,3);
		tab.ubicarMovil(ratchet,pos3);
		Algoformer superion = new Superion(optimus,bumblebee,ratchet,pos1);
		superion.setVida(2);

		superion.separar();//FALTA CREAR
		}*/
		 
		 /*@Test
		public void test15SuperionPuedeAgarrarChispaSuprema(){
	//ESTO QUIZAS VA EN CHISPASUPREMA TEST SOLO TIRO LA IDEA
		*/	
}
