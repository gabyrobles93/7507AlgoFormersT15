package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Area;
import Modelo.BumblebeeHumanoide;
import Modelo.Casillero;
import Modelo.Juego;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.TableroTierra;

public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = new BumblebeeHumanoide();
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
		
		Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus").getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee").getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet").getPosicion().estaIncluidoEnArea(area));

	}
	
	@Test
	public void test03decepticonNaceEnAreaDeterminada() {
		
		Juego juego = new Juego();
		Area area = new Area();
		
		area = juego.getDecepticons().getAreaNacimiento();
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy").getPosicion().estaIncluidoEnArea(area));
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher").getPosicion().estaIncluidoEnArea(area));

	}
	@Test
	public void test04CambioAlgoformerDeModo(){
		Algoformer megatron=new MegatronHumanoide();
		megatron=megatron.cambiarModo();
		Assert.assertTrue(megatron instanceof MegatronAlterno);
	}
	



}
