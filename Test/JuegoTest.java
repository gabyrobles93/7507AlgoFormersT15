package Modelo;

import org.junit.Assert;

public class JuegoTest {

	@test
	public void test01elJuegoTieneDosEquipos {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.autobots != NULL);
		Assert.assertTrue(juego.decepticons != NULL);
	}
	
}
