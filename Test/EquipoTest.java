package test;

import org.junit.Assert;
import org.junit.Test;

public class EquipoTest {

	@Test
	public void test01elEquipoComienzaConTresMiembrosVivos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 3);
		
		Assert.assertFalse(juego.getDecepticons().getCantidadMiembrosVivos() == 3);
	}
	
	@Test
	public void test02losEquiposComienzanSinLaChispaDelPoder() {
		
		Juego juego = new Juego();
		
		Assert.assertFalse(juego.tieneChispaDelPoder());
		
		Assert.assertFalse(juego.tieneChispaDelPoder());
	}
	
	@Test
	public void test03elEquipoGanaAlCapturarChispaDelPoder() {
		
		Juego juego = new Juego();
		
		juego.getAutobots().tieneChispaDelPoder = true;
		
		Assert.assertTrue(juego.getGanador() == juego.getAutobots());
		
		Assert.assertFalse(juego.getGanador() == juego.getDecepticons());
	}

	@Test
	public void test04elEquipoPierdeAlPerderSuVidaTotal() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getGanador() != juego.getAutobots());
		
		Assert.assertTrue(juego.getGanador() != juego.getDecepticons());
		
		juego.getAutobots().vidatotal = 0;
		
		Assert.assertTrue(juego.getGanador() != juego.getAutobots());
		
		Assert.assertTrue(juego.getGanador() == juego.getDecepticons());
		
	}
	
	@Test
	public void test05elEquipoQuePierdeNoTieneMiembrosVivos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 3);
		
		juego.getAutobots().vidatotal = 0;
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 0);
		
	}
	
	@Test
	public void test06autobotsComienzaConOptimusBumblebeeRatchet() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getAlgoformer(1) instanceof Optimus);
		Assert.assertTrue(juego.getAutobots().getAlgoformer(2) instanceof Bumblebee);
		Assert.assertTrue(juego.getAutobots().getAlgoformer(3) instanceof Ratchet);
		
	}
	
	
	@Test
	public void test07decepticonsComienzaConMegatronBonecrusherFrenzy() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(1) instanceof Megatron);
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(2) instanceof Bonecrusher);
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(3) instanceof Frenzy);
		
	}
	
	

}
