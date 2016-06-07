package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;

public class MegatronAlternoTest {

	@Test
	public void test01MegatronAlternoAtacaEnemigoHumanoide(){
		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(3,3);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,6);
		optimus.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		//como optimus tiene vida 500 y megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02MegatronAlternoNoPuedeAtacarDecepticons(){
		
		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(3,3);
		megatron.setPosicion(pos1);
		Algoformer bone=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,5);
		bone.setPosicion(pos2);
		
		megatron.atacar(bone);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MegatronAlternoNoPuedeAtacarAutobotFueraDeRango(){

		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(2,0);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(6,0);
		optimus.setPosicion(pos2);
		
		megatron.atacar(optimus);
	}
	
	@Test
	public void test04CambioMegatronAModoAlterno(){
		
		Algoformer mega_hum=new MegatronHumanoide();
		Algoformer mega_alt=new MegatronAlterno();
		
		Assert.assertTrue(mega_hum.equals(mega_alt.cambiarModo()));
	}
		
	@Test
	public void test06MegatronAlternoSeMueve(){
		Algoformer mega = new MegatronAlterno();
		Posicion posIni=new Posicion(1,4);
		mega.setPosicion(posIni);
		Posicion posFin=new Posicion(1,5);
		
		mega.mover(posFin);
	
		Assert.assertTrue(mega.getPosicion()==posFin);
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MegatronAlternoTieneLimiteDeVelocidad(){
		Algoformer mega = new MegatronAlterno();
		Posicion posIni=new Posicion(1,4);
		mega.setPosicion(posIni);
		Posicion posFin=new Posicion(1,6);
		
		mega.mover(posFin);
	
	}
	
	@Test
	public void test08MegatronAlternoEsAtacadoPorEnemigoHumanoide(){
		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(2,2);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(2,4);
		optimus.setPosicion(pos2);
		
		optimus.atacar(megatron);
		
		//como megatron tiene vida 550 y optimus 50 de ataque le deben quedar 500
		Assert.assertTrue(megatron.getVida()==500);
	}
	
	@Test
	public void test09MegatronAlternoAtacaEnemigoAlterno(){
		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(3,3);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusAlterno();
		Posicion pos2=new Posicion(3,6);
		optimus.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		//como optimus tiene vida 500 y megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test
	public void test10MegatronAlternoEsAtacadoPorEnemigoAlterno(){
		Algoformer megatron=new MegatronAlterno();
		Posicion pos1=new Posicion(2,2);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusAlterno();
		Posicion pos2=new Posicion(4,4);
		optimus.setPosicion(pos2);
		
		optimus.atacar(megatron);
		
		//como megatron tiene vida 550 y optimus 15 de ataque le deben quedar 535
		Assert.assertTrue(megatron.getVida()==535);
	}
}
