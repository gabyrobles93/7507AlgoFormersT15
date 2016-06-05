package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;

import Modelo.BumblebeeHumanoide;
import Modelo.Casillero;
import Modelo.Juego;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Tablero;
import Modelo.movil;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;


public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = new BumblebeeHumanoide();
		Posicion unaPos=new Posicion(1,5);
		
		
		
		algoformer.mover(unaPos);
	
		
		
		Assert.assertTrue(algoformer.getPosicion()==unaPos);

	}

	@Test
	public void test03AutobotsEnEsquinaSuperiorIzquierda() {
		
		Juego juego = new Juego();
		
		Posicion posArranque=new Posicion(1,1);
		
		Tablero subtablero=juego.getTablero().getArea(posArranque, 1);
	
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getAlgoformer("optimus")));
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getAlgoformer("bumblebee")));
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getAlgoformer("ratchet")));
		
	}
	@Test
	public void test04DecepticonNaceEnEsquinaInferiorDerecha() {
		
		Juego juego = new Juego();
		Posicion posArranque=new Posicion(48,48);
	
		
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getAlgoformer("megatron")));
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getAlgoformer("frenzy")));
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getAlgoformer("bonecrusher")));
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
