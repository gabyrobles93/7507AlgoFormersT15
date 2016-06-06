package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.OptimusHumanoide;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.Posicion;

public class BonecrusherHumanoideTest {

	@Test
	public void test01BonecrusherHumanoideAtacaEnemigoHumanoide(){
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(3,3);
		bonecrusher.setPosicion(pos1);
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos2=new Posicion(3,6);
		bumblebee.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BonecrusherHumanoideNoPuedeAtacarDecepticons(){
		
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(3,3);
		bonecrusher.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,7);
		optimus.setPosicion(pos2);
		
		bonecrusher.atacar(optimus);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MeatronHumanoideNoPuedeAtacarAutobotFueraDeRango(){

		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(2,0);
		bonecrusher.setPosicion(pos1);
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos2=new Posicion(15,15);
		bumblebee.setPosicion(pos2);
		
		bonecrusher.atacar(bumblebee);
	}
	
	@Test
	public void test04CambioBonecrusherAModoAlterno(){
		
		Algoformer bone_hum=new BonecrusherHumanoide();
		Algoformer bone_alt=new BonecrusherAlterno();
		
		Assert.assertTrue(bone_alt.equals(bone_hum.cambiarModo()));
	}
		
	@Test
	public void test06BonecrusherHumanoideSeMueve(){
		Algoformer bone = new BonecrusherHumanoide();
		Posicion posIni=new Posicion(1,4);
		bone.setPosicion(posIni);
		Posicion posFin=new Posicion(1,5);
		
		bone.mover(posFin);
	
		Assert.assertTrue(bone.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BonecrusherHumanoideTieneLimiteDeVelocidad(){
		Algoformer bone = new BonecrusherHumanoide();
		Posicion posIni=new Posicion(1,4);
		bone.setPosicion(posIni);
		Posicion posFin=new Posicion(1,6);
		
		bone.mover(posFin);
	
	}
	
	@Test
	public void test08BonecrusherHumanoideEsAtacadoPorEnemigoHumanoide(){
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(2,2);
		bonecrusher.setPosicion(pos1);
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos2=new Posicion(2,3);
		bumblebee.setPosicion(pos2);
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
	}
	
	@Test
	public void test09BonecrusherHumanoideAtacaEnemigoAlterno(){
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(3,3);
		bonecrusher.setPosicion(pos1);
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos2=new Posicion(3,6);
		bumblebee.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
		
	}
	
	@Test
	public void test10BonecrusherHumanoideEsAtacadoPorEnemigoAlterno(){
		Algoformer bonecrusher=new BonecrusherHumanoide();
		Posicion pos1=new Posicion(2,2);
		bonecrusher.setPosicion(pos1);
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos2=new Posicion(5,2);
		bumblebee.setPosicion(pos2);
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 180
		Assert.assertTrue(bonecrusher.getVida()==180);
	}
	

	
}
