package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.OptimusHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.BonecrusherHumanoide;
import Modelo.Posicion;

public class BumblebeeHumanoideTest {
	
	@Test
	public void test01BumblebeeHumanoideAtacaEnemigoHumanoide(){
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,4);
		bonecrusher.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BumblebeeHumanoideNoPuedeAtacarAutobots(){
		
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,4);
		optimus.setPosicion(pos2);
		
		bumblebee.atacar(optimus);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BumblebeeHumanoideNoPuedeAtacarDecepticonFueraDeRango(){

		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(2,0);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(2,2);
		bonecrusher.setPosicion(pos2);
		
		bumblebee.atacar(bonecrusher);
		
	}
	
	@Test
	public void test04CambioBumblebeeAModoAlterno(){
		
		Algoformer bumble_hum=new BumblebeeHumanoide();
		Algoformer bumble_alt=new BumblebeeAlterno();
		
		Assert.assertTrue(bumble_alt.equals(bumble_hum.cambiarModo()));
	}
		
	@Test
	public void test06BumblebeeHumanoideSeMueve(){
		Algoformer bumble = new BumblebeeHumanoide();
		Posicion posIni=new Posicion(1,4);
		bumble.setPosicion(posIni);
		Posicion posFin=new Posicion(3,4);
		
		bumble.mover(posFin);
	
		Assert.assertTrue(bumble.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BumblebeeHumanoideTieneLimiteDeVelocidad(){
		Algoformer bumble = new BumblebeeHumanoide();
		Posicion posIni=new Posicion(1,4);
		bumble.setPosicion(posIni);
		Posicion posFin=new Posicion(1,7);
		
		bumble.mover(posFin);
	
	}
	
	@Test
	public void test08BumblebeeHumanoideEsAtacadoPorEnemigoHumanoide(){
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(2,2);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(2,5);
		bonecrusher.setPosicion(pos2);
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
	}

	@Test
	public void test09BumblebeeHumanoideAtacaEnemigoAlterno(){
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos2=new Posicion(3,4);
		bonecrusher.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
		
	}
	
	@Test
	public void test10BumblebeeHumanoideEsAtacadoPorEnemigoAlterno(){
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos1=new Posicion(2,2);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos2=new Posicion(2,5);
		bonecrusher.setPosicion(pos2);
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
	}

}
