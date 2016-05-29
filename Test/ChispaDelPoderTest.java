package test;

import org.junit.Assert;
import org.junit.Test;

public class ChispaDelPoderTest {

	@Test
	public void test01laChispaEstaEnElTableroTierra() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTableroTierra().getContieneChispaDelPoder());
	}
	
	@Test
	public void test02laChispaNoEstaEnElTableroCielo() {
		
		Juego juego = new Juego();
		
		Assert.assertFalse(juego.getTableroCielo().getContieneChispaDelPoder());

	}
	
	@Test
	public void test03laChispaDelPoderTieneUnaPosicionEnElTablero() {
		
		Juego juego = new Juego();
		
		Casillero casillero = new Casillero();
		
		casillero.setPosicion(30,27);
		
		juego.getTableroTierra().setPosicionChispaDelPoder(casillero);
		
		Assert.assertTrue(juego.getTableroTierra().getPosicionChispaDelPoder().igualA(casillero.getPosicion()));

	}
	
	@Test
	public void test04laChispaNaceCercaDelCentroDelTablero() {
		
		Juego juego = new Juego();
		
		Area area = new Area();
		
		area.setColumnaInicial(25);
		area.setColumnaFinal(26);
		area.setFilaInicial(24);
		area.setFilaFinal(25);
		
		Assert.assertTrue(juego.getTableroTierra().getPosicionChispaDelPoder().contenidoEn(area));
	}
	
	@Test
	public void test05laChispaNaceCercaDelCentroDelTablero() {
		
		Juego juego = new Juego();
		
		Area area = new Area();
		
		area.setColumnaInicial(25);
		area.setColumnaFinal(26);
		area.setFilaInicial(24);
		area.setFilaFinal(25);
		
		Assert.assertTrue(juego.getTableroTierra().getPosicionChispaDelPoder().contenidoEn(area));
	}
	
	@Test
	public void test06autobotsGanaSiUnIntegranteSeParaSobreChispaDelPoder() {
		
		Juego juego = new Juego();
		
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal = new Casillero();
		
		casilleroinicial.setPosicion(24,28);
		casillerofinal.setPosicion(juego.getTableroTierra.getPosicionChispaDelPoder());
		
		juego.getAutobots().getAlgoformer(1).setVelocidad(6);
		
		juego.getAutobots().getAlgoformer(1).mover(casillerofinal);
		
		Assert.assertTrue(juego.getGanador() == juego.getAutobots());
	}
	
	@Test
	public void test07decepticonsGanaSiUnIntegranteSeParaSobreChispaDelPoder() {
		
		Juego juego = new Juego();
		
		Casillero casilleroinicial = new Casillero();
		Casillero casillerofinal = new Casillero();
		
		casilleroinicial.setPosicion(28,22);
		casillerofinal.setPosicion(juego.getTableroTierra.getPosicionChispaDelPoder());
		
		juego.getDecepticons().getAlgoformer(1).setVelocidad(6);
		
		juego.getDecepticons().getAlgoformer(1).mover(casillerofinal);
		
		Assert.assertTrue(juego.getGanador() == juego.getAutobots());
	}
	
}
