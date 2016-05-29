package test;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = new Algoformer();
		Casillero casillero = new Casillero();
		
		casillero.setPosicion(5,9);
		
		algoformer.setPosicion(casillero);
		
		Assert.assertTrue(algoformer.getPosicion() == casillero.getPosicion());

	}
	
	@Test
	public void test02autobotNaceEnAreaDeterminada() {
		
		Juego juego = new Juego();
		Area area = new Area();
		
		area = juego.getAutobots().getAreaNacimiento();
		
		Assert.assertTrue(juego.getAutobots().getAlgoformer(1).getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getAutobots().getAlgoformer(2).getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getAutobots().getAlgoformer(3).getPosicion().estaIncluidoEnArea(area));

	}
	
	@Test
	public void test03decepticonNaceEnAreaDeterminada() {
		
		Juego juego = new Juego();
		Area area = new Area();
		
		area = juego.getDecepticons().getAreaNacimiento();
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(1).getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(2).getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(3).getPosicion().estaIncluidoEnArea(area));

	}
	
	@Test
	public void test04dosAlgoformersNoPuedenEstarEnLaMismaPosicion() {
		
		Juego juego = new Juego();
		Casillero casillero1 = new Casillero();
		
		casillero1.setPosicion(15,19);
		
	/*	juego.getDecepticons().setPosicion(casillero1);*/

	}
	


}
