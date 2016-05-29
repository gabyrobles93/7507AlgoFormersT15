package test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Casillero;
import Modelo.Juego;
import Modelo.TableroTierra;

public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = new Algoformer();
		int[] coordenada=new int[2];
		
		
		algoformer.setPosicion(coordenada);
		
		Assert.assertTrue(algoformer.getPosicion() == coordenada);

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
		
		TableroTierra tablero = new TableroTierra();
		int[] coordenanda=new int[2];
		Algoformer algof1=new Algoformer();
		Algoformer algof2=new Algoformer();
		
		//prueba no terminadaaaaa
		
		
	/*	juego.getDecepticons().setPosicion(casillero1);*/

	}
	


}
