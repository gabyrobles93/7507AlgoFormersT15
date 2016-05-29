package test;

import org.junit.Assert;
import org.junit.Test;


public class TableroTest {

	@Test
	public void test01elTableroEstaCompuestoPorCasilleros() {
		
		Tablero tablero = new Tablero();
		
		Assert.assertTrue(tablero.getCasillero(25,25) instanceof Casillero);

	}
	
	@Test
	public void test02elTableroDeUnJuegoTiene50Filas() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTablero().getCantidadFilas() == 50);

	}
	
	public void test03elTableroDeUnJuegoTiene50Columnas() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTablero().getCantidadColumnas() == 50);

	}
	
	public void test04elTableroSabeSiTieneUnPersonaje() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getAutobots().getAlgoformer(2)));
	}
	
	@Test
	public void test05todoAlgoformerNaceEnTableroTierra() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getAutobots().getAlgoformer(1)));
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getAutobots().getAlgoformer(2)));
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getAutobots().getAlgoformer(3)));
		
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getDecepticons().getAlgoformer(1)));
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getDecepticons().getAlgoformer(2)));
		Assert.assertTrue(juego.getTableroTierra().contieneA(juego.getDecepticons().getAlgoformer(3)));
		
	}
	
	@Test
	public void test06ningunAlgoformerNaceEnTableroCielo() {
		
		Juego juego = new Juego();
		
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getAutobots().getAlgoformer(1)));
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getAutobots().getAlgoformer(2)));
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getAutobots().getAlgoformer(3)));
		
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getDecepticons().getAlgoformer(1)));
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getDecepticons().getAlgoformer(2)));
		Assert.assertFalse(juego.getTableroCielo().contieneA(juego.getDecepticons().getAlgoformer(3)));
		
	}
	
	@Test
	public void test07unTableroPuedeContenerChispaDelPoder() {
		
		Juego juego = new Juego();
		
		juego.getTableroTierra().setContieneChispaDelPoder(true);
		
		Assert.assertTrue(juego.getTableroTierra().getContieneChispaDelPoder());
		
		juego.getTableroTierra().setContieneChispaDelPoder(false);
		
		Assert.assertFalse(juego.getTableroTierra().getContieneChispaDelPoder());
	}
	
}
