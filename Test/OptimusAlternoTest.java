package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetHumanoide;

public class OptimusAlternoTest {
	
	@Test
	public void test01OptimusAlternoAtacaEnemigoHumanoide(){
		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(5,5);
		megatron.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		//como Megatron tiene vida 550 y Optimus 15 de ataque le deben quedar 535
		Assert.assertTrue(megatron.getVida()==535);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02OptimusAlternoNoPuedeAtacarAutobots(){
		
		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer ratchet=new RatchetHumanoide();
		Posicion pos2=new Posicion(3,4);
		ratchet.setPosicion(pos2);
		
		optimus.atacar(ratchet);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03OptimusAlternoNoPuedeAtacarDecepticonFueraDeRango(){

		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(2,0);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(5,3);
		megatron.setPosicion(pos2);
		
		optimus.atacar(megatron);
		
	}
	
	@Test
	public void test04CambioOptimusAModoAlterno(){
		
		Algoformer optimus_alt=new OptimusAlterno();
		Algoformer optimus_hum=new OptimusHumanoide();
		
		Assert.assertTrue(optimus_hum.equals(optimus_alt.cambiarModo()));
	}
		
	@Test
	public void test06OptimusAlternoSeMueve(){
		Algoformer optimus = new OptimusAlterno();
		Posicion posIni=new Posicion(2,2);
		optimus.setPosicion(posIni);
		Posicion posFin=new Posicion(2,7);
		
		optimus.mover(posFin);
	
		Assert.assertTrue(optimus.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07OptimusAlternoTieneLimiteDeVelocidad(){
		Algoformer optimus = new OptimusAlterno();
		Posicion posIni=new Posicion(2,2);
		optimus.setPosicion(posIni);
		Posicion posFin=new Posicion(5,5);
		
		optimus.mover(posFin);
	
	}
	
	@Test
	public void test08OptimusAlternoEsAtacadoPorEnemigoHumanoide(){
		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(2,2);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(2,5);
		megatron.setPosicion(pos2);
		
		megatron.atacar(optimus);
		
		//como Optimus tiene vida 500 y Megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
	}
	
	@Test
	public void test09OptimusAlternoAtacaEnemigoAlterno(){
		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(3,3);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronAlterno();
		Posicion pos2=new Posicion(5,5);
		megatron.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		//como Megatron tiene vida 550 y Optimus 15 de ataque le deben quedar 535
		Assert.assertTrue(megatron.getVida()==535);
		
	}
	
	@Test
	public void test10OptimusAlternoEsAtacadoPorEnemigoAlterno(){
		Algoformer optimus=new OptimusAlterno();
		Posicion pos1=new Posicion(2,2);
		optimus.setPosicion(pos1);
		Algoformer megatron=new MegatronAlterno();
		Posicion pos2=new Posicion(2,4);
		megatron.setPosicion(pos2);
		
		megatron.atacar(optimus);
		
		//como Optimus tiene vida 500 y Megatron 55 de ataque le deben quedar 445
		Assert.assertTrue(optimus.getVida()==455);
	}
	

}
