package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.MegatronHumanoide;
import Modelo.OptimusHumanoide;

public class MegatronTest{
	
	@Test
	public void test01MegatronAtacaEnemigo(){
		Algoformer megatron=new MegatronHumanoide();
		Algoformer optimus=new OptimusHumanoide();
		
		megatron.atacar(optimus);
		
		//como optimus tiene vida 500 y megatron 10 de ataque le deben quedar 490
		Assert.assertTrue(optimus.getVida()==490);
		
	}

}
