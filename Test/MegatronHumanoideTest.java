package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;

public class MegatronHumanoideTest{
	
	@Test
	public void test01MegatronAtacaEnemigo(){
		Algoformer megatron=new MegatronHumanoide();
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
	public void test02MegatronNoPuedeAtacarDecepticons(){
		
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(3,3);
		megatron.setPosicion(pos1);
		Algoformer bone=new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,5);
		bone.setPosicion(pos2);
		
		megatron.atacar(bone);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MeatronNoPuedeAtacarAutobotFueraDeRango(){

		Algoformer megatron=new MegatronHumanoide();
		Posicion pos1=new Posicion(2,0);
		megatron.setPosicion(pos1);
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(15,15);
		optimus.setPosicion(pos2);
		
		megatron.atacar(optimus);
		
		//como optimus tiene vida 500 y megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
	}
	
	@Test
	public void test04CambioMegatronDeHumanoideAAlterno(){
		
		Algoformer mega_hum=new MegatronHumanoide();
		Algoformer mega_alt=new MegatronAlterno();
		
		Assert.assertTrue(mega_alt.equals(mega_hum.cambiarModo()));
	}
	
	@Test
	public void test05CambioMegatronDeAlternoAHumanoide(){
		
		Algoformer mega_hum=new MegatronHumanoide();
		Algoformer mega_alt=new MegatronAlterno();
		
		Assert.assertTrue(mega_hum.equals(mega_alt.cambiarModo()));
	}
	
	@Test
	public void test06MegatronSeMueve(){
		Algoformer mega = new MegatronHumanoide();
		
		Posicion unaPos=new Posicion(1,5);
		
		
		
		algoformer.mover(unaPos);
	
		
		
		Assert.assertTrue(algoformer.getPosicion()==unaPos);
	
	}
	
	

	

}
