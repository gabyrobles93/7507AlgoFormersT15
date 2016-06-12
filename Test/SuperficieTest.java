package Test;


import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Area;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.Equipo;
import Modelo.ErrorAlgoformerHumanoideNoPuedePasarPorPantano;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.Juego;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;
import Modelo.Superficie;
import Modelo.SuperficiePantanosa;
import Modelo.SuperficieRocosa;
import Modelo.SuperficieTierra;
import Modelo.Tablero;


public class SuperficieTest {

	@Test
	public void testClave(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			
			Superficie suppantanosa = new SuperficiePantanosa();
			
			area.setAreaPantanosa(tab);

			Assert.assertTrue(tab.getCasillero(17,17).getSuperficieTierra().equals(suppantanosa));
	}
	
	// INICIO PRIMER TEST //

	@Test
	public void test01optimusHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(13,17,13,17);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(15,17);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(optimus, posinicial);
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getPosicion().equals(posfinal));
	}


	@Test
	public void test02optimusAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(13,17,13,17);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer optimus = new OptimusAlterno();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(15,19);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(optimus, posinicial);
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test03bumblebeeHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(23,27,23,27);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(25,25);
			Posicion posfinal = new Posicion(27,25);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bumblebee, posinicial);
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test04bumblebeeAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(23,27,23,27);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bumblebee = new BumblebeeAlterno();
			Posicion posinicial = new Posicion(25,25);
			Posicion posfinal = new Posicion(30,25);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bumblebee, posinicial);
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test05ratchetHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(33,37,33,37);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(35,35);
			Posicion posfinal = new Posicion(35,36);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(ratchet, posinicial);
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test06ratchetAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(33,37,33,37);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer ratchet = new RatchetAlterno();
			Posicion posinicial = new Posicion(35,35);
			Posicion posfinal = new Posicion(35,43);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(ratchet, posinicial);
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test07megatronHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(2,8,2,8);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer megatron = new MegatronHumanoide();
			Posicion posinicial = new Posicion(5,5);
			Posicion posfinal = new Posicion(5,6);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(megatron, posinicial);
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test08megatronAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(2,8,2,8);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer megatron = new MegatronAlterno();
			Posicion posinicial = new Posicion(5,5);
			Posicion posfinal = new Posicion(5,13);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(megatron, posinicial);
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test09bonecrusherHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(14,25,14,17);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherHumanoide();
			Posicion posinicial = new Posicion(16,15);
			Posicion posfinal = new Posicion(17,15);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bonecrusher, posinicial);
			
			bonecrusher.mover(posfinal);
			
			Assert.assertTrue(bonecrusher.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test10bonecrusherAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(14,25,14,17);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherAlterno();
			Posicion posinicial = new Posicion(16,15);
			Posicion posfinal = new Posicion(24,15);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(bonecrusher, posinicial);
			
			bonecrusher.mover(posfinal);
			
			Assert.assertTrue(bonecrusher.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test11frenzyHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(44,49,30,35);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer frenzy = new FrenzyHumanoide();
			Posicion posinicial = new Posicion(49,31);
			Posicion posfinal = new Posicion(49,33);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(frenzy, posinicial);
			
			frenzy.mover(posfinal);
			
			Assert.assertTrue(frenzy.getPosicion().equals(posfinal));
	}
	
	@Test
	public void test12frenzyAlternoTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area area = new Area(44,49,30,49);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posinicial = new Posicion(49,31);
			Posicion posfinal = new Posicion(49,37);
			
			area.setAreaRocosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(frenzy, posinicial);
			
			frenzy.mover(posfinal);
			
			Assert.assertTrue(frenzy.getPosicion().equals(posfinal));
	}
	
	// FIN PRIMER PUNTO DE TESTS //
	
	// INICIO SEGUNDO TEST //
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test13optimusHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
	
			
			optimus.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test14bumblebeeHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(21,15);
			Posicion posfinal = new Posicion(20,15);
			
			tab.ubicarMovil(bumblebee, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.	
			
			bumblebee.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test15ratchetHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(17,21);
			Posicion posfinal = new Posicion(17,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.	
	
			
			ratchet.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test16megatronHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer megatron = new MegatronHumanoide();
			Posicion posinicial = new Posicion(14,19);
			Posicion posfinal = new Posicion(15,19);
			
			tab.ubicarMovil(megatron, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.	
			
			megatron.mover(posfinal);
	}
	
	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test17bonecrusherHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bonecrusher = new BonecrusherHumanoide();
			Posicion posinicial = new Posicion(14,14);
			Posicion posfinal = new Posicion(15,15);
			
			tab.ubicarMovil(bonecrusher, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.		
			
			bonecrusher.mover(posfinal);
	}

	@Test(expected=ErrorAlgoformerHumanoideNoPuedePasarPorPantano.class)
	public void test18frenzyHumanoideNoPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer frenzy = new FrenzyHumanoide();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(20,20);
			
			tab.ubicarMovil(frenzy, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.			
			
			frenzy.mover(posfinal);
	}
	
	// FIN SEGUNDO PUNTO DE TESTS //

	// TERCER TEST //
	//EN MODOO ALTERNO LAS UNIDADES TERRESTRES TARDAN EL DOBLE EN ATRAVESAR UN PANTANO//
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test15BumblebeeAlternoPasaPorPantanoPeroTardaElDoble(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer algof = new BumblebeeAlterno();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(17,17);
			
			tab.ubicarMovil(algof, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.			
			//Bumblebee alterno tiene velocidad 5; En pantano solo se puede mover dos casilleros
			
			algof.mover(posfinal);
			Assert.assertFalse(tab.getCasillero(posinicial).estaOcupado());
			Assert.assertTrue(tab.getCasillero(posfinal).estaOcupado());
			Assert.assertTrue(algof.getPosicion().equals(posfinal));
			
			algof.mover(posinicial);//vuelvo a donde estaba para intentear ir mas lejos;
			
			Posicion posicionInalcanzable=new Posicion(19,19);
			
			algof.mover(posicionInalcanzable);
	}
	//HACER PARA EL RESTO DE LOS ALGOFORMERS MODO ALTERNO TERRESTRES
	// FIN TERCER TEST //
	
	// CUARTO TEST //

	@Test
	public void test19ratchetAlternoVoladorPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer ratchet = new RatchetAlterno();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(20,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.			

			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getPosicion().equals(posfinal));		
	}
	
	@Test
	public void test20megatronAlternoVoladorPuedePasarPorPantano(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer megatron = new MegatronAlterno();
			Posicion posinicial = new Posicion(22,22);
			Posicion posfinal = new Posicion(19,19);
			
			tab.ubicarMovil(megatron, posinicial);
			area.setAreaPantanosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.			
			
			megatron.mover(posfinal);
			
			Assert.assertTrue(megatron.getPosicion().equals(posfinal));		
	}
	
	// FIN CUARTO TEST //
	
	// INICIO QUINTO TEST //
	
	@Test
	public void test21optimusHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.				
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getVida() == 452);		
	}
	
	@Test
	public void test22optimusAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer optimus = new OptimusAlterno();
			Posicion posinicial = new Posicion(15,14);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(optimus, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.				
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getVida() == 452);		
	}
	
	@Test
	public void test23bumblebeeHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bumblebee = new BumblebeeHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,19);
			
			tab.ubicarMovil(bumblebee, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.					
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getVida() == 317);		
	}
	
	@Test
	public void test24bumblebeeAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer bumblebee = new BumblebeeAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,16);
			
			tab.ubicarMovil(bumblebee, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.						
			
			bumblebee.mover(posfinal);
			
			Assert.assertTrue(bumblebee.getVida() == 273);		
	}
	
	@Test
	public void test25ratchetHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer ratchet = new RatchetHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			
			tab.ubicarMovil(ratchet, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.							
			
			ratchet.mover(posfinal);
			
			Assert.assertTrue(ratchet.getVida() == 143);		
	}
	@Test
	public void test26MegatronHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);
			Algoformer algoformer = new MegatronHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			
			int vidaDespuesDeEspinas = algoformer.getVida()-(int)(algoformer.getVida()*0.05);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.							
	
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	@Test
	public void test27BonecrusherHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new BonecrusherHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida()-(int)(algoformer.getVida()*0.05);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.							
	
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	@Test
	public void test28BonecrusherAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new BonecrusherAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida()-(int)(algoformer.getVida()*0.05);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.								
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	@Test
	public void test29FrenzyHumanoideEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new FrenzyHumanoide();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida()-(int)(algoformer.getVida()*0.05);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.								
	
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	@Test
	public void test30FrenzyAlternoEsDaniadoPorEspinas(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new FrenzyAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida()-(int)(algoformer.getVida()*0.05);
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.								
	
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}

	
	// FIN QUINTO TEST //


	
	// INICIO SEXTO TEST //
	
	@Test
	public void test31MegatronAlternoNoEsDaniadoPorEspinasPorSerUnidadAerea(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new MegatronAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida();
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.								
	
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	
	@Test
	public void test32RatchetAlternoNoEsDaniadoPorEspinasPorSerUnidadAerea(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new RatchetAlterno();
			Posicion posinicial = new Posicion(15,21);
			Posicion posfinal = new Posicion(15,20);
			int vidaDespuesDeEspinas = algoformer.getVida();
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaEspinosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.									
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getVida() == vidaDespuesDeEspinas);		
	}
	// FIN SEXTO TEST //
	
	//INICIO SEPTIMO TEST//
	@Test
	public void test33RatchetAlternoAtraviesaNubesSinProblema(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new RatchetAlterno();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(17,17);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaNubosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.									
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getPosicion().equals(posfinal));		
	}
	@Test
	public void test34MegatronAlternoAtraviesaNubesSinProblema(){
		
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer algoformer = new MegatronAlterno();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(17,17);
			
			tab.ubicarMovil(algoformer, posinicial);
			area.setAreaNubosa(tab); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.										
			
			algoformer.mover(posfinal);
			
			Assert.assertTrue(algoformer.getPosicion().equals(posfinal));		
	}
	
	
	//FIN SEPTIMO TEST
	//INICIO OCTAVO TEST
	@Test
	public void test35MegatronAlternoQuedaAtrapado3TurnosEnNebulosaDeAndromeda(){
		
			Juego juego = new Juego();
			Area area = new Area(46,49,46,49);			// Pongo una tormenta donde nace
			Posicion.setTablero(juego.getTablero());
			
			area.setAreaNebulosaDeAndromeda(juego.getTablero());
			
			Algoformer mega = juego.getDecepticons().getMegatron();
			mega = juego.getDecepticons().getMegatron().cambiarModo();//Lo Paso a alterno
			
			Posicion pos = new Posicion(46,46);
			
			mega.mover(pos);
			
			Assert.assertTrue(mega.getEfecto().esperaturnos==3);
			
			juego.jugarTurno();
			
			
			Assert.assertTrue(mega.getEfecto().esperaturnos==2);
			
			juego.jugarTurno();juego.jugarTurno();
			Assert.assertTrue(mega.getEfecto().esperaturnos==1);
			juego.jugarTurno();juego.jugarTurno();
			
			Assert.assertTrue(mega.getEfecto().esperaturnos==0);
			
			//faltaria validar en juego que esperaturnos sea 0 para poder actuar sobre este algoformer;
			
	}
	
	
	
	
	
	
	
	
	//FIN OCTAVO TEST
	
	
	
	//INICIO NOVENO TEST
	@Test
	public void test36MegatronAlternoReduceSuAtaqueAlPasarPorTormentaPsionica(){
		
			Equipo autobots=new Decepticons();
			
			Tablero tab = new Tablero();
			Area area = new Area(15,20,15,20);			// Es un area de 12 x 4
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			Posicion.setTablero(tab);
			
			Algoformer algoformer = new MegatronAlterno();
			Algoformer optimus = new OptimusAlterno();
			algoformer.setEquipo(autobots);
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(16,16);
			Posicion posfinal2 =new Posicion(17,17); 
			Posicion posAux=new Posicion(18,18);
			tab.ubicarMovil(algoformer, posinicial);
			tab.ubicarMovil(optimus, posfinal);
			
			area.setAreaTormentaPsionica(tab);
			
			int vidaInicial = optimus.getVida();
			
			algoformer.atacar(optimus);
			Assert.assertTrue(optimus.getVida()==vidaInicial-55);	
			
			vidaInicial = optimus.getVida();
			optimus.mover(posfinal2);
			algoformer.mover(posfinal);
			algoformer.atacar(optimus);
			Assert.assertTrue(optimus.getVida()==vidaInicial-algoformer.getAtaque());	//Megatron ataca 55 normalmente
			
			vidaInicial=optimus.getVida();
			optimus.mover(posAux);
			algoformer.mover(posfinal2);
			algoformer.atacar(optimus);//GetAtaque devuelve el ataque menos el efecto, en el caso q lo haya.
			Assert.assertTrue(optimus.getVida()==vidaInicial-algoformer.getAtaque());	
			
	}
	
	
	
	
	
	//FIN NOVENO TEST//Decimo test incluido en noveno
}
