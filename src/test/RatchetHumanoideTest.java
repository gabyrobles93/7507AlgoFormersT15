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
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Posicion;
import modelo.Ratchet;
import modelo.Tablero;

public class RatchetHumanoideTest {

	@Test
	public void test01RatchetHumanoideAtacaEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
		
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
		Ratchet.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		
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
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
		Ratchet.getRatchet().cambiarModo();
		Algoformer ratchet = Ratchet.getRatchet();
		
		
		Posicion pos1 = new Posicion(3,0);
		tab.ubicarMovil(ratchet, pos1);
		
		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(9,0);
		tab.ubicarMovil(megatron, pos2);
		
		ratchet.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		Ratchet.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		

		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
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
		Ratchet.ResetearInstancia();
		
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
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
		
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		Ratchet.getRatchet().cambiarModo();
		
		Algoformer ratchet = Ratchet.getRatchet();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(3,4);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoHumanoide(){
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
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
		Posicion.setTablero(tab);
		
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Ratchet.getRatchet().setEquipo(autobots);
		
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
		Ratchet.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		
		
		 Equipo decepticons=new Decepticons();
			Megatron.getMegatron().setEquipo(decepticons);
			Equipo autobots=new Autobots();
			Ratchet.getRatchet().setEquipo(autobots);
			
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
