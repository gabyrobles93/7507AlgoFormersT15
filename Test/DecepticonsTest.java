package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Bonecrusher;

import Modelo.Decepticons;
import Modelo.Frenzy;

import Modelo.Megatron;




public class DecepticonsTest {
	

	
	@Test
	public void test02ObtenerMegatron(){
		Megatron mega=Megatron.getMegatron();
		Bonecrusher bone=Bonecrusher.getBonecrusher();
		Frenzy freny=Frenzy.getFrenzy();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(mega==decepticons.getMegatron());
		
	}
	

	
	@Test
	public void test04ObtenerBonecrusher(){
		Megatron mega=Megatron.getMegatron();
		Bonecrusher bone= Bonecrusher.getBonecrusher();
		Frenzy freny=Frenzy.getFrenzy();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(bone==decepticons.getBonecrusher());
		
	}
	
	@Test
	public void test05ObtenerFrenzy(){
		Megatron mega=Megatron.getMegatron();
		Bonecrusher bone=Bonecrusher.getBonecrusher();
		Frenzy freny=Frenzy.getFrenzy();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		Assert.assertTrue(freny==decepticons.getFrenzy());
		
	}
	

	
	@Test
	public void test07DecepticonsComienzaConVidaTotalIgualASumatoriaDeVidasDeIntegrantes() {
		
		Megatron mega=Megatron.getMegatron();
		Bonecrusher bone=Bonecrusher.getBonecrusher();
		Frenzy freny=Frenzy.getFrenzy();

		Decepticons decepticons=new Decepticons(mega,bone,freny);
		
		int sumvidaintegrantes = decepticons.getMegatron().getVida()
								+ decepticons.getBonecrusher().getVida() 
								+ decepticons.getFrenzy().getVida();
		
		Assert.assertTrue(decepticons.getVidaTotal() == sumvidaintegrantes);
	}
}
