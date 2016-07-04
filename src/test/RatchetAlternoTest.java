package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Ratchet;
import modelo.Tablero;

public class RatchetAlternoTest {
	
	
	@Test
	public void test01RatchetAlternoAtacaEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(ratchet,pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==515);
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02RatchetAlternoNoPuedeAtacarAutobots(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		ratchet.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03RatchetAlternoNoPuedeAtacarDecepticonFueraDeRango(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(ratchet, pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(5,0);
		tab.ubicarMovil(megatron, pos2);
		
		ratchet.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Ratchet.ResetearInstancia();
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Ratchet.getRatchet(), posIni);
		
	
		Assert.assertTrue( Ratchet.getRatchet().getDistanciaDeAtaque()==2);
		
		Ratchet mega1=Ratchet.getRatchet();
		
		Ratchet.getRatchet().cambiarModo();
		
		
		
		Assert.assertTrue(Ratchet.getRatchet().getDistanciaDeAtaque()==5);//en modo humanoide alcance==3
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06RatchetAlternoSeMueve(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer ratchet = Ratchet.getRatchet();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(9,4);
		
		ratchet.mover(posFin);
	
		Assert.assertTrue(ratchet.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07RatchetAlternoTieneLimiteDeVelocidad(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(10,4);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetAlternoEsAtacadoPorEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

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
	public void test09RatchetAlternoAtacaEnemigoAlterno(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==515);	
		
	}
	
	@Test
	public void test08RatchetAlternoEsAtacadoPorEnemigoAlterno(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
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
