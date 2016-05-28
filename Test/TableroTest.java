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
	public void test02elTableroDeUnJuegoTiene50x50Casilleros() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTablero().getCantidadFilas() == 50);
		
		Assert.assertTrue(juego.getTablero().getCantidadColumnas() == 50);

	}
	
}
