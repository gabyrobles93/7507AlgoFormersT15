package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Area;
import Modelo.Casillero;
import Modelo.Juego;
import Modelo.TableroTierra;

public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = new Algoformer();
		int fila=5;
		int col=10;
		
		algoformer.setFila(fila);
		algoformer.setColumna(col);
		
		
		Assert.assertTrue((algoformer.getFila()==fila)&&(algoformer.getColumna()==col));

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
	



}
