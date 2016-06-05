package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Bonecrusher;
import Modelo.BonecrusherAlterno;
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
	public void test02ObtenerMegatronAlterno(){
		Megatron mega=new MegatronAlterno();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons autobots=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==autobots.getMegatron());
		
	}
	
	@Test
	public void test03ObtenerBonecrusherHumanoide(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons autobots=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(bone==autobots.getBonecrusher());
		
	}
	
	@Test
	public void test04ObtenerBonecrusherAlterno(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherAlterno();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons autobots=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(bone==autobots.getBonecrusher());
		
	}
}
