package Test;

import org.junit.Assert;
import org.junit.Test;


import Modelo.Algoformer;

import Modelo.ErrorAreaFueraDeRangoPosible;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;

import Modelo.Juego;
import Modelo.MegatronHumanoide;
import Modelo.Posicion;
import Modelo.Tablero;


public class JuegoTest {

	@Test
	public void test01elJuegoTieneDosEquipos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots() != null);
		Assert.assertTrue(juego.getDecepticons() != null);
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
		
		Assert.assertTrue(juego.getTablero().equals( new Tablero()));	
	}
	

@Test
public void test08ubicarMovilLoPoneDondeDebe()
{
	Juego juego=new Juego();
	
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getPosicion().getFila()==47);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getPosicion().getColumna()==47);
	
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher").getPosicion().getFila()==49);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher").getPosicion().getColumna()==47);
	
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy").getPosicion().getFila()==47);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy").getPosicion().getColumna()==49);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus").getPosicion().getFila()==2);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus").getPosicion().getColumna()==2);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet").getPosicion().getFila()==0);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet").getPosicion().getColumna()==2);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee").getPosicion().getFila()==2);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee").getPosicion().getColumna()==0);

	}
	
}