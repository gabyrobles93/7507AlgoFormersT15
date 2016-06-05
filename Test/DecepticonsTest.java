package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Bonecrusher;
import Modelo.BonecrusherHumanoide;
import Modelo.Decepticons;
import Modelo.Frenzy;
import Modelo.FrenzyHumanoide;
import Modelo.Megatron;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;



public class DecepticonsTest {
	
	@Test
	public void test01ObtenerMegatronHumanoide(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons autobots=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==autobots.getMegatron());
		
	}
	
	@Test
	public void test01ObtenerMegatronAlterno(){
		Megatron mega=new MegatronAlterno();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons autobots=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==autobots.getMegatron());
		
	}

}
