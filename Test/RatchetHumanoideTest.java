package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Posicion;

public class RatchetHumanoideTest {

	@Test
	public void test01RatchetHumanoideAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(ratchet,pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		megatron.setEquipo(decepticons);
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==545);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02RatchetHumanoideNoPuedeAtacarAutobots(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		
		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);	
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer bumblebee = new BumblebeeHumanoide();
		bumblebee.setEquipo(autobots);
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		ratchet.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03RatchetHumanoideNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		
		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron=new MegatronHumanoide();
		megatron.setEquipo(decepticons);
		Posicion pos2=new Posicion(8,0);
		tab.ubicarMovil(megatron, pos2);
		
		ratchet.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		
		Algoformer ratchet_hum=new RatchetHumanoide();
		Algoformer ratchet_alt=new RatchetAlterno();
		
		Assert.assertTrue(ratchet_alt.equals(ratchet_hum.cambiarModo()));
	}
		
	@Test
	public void test06RatchetHumanoideSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer ratchet = new RatchetHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(2,4);
		
		ratchet.mover(posFin);
	
		Assert.assertTrue(ratchet.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07RatchetHumanoideTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer ratchet = new RatchetHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(ratchet,posIni);
		Posicion posFin=new Posicion(3,4);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);


		Algoformer megatron = new MegatronHumanoide();
		megatron.setEquipo(decepticons);
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(ratchet);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(ratchet.getVida()==140);
	}


	@Test
	public void test09RatchetHumanoideAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==545);	
		
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer ratchet = new RatchetHumanoide();
		ratchet.setEquipo(autobots);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(ratchet, pos1);
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(ratchet);
		
		Assert.assertTrue(ratchet.getVida()==95);
	}
}
