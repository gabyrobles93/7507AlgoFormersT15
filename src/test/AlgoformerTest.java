package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Bumblebee;
import modelo.Juego;
import modelo.Posicion;
import modelo.Tablero;


public class AlgoformerTest {
	
	@Test
	public void test01unAlgoformerTieneUnaPosicion() {
		
		Algoformer algoformer = Bumblebee.getBumblebee();
		Posicion unaPos=new Posicion(1,5);
				
		algoformer.cambiarPosicion(unaPos);
		
		Assert.assertTrue(algoformer.getPosicion()==unaPos);

	}

	@Test
	public void test03AutobotsEnEsquinaSuperiorIzquierda() {
		
		Juego juego = new Juego();
		
		Posicion posArranque=new Posicion(1,1);
		
		Tablero subtablero=juego.getTablero().getArea(posArranque, 1);
	
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getOptimus()));
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getBumblebee()));
		Assert.assertTrue(subtablero.existeMovil(juego.getAutobots().getRatchet()));
		
	}
	@Test
	public void test04DecepticonNaceEnEsquinaInferiorDerecha() {
		
		Juego juego = new Juego();
		Posicion posArranque=new Posicion(48,48);
	
		
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getMegatron()));
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getFrenzy()));
		Assert.assertTrue(juego.getTablero().getArea(posArranque, 1).existeMovil(juego.getDecepticons().getBonecrusher()));
	}

	




}
