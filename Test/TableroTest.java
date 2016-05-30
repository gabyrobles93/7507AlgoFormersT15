package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.AlgoFormer;

import Modelo.MegatronAlterno;
import Modelo.Tablero;


public class TableroTest {

	
	@Test
	public void test01AgregoAlgoformerAtableroYloBusco() {
		
		Tablero tablero1=new Tablero();
		AlgoFormer megatron=new MegatronAlterno();
		tablero1.ubicarAlgoformer(megatron,1,2);
		
		Assert.assertTrue(tablero1.existeAlgoFormer(megatron));
		Assert.assertTrue(megatron.getFila()==1&&megatron.getColumna()==2);
	}
@Test
public void test02MuevoAlgoformerYverificoPosicion(){
	Tablero unTablero =new Tablero();
	AlgoFormer megatron=new MegatronAlterno();
	unTablero.ubicarAlgoformer(megatron,1,2);
	unTablero.moverAlgoformer(megatron,20,20);
	
}
@Test
public void test03CaminoInterrumpidoMovimientoDiagonal(){
	Tablero unTablero =new Tablero();
	AlgoFormer megatron=new MegatronAlterno();
	AlgoFormer megatron2=new MegatronAlterno();
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
	AlgoFormer megatron=new MegatronAlterno();
	AlgoFormer megatron2=new MegatronAlterno();
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
	AlgoFormer megatron=new MegatronAlterno();
	AlgoFormer megatron2=new MegatronAlterno();
	unTablero.ubicarAlgoformer(megatron2,5,5);
	unTablero.ubicarAlgoformer(megatron,5,4);
	
	Assert.assertFalse(unTablero.movimientoPosible(megatron2, 5, 3));
	// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
	Assert.assertTrue(unTablero.movimientoPosible(megatron, 5, 6));
	// megatron se puede mover a 2,3 
	Assert.assertFalse(unTablero.movimientoPosible(megatron2, 5, 4));
	// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
}
	
}
