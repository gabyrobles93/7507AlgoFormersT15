package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Juego;
import Modelo.TableroCielo;
import Modelo.TableroTierra;

public class JuegoTest {

	@Test
	public void test01elJuegoTieneDosEquipos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots() != null);
		Assert.assertTrue(juego.getDecepticons() != null);
	}
	
	@Test
	public void test02elJuegoTieneEstadoIniciadoyFinalizado() {
		
		Juego juego = new Juego();
		
		/* Antes de iniciar, no esta iniciado y se considera finalizado */
		Assert.assertFalse(juego.estaIniciado());
		Assert.assertTrue(juego.estaFinalizado());
		
		juego.iniciar();
		/* Tras iniciar, esta iniciado y no esta finalizado */
		Assert.assertTrue(juego.estaIniciado());
		Assert.assertFalse(juego.estaFinalizado());
		
		juego.finalizar();
		/* Tras finalizar, no esta iniciado y si esta finalizado */
		Assert.assertFalse(juego.estaIniciado());
		Assert.assertTrue(juego.estaFinalizado());
		
	}
	
	@Test
	public void test03elJuegoComienzaSinGanadores() {
		
		Juego juego = new Juego();
		
		Assert.assertFalse(juego.getGanador() == juego.getDecepticons());
		Assert.assertFalse(juego.getGanador() == juego.getAutobots());
	}
	
	@Test
	public void test04elJuegoPuedeSetearElPrimerTurno() {
		
		Juego juego = new Juego();
		
		juego.iniciar();
		
		juego.setPrimerTurno(juego.getAutobots());
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
		
		
	}
	
	@Test
	public void test05elJuegoEjecutaTurnos() {
		
		Juego juego = new Juego();
		
		juego.iniciar();
		
		juego.setPrimerTurno(juego.getAutobots());
		
		juego.jugarTurno();
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
	
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		
		juego.jugarTurno();
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
		
	}
	
	@Test
	public void test06elJuegoFinalizaCuandoUnEquipoGana() {
		
		Juego juego = new Juego();
		
		juego.iniciar();
		
		juego.setGanador(juego.getAutobots()); 
		
		Assert.assertTrue(juego.estaFinalizado());
		Assert.assertFalse(juego.estaIniciado());
		
	}
	
	@Test
	public void test07elJuegoTieneUnTableroTierra() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTableroTierra() instanceof TableroTierra);	
	}
	
	@Test
	public void test08elJuegoTieneUnTableroCielo() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTableroCielo() instanceof TableroCielo);	
	}
	
}
