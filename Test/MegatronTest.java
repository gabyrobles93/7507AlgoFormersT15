package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.MegatronHumanoide;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;

public class MegatronTest{
	
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
	public void test10MeatronNoPuedeAtacarAutobotFueraDeRango(){

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

}
