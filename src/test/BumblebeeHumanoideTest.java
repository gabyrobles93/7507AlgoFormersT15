package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bonecrusher;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.Equipo;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Juego;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Posicion;
import modelo.Ratchet;
import modelo.Tablero;

public class BumblebeeHumanoideTest {
	
	@Test
	public void test01BumblebeeHumanoideAtacaEnemigoHumanoide(){
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		Bonecrusher.ResetearInstancia();
		Equipo decepticons=new Decepticons();
		Bonecrusher.getBonecrusher().setEquipo(decepticons);
		
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Bumblebee.getBumblebee().cambiarModo();//lo pongo en alterno
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(bumblebee,pos1);
		
		Algoformer bonecrusher= Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(3,4);
		tab.ubicarMovil(bonecrusher,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BumblebeeHumanoideNoPuedeAtacarAutobots(){
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		Ratchet.ResetearInstancia();
		Ratchet.getRatchet().setEquipo(autobots);
	
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos2=new Posicion(3,4);
		tab.ubicarMovil(ratchet, pos2);
		
		bumblebee.atacar(ratchet);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BumblebeeHumanoideNoPuedeAtacarDecepticonFueraDeRango(){
		Bumblebee.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bumblebee= Bumblebee.getBumblebee();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(megatron, pos2);
		
		bumblebee.atacar(megatron);
		
	}
	
	@Test
	public void test04CambioBumblebeeAModoAlterno(){
		
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Megatron.getMegatron(), posIni);
		
	
		Assert.assertTrue(Bumblebee.getBumblebee().getDistanciaDeAtaque()==3);
		
		Bumblebee bone1=Bumblebee.getBumblebee();
		
		Bumblebee.getBumblebee().cambiarModo();
		
		
		
		Assert.assertTrue(Bumblebee.getBumblebee().getDistanciaDeAtaque()==1);//en modo humanoide alcance cambia
		
		Bumblebee.getBumblebee().cambiarModo();
		Assert.assertTrue(Bumblebee.getBumblebee().getDistanciaDeAtaque()==3);
		
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06BumblebeeHumanoideSeMueve(){
		Bumblebee.ResetearInstancia();
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bumblebee,posIni);
		Posicion posFin=new Posicion(1,6);
		
		bumblebee.mover(posFin);
	
		Assert.assertTrue(bumblebee.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BumblebeeHumanoideTieneLimiteDeVelocidad(){
		Bumblebee.ResetearInstancia();
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bumblebee,posIni);
		Posicion posFin=new Posicion(9,4);
		
		bumblebee.mover(posFin);
	
	}
	
	@Test
	public void test08BumblebeeHumanoideEsAtacadoPorEnemigoHumanoide(){
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		Megatron.ResetearInstancia();
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Megatron.getMegatron().cambiarModo();
		Bumblebee.getBumblebee().cambiarModo();
		
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bumblebee, pos1);


		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==340);
	}

	@Test
	public void test09BumblebeeHumanoideAtacaEnemigoAlterno(){
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		Megatron.ResetearInstancia();
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Bumblebee.getBumblebee().cambiarModo();//cambio a hum
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion pos1=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos1);
		
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==510);		
	}
	
	@Test
	public void test10BumblebeeHumanoideEsAtacadoPorEnemigoAlterno(){
		Bumblebee.ResetearInstancia();
		Equipo autobots=new Autobots();
		Bumblebee.getBumblebee().setEquipo(autobots);
		Megatron.ResetearInstancia();
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		
		
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
