package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Bonecrusher;

import Modelo.Bumblebee;

import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Megatron;

import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Ratchet;

import Modelo.Tablero;

public class BumblebeeAlternoTest {

	@Test
	public void test01BumblebeeAlternoAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(bumblebee,pos1);
		
		Algoformer bonecrusher= Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(bonecrusher,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==180);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BumblebeeAlternoNoPuedeAtacarAutobots(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer ratchet =  Ratchet.getRatchet();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(ratchet, pos2);
		
		bumblebee.atacar(ratchet);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BumblebeeAlternoNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee=Bumblebee.getBumblebee();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(megatron, pos2);
		
		bumblebee.atacar(megatron);
		
	}
	
	@Test
	public void test04CambioBumblebeeAModoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Bumblebee.ResetearInstancia();
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Megatron.getMegatron(), posIni);
		
	
		Assert.assertTrue(Bumblebee.getBumblebee().getDistanciaDeAtaque()==3);
		
		Bumblebee bone1=Bumblebee.getBumblebee();
		
		Bumblebee.getBumblebee().cambiarModo();
		
		
		
		Assert.assertTrue(Bumblebee.getBumblebee().getDistanciaDeAtaque()==1);//en modo humanoide alcance==3
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06BumblebeeAlternoSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bumblebee,posIni);
		Posicion posFin=new Posicion(6,4);
		
		bumblebee.mover(posFin);
	
		Assert.assertTrue(bumblebee.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BumblebeeAlternoTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);

		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bumblebee,posIni);
		Posicion posFin=new Posicion(9,4);
		
		bumblebee.mover(posFin);
		
	}
	
	@Test
	public void test08BumblebeeAlternoEsAtacadoPorEnemigoHumanoide(){
		Bumblebee.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		
		Algoformer bumblebee =Bumblebee.getBumblebee();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bumblebee, pos1);


		Megatron.getMegatron().cambiarModo();
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==340);
	}

	@Test
	public void test09BumblebeeAlternoAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==530);
		
	}
	
	@Test
	public void test10BumblebeeAlternoEsAtacadoPorEnemigoAlterno(){
		Bumblebee.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer bumblebee= Bumblebee.getBumblebee();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(bumblebee);
		
		Assert.assertTrue(bumblebee.getVida()==295);
	}

	

}
