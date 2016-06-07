package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Juego;
import Modelo.Posicion;
import Modelo.Tablero;

import Modelo.Autobots;
import Modelo.Decepticons;


public class JuegoTest {

	@Test
	public void test01elJuegoTieneDosEquipos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots() != null);
		Assert.assertTrue(juego.getDecepticons() != null);
	}
	


	
	@Test
	public void test04elJuegoPuedeSetearElPrimerTurno() {
		
		Juego juego = new Juego();
		
		juego.setPrimerTurno(juego.getAutobots());
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
		
		
	}
	
	@Test
	public void test05elJuegoEjecutaTurnos() {
		
		Juego juego = new Juego();
		
		juego.setPrimerTurno(juego.getAutobots());
		
		juego.jugarTurno();
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
	
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		
		juego.jugarTurno();
		
		Assert.assertTrue(juego.getEjecutorDeTurnoActual() == juego.getAutobots());
		
		Assert.assertFalse(juego.getEjecutorDeTurnoActual() == juego.getDecepticons());
		
	}
	

	
	@Test
	public void test07elJuegoTieneUnTablero() {
		
		Juego juego = new Juego();
		Tablero tab=new Tablero();
		
		Assert.assertTrue(juego.getTablero().equals( tab));	
	}
	

@Test
public void test08ubicarMovilLoPoneDondeDebe()
{
	Juego juego=new Juego();
	Posicion pos1=new Posicion(47,47);
	Posicion pos2=new Posicion(49,47);
	Posicion pos3=new Posicion(47,49);
	Posicion pos4=new Posicion(2,2);
	Posicion pos5=new Posicion(0,2);
	Posicion pos6=new Posicion(2,0);
	
	Assert.assertTrue(((Decepticons) juego.getDecepticons()).getMegatron().getPosicion().equals(pos1));
	
	
	Assert.assertTrue(((Decepticons) juego.getDecepticons()).getBonecrusher().getPosicion().equals(pos2));

	

	Assert.assertTrue(((Decepticons) juego.getDecepticons()).getFrenzy().getPosicion().equals(pos3));
	

	Assert.assertTrue(((Autobots) juego.getAutobots()).getOptimus().getPosicion().equals(pos4));
	
	Assert.assertTrue(((Autobots) juego.getAutobots()).getRatchet().getPosicion().equals(pos5));
	
	
	Assert.assertTrue(((Autobots) juego.getAutobots()).getBumblebee().getPosicion().equals(pos6));


	}
	
}