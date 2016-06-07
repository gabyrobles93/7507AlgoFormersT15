package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;

public class BumblebeeAlternoTest {

	@Test
	public void test01BumblebeeAlternoAtacaEnemigoHumanoide(){
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,6);
		bonecrusher.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==180);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BumblebeeAlternoNoPuedeAtacarAutobots(){
		
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,4);
		optimus.setPosicion(pos2);
		
		bumblebee.atacar(optimus);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BumblebeeAlternoNoPuedeAtacarDecepticonFueraDeRango(){

		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos1=new Posicion(2,0);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(2,4);
		bonecrusher.setPosicion(pos2);
		
		bumblebee.atacar(bonecrusher);
		
	}
	
	@Test
	public void test04CambioBumblebeeAModoAlterno(){
		
		Algoformer bumble_hum=new BumblebeeHumanoide();
		Algoformer bumble_alt=new BumblebeeAlterno();
		
		Assert.assertTrue(bumble_hum.equals(bumble_alt.cambiarModo()));
	}
		
	@Test
	public void test06BumblebeeAlternoSeMueve(){
		Algoformer bumble = new BumblebeeAlterno();
		Posicion posIni=new Posicion(1,4);
		bumble.setPosicion(posIni);
		Posicion posFin=new Posicion(6,4);
		
		bumble.mover(posFin);
	
		Assert.assertTrue(bumble.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BumblebeeAlternoTieneLimiteDeVelocidad(){
		Algoformer bumble = new BumblebeeAlterno();
		Posicion posIni=new Posicion(1,4);
		bumble.setPosicion(posIni);
		Posicion posFin=new Posicion(4,7);
		
		bumble.mover(posFin);
	
	}
	
	@Test
	public void test08BumblebeeAlternoEsAtacadoPorEnemigoHumanoide(){
		Algoformer bumblebee=new BumblebeeAlterno();
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
	public void test09BumblebeeAlternoAtacaEnemigoAlterno(){
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos1=new Posicion(3,3);
		bumblebee.setPosicion(pos1);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos2=new Posicion(3,6);
		bonecrusher.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 180
		Assert.assertTrue(bonecrusher.getVida()==180);
		
	}
	
	@Test
	public void test10BumblebeeAlternoEsAtacadoPorEnemigoAlterno(){
		Algoformer bumblebee=new BumblebeeAlterno();
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
