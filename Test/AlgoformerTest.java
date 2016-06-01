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
import Modelo.Tablero;
=======
import Modelo.OptimusHumanoide;
>>>>>>> 0e13acb5afddfa127ebc6f278fb4c42c80b1c3d7


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
	public void test03AutobotsEnEsquinaSuperiorIzquierda() {
		
		Juego juego = new Juego();
	Tablero subtablero=juego.getTablero().getArea(1, 1, 1);
	
		Assert.assertTrue(subtablero.existeAlgoformer(juego.getAutobots().getAlgoformer("optimus")));
		Assert.assertTrue(subtablero.existeAlgoformer(juego.getAutobots().getAlgoformer("bumblebee")));
		Assert.assertTrue(subtablero.existeAlgoformer(juego.getAutobots().getAlgoformer("ratchet")));
		
	}
	@Test
	public void test04DecepticonNaceEnEsquinaInferiorDerecha() {
		
		Juego juego = new Juego();
	
		
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getDecepticons().getAlgoformer("megatron")));
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getDecepticons().getAlgoformer("frenzy")));
		Assert.assertTrue(juego.getTablero().getArea(48, 48, 1).existeAlgoformer(juego.getDecepticons().getAlgoformer("bonecrusher")));
	}
	@Test
	public void test04CambioAlgoformerDeModo(){
		
		Algoformer megatron=new MegatronHumanoide();
		
		megatron=megatron.cambiarModo();
		
		Assert.assertTrue(megatron instanceof MegatronAlterno);
	}
	
	
	@Test
	public void test05AtacarEnemigo(){
		
		Algoformer megatron=new MegatronHumanoide();
		Algoformer optimus=new OptimusHumanoide();
		
		optimus.atacar(megatron);
		
		//como megatron tiene vida 550 y optimus ataque 50 deberian quedarle 500
		Assert.assertTrue(megatron.getVida()==500);
	}



}
