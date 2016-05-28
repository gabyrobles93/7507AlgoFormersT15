package test;

import org.junit.Assert;
import org.junit.Test;

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
	public void test03elJuegoPuedeSetearElPrimerTurno() {
		
		Juego juego = new Juego();
		
		juego.iniciar();
		
		juego.setPrimerTurno(juego.getAutobots());
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
		
		
	}
	
	@Test
	public void test04elJuegoEjecutaTurnos() {
		
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
	public void test05elJuegoFinalizaCuandoUnEquipoGana() {
		
		Juego juego = new Juego();
		
		juego.iniciar();
		
		juego.setGanador(juego.getAutobots()); 
		
		Assert.assertTrue(juego.estaFinalizado());
		Assert.assertFalse(juego.estaIniciado());
		
	}
	
	@Test
	public void test06elJuegoTieneUnTablero() {
		
		Juego juego = new Juego();
		
		Tablero tablero = new Tablero();
		
		Assert.assertTrue(juego.getTablero() instanceof Tablero);
		
	}
	
}
