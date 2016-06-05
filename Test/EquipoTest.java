package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Bonecrusher;
import Modelo.Bumblebee;
import Modelo.Casillero;
import Modelo.Frenzy;
import Modelo.Juego;
import Modelo.Megatron;
import Modelo.Optimus;
import Modelo.Ratchet;

public class EquipoTest {

	@Test
	public void test01elEquipoComienzaConTresMiembrosVivos() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 3);
		
		Assert.assertTrue(juego.getDecepticons().getCantidadMiembrosVivos() == 3);
	}
	
	

	
	@Test
	public void test06siAutobotsNoTieneVidaTotalGanaDecepticons() {
		
		Juego juego = new Juego();
		
		juego.getAutobots().setVidaTotal(0);
		
		Assert.assertTrue(juego.getGanador() == juego.getDecepticons());
		
		Assert.assertFalse(juego.getGanador() == juego.getAutobots());
	}
	
	@Test
	public void test07siDecepticonsNoTieneVidaTotalGanaAutobots() {
		
		Juego juego = new Juego();
		
		juego.getDecepticons().setVidaTotal(0);
		
		Assert.assertTrue(juego.getGanador() == juego.getAutobots());
		
		Assert.assertFalse(juego.getGanador() == juego.getDecepticons());
	}
	
	@Test
	public void test08siAutobotsNoTieneMiembrosVivosGanaDecepticons() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 3);
		
		juego.getAutobots().setVidaTotal(0);
		
		Assert.assertTrue(juego.getAutobots().getCantidadMiembrosVivos() == 0);
		
		Assert.assertTrue(juego.getGanador() == juego.getDecepticons());
	}
	
	@Test
	public void test09siDecepticonsNoTieneMiembrosVivosGanaAutobots() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getDecepticons().getCantidadMiembrosVivos() == 3);
		
		juego.getDecepticons().setVidaTotal(0);
		
		Assert.assertTrue(juego.getDecepticons().getCantidadMiembrosVivos() == 0);
		
		Assert.assertTrue(juego.getGanador() == juego.getAutobots());
	}
	
	@Test
	public void test10autobotsComienzaConOptimusBumblebeeRatchet() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getAutobots().getAlgoformer("optimus") instanceof Optimus);
		Assert.assertTrue(juego.getAutobots().getAlgoformer("bumblebee") instanceof Bumblebee);
		Assert.assertTrue(juego.getAutobots().getAlgoformer("ratchet") instanceof Ratchet);
		
	}
	
	
	@Test
	public void test11decepticonsComienzaConMegatronBonecrusherFrenzy() {
		
		Juego juego = new Juego();
		
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("megatron") instanceof Megatron);
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("bonecrusher") instanceof Bonecrusher);
		Assert.assertTrue(juego.getDecepticons().getAlgoformer("frenzy") instanceof Frenzy);
		
	}
}
/*	
	@Test
	public void test12autobotsConTresMiembrosVivosYContenidosEnCuadradoDe6x6PuedeFormarSuperion() {
		
		Juego juego = new Juego();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		/* El test01 comprueba que el equipo inicia con 3 miembros vivos */
		
/*		casillero1.setPosicion(35,35);
		casillero2.setPosicion(40,40);
		casillero3.setPosicion(35,40);
		
		juego.getAutobots().getAlgoformer(1).setPosicion(casillero1);
		juego.getAutobots().getAlgoformer(2).setPosicion(casillero2);
		juego.getAutobots().getAlgoformer(3).setPosicion(casillero3);
		
		Assert.assertTrue(juego.getAutobots().puedeFormarSuperion());
		
	}
	
	@Test
	public void test13autobotsConTresMiembrosVivosYNoContenidosEnCuadradoDe6x6NoPuedeFormarSuperion() {
		
		Juego juego = new Juego();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		/* El test01 comprueba que el equipo inicia con 3 miembros vivos */
		
/*		casillero1.setPosicion(35,34);
		casillero2.setPosicion(40,40);
		casillero3.setPosicion(35,40);
		
		juego.getAutobots().getAlgoformer(1).setPosicion(casillero1);
		juego.getAutobots().getAlgoformer(2).setPosicion(casillero2);
		juego.getAutobots().getAlgoformer(3).setPosicion(casillero3);
		
		Assert.assertFalse(juego.getAutobots().puedeFormarSuperion());
		
	}
	
	@Test
	public void test14decepticonsConTresMiembrosVivosYContenidosEnCuadradoDe6x6PuedeFormarSuperion() {
		
		Juego juego = new Juego();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		/* El test01 comprueba que el equipo inicia con 3 miembros vivos */
		
/*		casillero1.setPosicion(35,35);
		casillero2.setPosicion(40,40);
		casillero3.setPosicion(35,40);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casillero1);
		juego.getDecepticons().getAlgoformer(2).setPosicion(casillero2);
		juego.getDecepticons().getAlgoformer(3).setPosicion(casillero3);
		
		Assert.assertTrue(juego.getDecepticons().puedeFormarSuperion());
		
	}
	
	@Test
	public void test15decepticonsConTresMiembrosVivosYNoContenidosEnCuadradoDe6x6NoPuedeFormarMenasor() {
		
		Juego juego = new Juego();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		
		/* El test01 comprueba que el equipo inicia con 3 miembros vivos */
		
/*		casillero1.setPosicion(35,34);
		casillero2.setPosicion(40,40);
		casillero3.setPosicion(35,40);
		
		juego.getDecepticons().getAlgoformer(1).setPosicion(casillero1);
		juego.getDecepticons().getAlgoformer(2).setPosicion(casillero2);
		juego.getDecepticons().getAlgoformer(3).setPosicion(casillero3);
		
		Assert.assertFalse(juego.getAutobots().puedeFormarSuperion());
		
	}

}
*/