package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Autobots;
import Modelo.Bonecrusher;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.Bumblebee;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.Frenzy;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.Megatron;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Optimus;
import Modelo.OptimusHumanoide;
import Modelo.Ratchet;
import Modelo.RatchetHumanoide;



public class DecepticonsTest {
	
	@Test
	public void test01ObtenerMegatronHumanoide(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==decepticons.getMegatron());
		
	}
	
	@Test
	public void test02ObtenerMegatronAlterno(){
		Megatron mega=new MegatronAlterno();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==decepticons.getMegatron());
		
	}
	
	@Test
	public void test03ObtenerBonecrusherHumanoide(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(bone==decepticons.getBonecrusher());
		
	}
	
	@Test
	public void test04ObtenerBonecrusherAlterno(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherAlterno();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(bone==decepticons.getBonecrusher());
		
	}
	
	@Test
	public void test05ObtenerFrenzyHumanoide(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(freny==decepticons.getFrenzy());
		
	}
	
	@Test
	public void test06ObtenerFrenzyAlterno(){
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyAlterno();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(freny==decepticons.getFrenzy());
		
	}
	
	@Test
	public void test07DecepticonsComienzaConVidaTotalIgualASumatoriaDeVidasDeIntegrantes() {
		
		Megatron mega=new MegatronHumanoide();
		Bonecrusher bone=new BonecrusherHumanoide();
		Frenzy freny=new FrenzyHumanoide();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		int sumvidaintegrantes = decepticons.getMegatron().getVida()
								+ decepticons.getBonecrusher().getVida() 
								+ decepticons.getFrenzy().getVida();
		
		Assert.assertTrue(decepticons.getVidaTotal() == sumvidaintegrantes);
	}
}
