package Test;


import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Area;
import Modelo.AreaEspinosa;
import Modelo.AreaPantanosa;
import Modelo.AreaRocosa;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.ErrorAlgoformerHumanoideNoPuedePasarPorPantano;
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
import Modelo.SuperficiePantanosa;
import Modelo.SuperficieRocosa;
import Modelo.Tablero;


public class SuperficieTest {

	@Test
	public void testClave(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			
			
			tab.setAreaDeSuperficie(areapantanosa);
			
			Assert.assertTrue(areapantanosa.getCasillero(3,4).getSuperficie() instanceof SuperficiePantanosa);
	}
	
	@Test
	public void testClave_2(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion pos = new Posicion(20,15);
			
			tab.setAreaDeSuperficie(areapantanosa);
			
			Assert.assertTrue(tab.getCasillero(pos).getSuperficie() instanceof SuperficiePantanosa);
	}
	
	// INICIO PRIMER TEST //

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
			Area arearocosa = new AreaRocosa(44,49,30,35);			// Es un area de 12 x 4
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
			Area arearocosa = new AreaRocosa(44,49,30,49);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posinicial = new Posicion(49,31);
			Posicion posfinal = new Posicion(49,37);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(frenzy, posinicial);
			
			frenzy.mover(posfinal);
			
			Assert.assertTrue(frenzy.getPosicion().equals(posfinal));
	}
	
	// FIN PRIMER PUNTO DE TESTS //
	
	// INICIO SEGUNDO TEST //
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test13optimusHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			optimus.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test14bumblebeeHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(21,15);
			Posicion posfinal = new Posicion(20,15);
			
			tab.ubicarMovil(bumblebee, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			bumblebee.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test15ratchetHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(17,21);
			Posicion posfinal = new Posicion(17,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			ratchet.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test16megatronHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer megatron = new MegatronHumanoide();
			Posicion posinicial = new Posicion(14,19);
			Posicion posfinal = new Posicion(15,19);
			
			tab.ubicarMovil(megatron, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			megatron.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test17bonecrusherHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherHumanoide();
			Posicion posinicial = new Posicion(14,14);
			Posicion posfinal = new Posicion(15,15);
			
			tab.ubicarMovil(bonecrusher, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			bonecrusher.mover(posfinal);
	}

	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test18frenzyHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer frenzy = new FrenzyHumanoide();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(20,20);
			
			tab.ubicarMovil(frenzy, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			frenzy.mover(posfinal);
	}
	
	// FIN SEGUNDO PUNTO DE TESTS //

	// TERCER TEST //
	
	// FIN TERCER TEST //
	
	// CUARTO TEST //

	@Test
	public void test19ratchetAlternoVoladorPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer ratchet = new RatchetAlterno();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(20,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));		
	}
	
	@Test
	public void test20megatronAlternoVoladorPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area areapantanosa = new AreaPantanosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer megatron = new MegatronAlterno();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(19,19);
			
			tab.ubicarMovil(megatron, posinicial);
			tab.setAreaDeSuperficie(areapantanosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));		
	}
	
	// FIN CUARTO TEST //
	
	// INICIO QUINTO TEST //
	
	@Test
	public void test21optimusHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area areaespinosa = new AreaEspinosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			tab.setAreaDeSuperficie(areaespinosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getVida() == 452);		
	}
	
	@Test
	public void test22optimusAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area areaespinosa = new AreaEspinosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer optimus = new OptimusAlterno();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			tab.setAreaDeSuperficie(areaespinosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getVida() == 452);		
	}
	
	@Test
	public void test23bumblebeeHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area areaespinosa = new AreaEspinosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,19);
			
			tab.ubicarMovil(bumblebee, posinicial);
			tab.setAreaDeSuperficie(areaespinosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getVida() == 317);		
	}
	
	@Test
	public void test24bumblebeeAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area areaespinosa = new AreaEspinosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer bumblebee = new BumblebeeAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(bumblebee, posinicial);
			tab.setAreaDeSuperficie(areaespinosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getVida() == 273);		
	}
	
	@Test
	public void test23ratchetHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area areaespinosa = new AreaEspinosa(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			tab.setAreaDeSuperficie(areaespinosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getVida() == 143);		
	}
	
	// HACER LAS MISMAS PRUEBAS PARA LOS DECEPTICONS QUE SEAN TERRESTRES //
	
	// FIN QUINTO TEST //
	
	// HACER SEXTO TEST //
	
	// FIN SEXTO TEST //
	
	
	
}
