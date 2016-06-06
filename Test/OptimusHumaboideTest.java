package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetHumanoide;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;

public class OptimusHumaboideTest {

	@Test
	public void test01OptimusHumanoideAtacaEnemigoHumanoide(){
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(3,5);
		megatron.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		//como Megatron tiene vida 550 y Optimus 50 de ataque le deben quedar 500
		Assert.assertTrue(megatron.getVida()==500);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02OptimusHumanoideNoPuedeAtacarDecepticons(){
		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos2=new Posicion(3,4);
		ratchet.setPosicion(pos2);
		
		optimus.atacar(ratchet);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MeatronHumanoideNoPuedeAtacarAutobotFueraDeRango(){

		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(2,0);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(2,5);
		megatron.setPosicion(pos2);
		
		optimus.atacar(megatron);
		
	}
	
	@Test
	public void test04CambioOptimusAModoAlterno(){
		
		Algoformer optimus_hum=new OptimusHumanoide();
		Algoformer optimus_alt=new OptimusAlterno();
		
		Assert.assertTrue(optimus_alt.equals(optimus_hum.cambiarModo()));
	}
		
	@Test
	public void test06OptimusHumanoideSeMueve(){
		Algoformer optimus = new OptimusHumanoide();
		Posicion posIni=new Posicion(2,2);
		optimus.setPosicion(posIni);
		Posicion posFin=new Posicion(2,4);
		
		optimus.mover(posFin);
	
		Assert.assertTrue(optimus.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07OptimusHumanoideTieneLimiteDeVelocidad(){
		Algoformer optimus = new OptimusHumanoide();
		Posicion posIni=new Posicion(2,2);
		optimus.setPosicion(posIni);
		Posicion posFin=new Posicion(2,5);
		
		optimus.mover(posFin);
	
	}
	
	@Test
	public void test08OptimusHumanoideEsAtacadoPorEnemigoHumanoide(){
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(2,2);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(4,4);
		megatron.setPosicion(pos2);
		
		megatron.atacar(optimus);
		
		//como Optimus tiene vida 500 y Megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
	}
	
	@Test
	public void test09OptimusHumanoideAtacaEnemigoAlterno(){
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronAlterno();
		Posicion pos2=new Posicion(3,5);
		megatron.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		//como Megatron tiene vida 550 y Optimus 50 de ataque le deben quedar 500
		Assert.assertTrue(megatron.getVida()==500);
		
	}
	
	@Test
	public void test10OptimusHumanoideEsAtacadoPorEnemigoAlterno(){
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos1=new Posicion(2,2);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronAlterno();
		Posicion pos2=new Posicion(4,4);
		megatron.setPosicion(pos2);
		
		megatron.atacar(optimus);
		
		//como Optimus tiene vida 500 y Megatron 55 de ataque le deben quedar 445
		Assert.assertTrue(optimus.getVida()==455);
	}
	
}
	
	
