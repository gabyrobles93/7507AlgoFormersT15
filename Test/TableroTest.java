package Test;

import org.junit.Assert;
import Modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import Modelo.ErrorVelocidadDelAlgoformerInsuficiente;

import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorAreaFueraDeRangoPosible;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Tablero;


public class TableroTest {

	
	@Test
	public void test01AgregoAlgoformerAtableroYloBusco() {
		
		Tablero tablero1=new Tablero();
		Algoformer megatron=new MegatronAlterno();
		tablero1.ubicarAlgoformer(megatron,1,2);
		
		Assert.assertTrue(tablero1.existeAlgoformer(megatron));
		Assert.assertTrue(megatron.getFila()==1&&megatron.getColumna()==2);
	}
	
	@Test
	public void test02MuevoAlgoformerYverificoPosicion(){
		
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron,1,1);
		unTablero.moverAlgoformer(megatron,2,2);
		Assert.assertTrue(megatron.getFila()==2&&megatron.getColumna()==2);
	
	}
	
	@Test (expected=ErrorCasillerosNoConectadosPorLineaRecta.class)
	public void test06movimientoPosibleArrojaExcepcionSiLosCasillerosNoEstanEnLinea(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron,1,1);
		unTablero.moverAlgoformer(megatron,3,5);
	}	

	@Test
	public void test03CaminoInterrumpidoMovimientoDiagonal(){

		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron2,1,1);
		unTablero.ubicarAlgoformer(megatron,2,2);
	
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 3, 3));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, 0, 0));
		// megatron2 se puede mover a 0,0 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 2, 2));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
	
	}

	@Test
	public void test04CaminoInterrumpidoMovimientoVertical(){
	
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron2,3,3);
		unTablero.ubicarAlgoformer(megatron,2,3);
	
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 1, 3));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, 4, 3));
		// megatron2 se puede mover a 2,3 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 2, 3));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
	}

	@Test
	public void test03CaminoInterrumpidoMovimientoHorizontal(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron2,5,5);
		unTablero.ubicarAlgoformer(megatron,5,4);
		
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 5, 3));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, 5, 6));
		// megatron se puede mover a 2,3 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, 5, 4));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
	}
	

	@Test(expected=ErrorVelocidadDelAlgoformerInsuficiente.class)
	public void test56movimientoPosibleLanzaExcepVelocidadDelAlgoformerInsuficiente(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		unTablero.ubicarAlgoformer(megatron,1,1);
		unTablero.moverAlgoformer(megatron,20,20);
	}

	@Test
	public void test76ObtengoSubAreaYverificoEstarReferenciandoLosmismosCasilleros(){
		Tablero tablero1 =new Tablero();
		Algoformer megatron=new MegatronHumanoide();
		tablero1.ubicarAlgoformer(megatron, 2, 2);
		Tablero subTablero=tablero1.getArea(2, 2, 2);
		Assert.assertTrue(subTablero.existeAlgoformer(megatron));
	}

	@Test(expected=ErrorAreaFueraDeRangoPosible.class)
	public void test89getAreaArrojaExcepcionSiNoEstaContenidaEnElTablero(){
		Tablero tablero1=new Tablero();
		tablero1.getArea(3, 3, 4);
		
	}
	
	@Test(expected=ErrorAreaFueraDeRangoPosible.class)
	public void test90getAreaArrojaExcepcionSiNoEstaContenidaEnElTablero(){
		Tablero tablero1=new Tablero();
		tablero1.getArea(48, 49, 2);
	
	}
	
	
}
