package Test;

import org.junit.Assert;
import org.junit.Test;


import Modelo.Algoformer;

import Modelo.ErrorAreaFueraDeRangoPosible;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;

import Modelo.Juego;
import Modelo.MegatronHumanoide;
import Modelo.Tablero;


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
	public void test07elJuegoTieneUnTablero() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getTablero() instanceof Tablero);	
	}
	
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test09dosAlgoformerDeMismoEquipoNoSePuedeAtacar(){
		
		Juego juego=new Juego();//nacen  a un casillero de distancia

		
		juego.atacar(juego.getAutobots().getAlgoformer("optimus"), juego.getAutobots().getAlgoformer("bumblebee"));
	}

	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test10noSePuedeAtacarAlgoformerFueraDeRango(){
		
		Juego juego=new Juego();//nacen en esquinas opuestas
	
		juego.atacar(juego.getAutobots().getAlgoformer("optimus"), juego.getDecepticons().getAlgoformer("megatron"));
	}

@Test
public void test08ubicarMovilLoPoneDondeDebe()
{
	Juego juego=new Juego();
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getFila()==47);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getColumna()==47);
	
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher").getFila()==49);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher").getColumna()==47);
	
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy").getFila()==47);
	Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy").getColumna()==49);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus").getFila()==2);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus").getColumna()==2);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet").getFila()==0);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet").getColumna()==2);
	
	Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee").getFila()==2);
	Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee").getColumna()==0);

	}
	

	@Test 
	public void test11dosAlgoformersSeAtacan(){
		Juego juego=new Juego();
		
		//Los cambio de posicion con ubicarMovil para que no salte la excepcion de movimiento
		 
		
		juego.getTablero().ubicarMovil(juego.getAutobots().getAlgoformer("optimus"),3,3);
		juego.getTablero().ubicarMovil(juego.getDecepticons().getAlgoformer("megatron"),4,4);
		juego.atacar(juego.getAutobots().getAlgoformer("optimus"), juego.getDecepticons().getAlgoformer("megatron"));
		
		//como megatron tiene vida 550 y optimus ataque 50 deberian quedarle 500
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron").getVida()==500);
	}

}