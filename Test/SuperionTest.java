package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusHumanoide;
import Modelo.Superion;
import Modelo.Posicion;
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
	public void test03SuperionNoPuedeAtacarDecepticonFueraDeRango(){

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
	public void test06SuperionSeMueve(){
		
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
	public void test07SuperionTieneLimiteDeVelocidad(){
		
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
	public void test08SuperionEsAtacadoPorEnemigoHumanoide(){
		
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
	public void test09SuperionAtacaEnemigoAlterno(){
		
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
	public void test10SuperionEsAtacadoPorEnemigoAlterno(){
		
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
	
}
