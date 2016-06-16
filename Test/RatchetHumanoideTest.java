package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Bumblebee;

import Modelo.Decepticons;

import Modelo.Movimiento;

import Modelo.Tablero;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Megatron;
import Modelo.Posicion;
import Modelo.Ratchet;

public class RatchetHumanoideTest {

	@Test
	public void test01RatchetHumanoideAtacaEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(ratchet,pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
			
		

	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02RatchetHumanoideNoPuedeAtacarAutobots(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(ratchet, pos1);
		 Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		ratchet.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03RatchetHumanoideNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(ratchet, pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(8,0);
		tab.ubicarMovil(megatron, pos2);
		
		ratchet.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		Ratchet.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Ratchet.getRatchet().cambiarModo();
		
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Ratchet.getRatchet(), posIni);
		
	
		Assert.assertTrue( Ratchet.getRatchet().getDistanciaDeAtaque()==5);
		
		Ratchet mega1=Ratchet.getRatchet();
		
		Ratchet.getRatchet().cambiarModo();
		
		
		
		Assert.assertTrue(Ratchet.getRatchet().getDistanciaDeAtaque()==2);//en modo humanoide alcance==3
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06RatchetHumanoideSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(2,4);
		
		ratchet.mover(posFin);
	
		Assert.assertTrue(ratchet.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07RatchetHumanoideTieneLimiteDeVelocidad(){
		Ratchet.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(3,4);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);

		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(ratchet);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(ratchet.getVida()==140);
	}


	@Test
	public void test09RatchetHumanoideAtacaEnemigoAlterno(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==545);	
		
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		 Ratchet.getRatchet().cambiarModo();
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(ratchet);
		
		Assert.assertTrue(ratchet.getVida()==95);
	}
}
