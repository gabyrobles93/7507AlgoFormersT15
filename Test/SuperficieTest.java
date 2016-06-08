package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;


public class SuperficieTest {

	@Test
	public void test01optimusHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(13,17,13,17);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(15,17);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(optimus, posinicial);
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test02optimusAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(13,17,13,17);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer optimus = new OptimusAlterno();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(15,19);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(optimus, posinicial);
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test03bumblebeeHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(23,27,23,27);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(25,25);
			Posicion posfinal = new Posicion(27,25);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bumblebee, posinicial);
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test04bumblebeeAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(23,27,23,27);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer bumblebee = new BumblebeeAlterno();
			Posicion posinicial = new Posicion(25,25);
			Posicion posfinal = new Posicion(30,25);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bumblebee, posinicial);
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test05ratchetHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(33,37,33,37);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(35,35);
			Posicion posfinal = new Posicion(35,36);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(ratchet, posinicial);
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test06ratchetAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(33,37,33,37);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Algoformer ratchet = new RatchetAlterno();
			Posicion posinicial = new Posicion(35,35);
			Posicion posfinal = new Posicion(35,43);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(ratchet, posinicial);
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test07megatronHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(2,8,2,8);			// Es un area de 7 x 7
			Movimiento.setTablero(tab);
			Algoformer megatron = new MegatronHumanoide();
			Posicion posinicial = new Posicion(5,5);
			Posicion posfinal = new Posicion(5,6);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(megatron, posinicial);
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test08megatronAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(2,8,2,8);			// Es un area de 7 x 7
			Movimiento.setTablero(tab);
			Algoformer megatron = new MegatronAlterno();
			Posicion posinicial = new Posicion(5,5);
			Posicion posfinal = new Posicion(5,13);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(megatron, posinicial);
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test09bonecrusherHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(14,25,14,17);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherHumanoide();
			Posicion posinicial = new Posicion(16,15);
			Posicion posfinal = new Posicion(17,15);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bonecrusher, posinicial);
			
			bonecrusher.mover(posfinal);
			
			Assert.assertTrue(bonecrusher.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test10bonecrusherAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(14,25,14,17);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherAlterno();
			Posicion posinicial = new Posicion(16,15);
			Posicion posfinal = new Posicion(24,15);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bonecrusher, posinicial);
			
			bonecrusher.mover(posfinal);
			
			Assert.assertTrue(bonecrusher.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test11frenzyHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(44,50,30,35);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer frenzy = new FrenzyHumanoide();
			Posicion posinicial = new Posicion(49,31);
			Posicion posfinal = new Posicion(49,33);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(frenzy, posinicial);
			
			frenzy.mover(posfinal);
			
			Assert.assertTrue(frenzy.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test12frenzyAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(44,50,30,35);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posinicial = new Posicion(49,31);
			Posicion posfinal = new Posicion(49,37);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(frenzy, posinicial);
			
			frenzy.mover(posfinal);
			
			Assert.assertTrue(frenzy.getPosicion().equals(posfinal));
	}
}
