package test;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.RecursoOcupadoException;

public class MovimientoTest {

	@Test(expected=MovimientoInvalidoMuyLejosExcepcion.class)
	public void test01algoformerNoPuedeMoverseMasAllaDeLoQueIndicaSuVelocidadEnElEjeY() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(4);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(10,15);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); /* Deberia arrojar excepcion */

	}
	
	@Test(expected=MovimientoInvalidoMuyLejosExcepcion.class)
	public void test02algoformerNoPuedeMoverseMasAllaDeLoQueIndicaSuVelocidadEnElEjeX() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(4);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(15,10);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); /* Deberia arrojar excepcion */

	}
	
	@Test(expected=MovimientoInvalidoMuyLejosExcepcion.class)
	public void test03algoformerNoPuedeMoverseMasAllaDeLoQueIndicaSuVelocidadEnDiagonal() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(3);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(14,14);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1);  /* Deberia arrojar excepcion */	

	}
	
	public void test04algoformerPuedeMoverseMenosOIgualDeLoQueIndicaSuVelocidadEnEjeY() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(4);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(10,12);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(1).getPosicion().igualA(casillerofinal_1));

	}
	
	public void test05algoformerPuedeMoverseMenosOIgualDeLoQueIndicaSuVelocidadEnEjeX() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(4);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(13,10);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(1).getPosicion().igualA(casillerofinal_1));

	}
	
	public void test06algoformerPuedeMoverseMenosOIgualDeLoQueIndicaSuVelocidadEnDiagonal() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(4);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(14,14);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer(1).getPosicion().igualA(casillerofinal_1));

	}
	
	@Test(expected=MovimientoInvalidoAlgoformerObstruyendoExcepcion.class)
	public void test07algoformerNoPuedeMoversePorEncimaDeOtroAlgoformerEnEjeX() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		Casillero casillerointermedio = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(5);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(15,10);
		casillerointermedio.setPosicion(13,10);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		juego.getDecepticons().getAlgoformer(2).setPosicion(casillerointermedio);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
	}
	
	@Test(expected=MovimientoInvalidoAlgoformerObstruyendoExcepcion.class)
	public void test08algoformerNoPuedeMoversePorEncimaDeOtroAlgoformerEnEjeY() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		Casillero casillerointermedio = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(5);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(10,13);
		casillerointermedio.setPosicion(10,11);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		juego.getDecepticons().getAlgoformer(2).setPosicion(casillerointermedio);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
	}
	
	@Test(expected=MovimientoInvalidoAlgoformerObstruyendoExcepcion.class)
	public void test08algoformerNoPuedeMoversePorEncimaDeOtroAlgoformerEnDiagonal() {
		
		Juego juego = new Juego();
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal_1 = new Casillero();
		Casillero casillerointermedio = new Casillero();
		
		int velocidad = juego.getDecepticons().getAlgoformer(1).setVelocidad(5);
		
		casilleroinicial.setPosicion(10,10);
		casillerofinal_1.setPosicion(14,14);
		casillerointermedio.setPosicion(13,13);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casilleroinicial);
		juego.getDecepticons().getAlgoformer(2).setPosicion(casillerointermedio);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal_1); 
		
	}
	
}
