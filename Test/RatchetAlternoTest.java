package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;

public class RatchetAlternoTest {
	
	
	@Test
	public void test01RatchetAlternoAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = new RatchetAlterno();
		/*ratchet.setEquipo(autobots);*/
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(ratchet,pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		/*megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==515);
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02RatchetAlternoNoPuedeAtacarAutobots(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		
		Algoformer ratchet = new RatchetAlterno();
		/*ratchet.setEquipo(autobots);*/	
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer bumblebee = new BumblebeeHumanoide();
		/*bumblebee.setEquipo(autobots);*/
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		ratchet.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03RatchetAlternoNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		
		Algoformer ratchet = new RatchetAlterno();
		/*ratchet.setEquipo(autobots);*/
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		/*megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(5,0);
		tab.ubicarMovil(megatron, pos2);
		
		ratchet.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		
		Algoformer ratchet_hum=new RatchetHumanoide();
		Algoformer ratchet_alt=new RatchetAlterno();
		
		Assert.assertTrue(ratchet_hum.equals(ratchet_alt.cambiarModo()));
	}
		
	@Test
	public void test06RatchetAlternoSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer ratchet = new RatchetAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(9,4);
		
		ratchet.mover(posFin);
	
		Assert.assertTrue(ratchet.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07RatchetAlternoTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer ratchet = new RatchetAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(10,4);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetAlternoEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer ratchet = new RatchetAlterno();
	/*	ratchet.setEquipo(autobots);*/
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);


		Algoformer megatron = new MegatronHumanoide();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(ratchet);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(ratchet.getVida()==140);
	}


	@Test
	public void test09RatchetAlternoAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = new RatchetAlterno();
		/*ratchet.setEquipo(autobots);*/
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = new MegatronAlterno();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==515);	
		
	}
	
	@Test
	public void test08RatchetAlternoEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer ratchet = new RatchetAlterno();
	/*	ratchet.setEquipo(autobots);*/
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = new MegatronAlterno();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(ratchet);
		
		Assert.assertTrue(ratchet.getVida()==95);
	}

}
