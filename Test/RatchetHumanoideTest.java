package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.FrenzyHumanoide;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.FrenzyAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;

public class RatchetHumanoideTest {

	@Test
	public void test01RatchetHumanoideAtacaEnemigoHumanoide(){
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(3,3);
		ratchet.setPosicion(pos1);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos2=new Posicion(8,3);
		frenzy.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(frenzy);
		
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(frenzy.getVida()==395);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02RatchetHumanoideNoPuedeAtacarAutobots(){
		
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(3,3);
		ratchet.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,4);
		optimus.setPosicion(pos2);
		
		ratchet.atacar(optimus);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03RatchetHumanoideNoPuedeAtacarDecepticonFueraDeRango(){

		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(2,0);
		ratchet.setPosicion(pos1);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos2=new Posicion(5,3);
		frenzy.setPosicion(pos2);
		
		ratchet.atacar(frenzy);
		
	}
	
	@Test
	public void test04CambioRatchetAModoAlterno(){
		
		Algoformer ratchet_hum=new RatchetHumanoide();
		Algoformer ratchet_alt=new RatchetAlterno();
		
		Assert.assertTrue(ratchet_alt.equals(ratchet_hum.cambiarModo()));
	}
		
	@Test
	public void test06RatchetHumanoideSeMueve(){
		Algoformer ratchet = new RatchetHumanoide();
		Posicion posIni=new Posicion(2,2);
		ratchet.setPosicion(posIni);
		Posicion posFin=new Posicion(2,3);
		
		ratchet.mover(posFin);
	
		Assert.assertTrue(ratchet.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07RatchetHumanoideTieneLimiteDeVelocidad(){
		Algoformer ratchet = new RatchetHumanoide();
		Posicion posIni=new Posicion(2,4);
		ratchet.setPosicion(posIni);
		Posicion posFin=new Posicion(2,6);
		
		ratchet.mover(posFin);
	
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoHumanoide(){
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(2,2);
		ratchet.setPosicion(pos1);
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos2=new Posicion(4,4);
		frenzy.setPosicion(pos2);
		
		frenzy.atacar(ratchet);
		
		//como Ratchet tiene vida 150 y Frenzy 10 de ataque le deben quedar 140
		Assert.assertTrue(ratchet.getVida()==140);
	}


	@Test
	public void test09RatchetHumanoideAtacaEnemigoAlterno(){
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(3,3);
		ratchet.setPosicion(pos1);
		Algoformer frenzy=new FrenzyAlterno();
		Posicion pos2=new Posicion(8,3);
		frenzy.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		ratchet.atacar(frenzy);
		
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(frenzy.getVida()==395);
		
	}
	
	@Test
	public void test08RatchetHumanoideEsAtacadoPorEnemigoAlterno(){
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos1=new Posicion(2,2);
		ratchet.setPosicion(pos1);
		Algoformer frenzy=new FrenzyAlterno();
		Posicion pos2=new Posicion(2,4);
		frenzy.setPosicion(pos2);
		
		frenzy.atacar(ratchet);
		
		//como Ratchet tiene vida 150 y Frenzy 25 de ataque le deben quedar 125
		Assert.assertTrue(ratchet.getVida()==125);
	}
}
