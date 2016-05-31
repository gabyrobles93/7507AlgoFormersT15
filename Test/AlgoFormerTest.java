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
<<<<<<< HEAD
=======

>>>>>>> 60355e7f920c66b25ffb717cd0ab03cbd15f1e69

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
	public void test02autobotNaceEnEsquinaInferiorDerecha() {
		
		Juego juego = new Juego();
	
		
		
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("optimus")));
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("bumblebee")));
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("ratchet")));
	}
	@Test
	public void test03DecepticonNaceEnEsquinaSuperiorIzquierda() {
		
		Juego juego = new Juego();
	
		
		
		Assert.assertTrue(juego.getTablero().getArea(1, 1, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("megatron")));
		Assert.assertTrue(juego.getTablero().getArea(1, 1, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("frenzy")));
		Assert.assertTrue(juego.getTablero().getArea(1, 1, 1).existeAlgoformer(juego.getAutobots().getAlgoformer("bonecrusher")));
	}
	
	@Test
	public void test04CambioAlgoformerDeModo(){
		Algoformer megatron=new MegatronHumanoide();
		megatron=megatron.cambiarModo();
		Assert.assertTrue(megatron instanceof MegatronAlterno);
	}
	



}