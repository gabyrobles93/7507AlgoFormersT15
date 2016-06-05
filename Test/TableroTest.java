package Test;

import org.junit.Assert;
import Modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import Modelo.ErrorVelocidadDelMovilInsuficiente;

import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorAreaFueraDeRangoPosible;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.Tablero;


public class TableroTest {

	
	@Test
	public void test01AgregoAlgoformerAtableroYloBusco() {
		
		Tablero tablero1=new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Posicion unaPos=new Posicion(1,2);
		tablero1.ubicarMovil(megatron,unaPos);
		
		Assert.assertTrue(tablero1.existeMovil(megatron));
		Assert.assertTrue(megatron.getPosicion()==unaPos);
		
	}
	
	@Test
	public void test02MuevoAlgoformerYverificoPosicion(){
		
		Tablero unTablero =new Tablero();
		Posicion unaPos=new Posicion(1,1);
		Posicion otraPos=new Posicion(2,2);
		Algoformer megatron=new MegatronAlterno();
		unTablero.ubicarMovil(megatron,unaPos);
		unTablero.moverMovil(megatron,otraPos);
		Assert.assertTrue(megatron.getPosicion()==otraPos);
	
	}
	
	@Test (expected=ErrorCasillerosNoConectadosPorLineaRecta.class)
	public void test06movimientoPosibleArrojaExcepcionSiLosCasillerosNoEstanEnLinea(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Posicion unaPos=new Posicion(1,1);
		Posicion otraPos=new Posicion(3,5);
		unTablero.ubicarMovil(megatron,unaPos);
		unTablero.moverMovil(megatron,otraPos);
	}	

	@Test
	public void test03CaminoInterrumpidoMovimientoDiagonal(){

		Tablero unTablero =new Tablero();
		Posicion unaPos=new Posicion(1,1);
		Posicion otraPos=new Posicion(2,2);
		Posicion posDestino1=new Posicion(3,3);
		Posicion posDestino2=new Posicion(0,0);
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		unTablero.ubicarMovil(megatron2,unaPos);
		unTablero.ubicarMovil(megatron,otraPos);
	
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, posDestino1));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, posDestino2));
		// megatron2 se puede mover a 0,0 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, otraPos));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;


}

@Test
public void test76ObtengoSubAreaYverificoEstarReferenciandoLosmismosCasilleros(){
	Tablero tablero1 =new Tablero();
	Algoformer megatron=new MegatronHumanoide();
	Algoformer optimus=new OptimusHumanoide();
	Posicion unaPos=new Posicion(2,2);
	Posicion otraPos=new Posicion(5,5);
	tablero1.ubicarMovil(megatron, unaPos);
	tablero1.ubicarMovil(optimus, otraPos);
	Tablero subTablero=tablero1.getArea(unaPos, 2);
	Assert.assertTrue(subTablero.existeMovil(megatron));
	Assert.assertFalse(subTablero.existeMovil(optimus));
}
@Test(expected=ErrorAreaFueraDeRangoPosible.class)
public void test88getAreaArrojaExcepcionSiNoEstaContenidaEnElTablero(){
	Tablero tablero1=new Tablero();
	Posicion pos=new Posicion(3,3);
	tablero1.getArea(pos, 4);

	}

	@Test
	public void test04CaminoInterrumpidoMovimientoVertical(){

	
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		Posicion pos2=new Posicion(3,3);
		Posicion pos1=new Posicion(2,3);
		unTablero.ubicarMovil(megatron2,pos2);
		unTablero.ubicarMovil(megatron,pos1);
	
		Posicion posDestino1=new Posicion(1,3);
		Posicion posDestino2=new Posicion(4,3);
		Posicion posDestino3=new Posicion(2,3);
		
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, posDestino1));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, posDestino2));
		// megatron2 se puede mover a 2,3 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, posDestino3));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
	}

	@Test
	public void test03CaminoInterrumpidoMovimientoHorizontal(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Algoformer megatron2=new MegatronAlterno();
		
		Posicion pos2=new Posicion(5,5);
		Posicion pos1=new Posicion(5,4);
		
		unTablero.ubicarMovil(megatron2,pos2);
		unTablero.ubicarMovil(megatron,pos1);
		
		
		

		Posicion posDestino1=new Posicion(5,3);
		Posicion posDestino2=new Posicion(5,6);
		Posicion posDestino3=new Posicion(5,4);
		
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, posDestino1));
		// megatron se encuentra en el medio, megatron 2 nopuede ir en esa direcc
		Assert.assertTrue(unTablero.movimientoPosible(megatron2, posDestino2));
		// megatron se puede mover a 2,3 
		Assert.assertFalse(unTablero.movimientoPosible(megatron2, posDestino3));
		// megatron esta en 2,2, entonces megatron2 no puede moverse ahi;
	}
	

	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test56movimientoPosibleLanzaExcepVelocidadDelAlgoformerInsuficiente(){
		Tablero unTablero =new Tablero();
		Algoformer megatron=new MegatronAlterno();
		Posicion pos=new Posicion(1,1);
		Posicion pos2=new Posicion(20,20);
		unTablero.ubicarMovil(megatron,pos);
		unTablero.moverMovil(megatron,pos2);
	}



	@Test(expected=ErrorAreaFueraDeRangoPosible.class)
	public void test89getAreaArrojaExcepcionSiNoEstaContenidaEnElTablero(){
		Tablero tablero1=new Tablero();
		Posicion pos=new Posicion(3,3);
		tablero1.getArea(pos, 4);
		
	}
	
	@Test(expected=ErrorAreaFueraDeRangoPosible.class)
	public void test90getAreaArrojaExcepcionSiNoEstaContenidaEnElTablero(){
		Tablero tablero1=new Tablero();
		Posicion pos=new Posicion(48,49);
		tablero1.getArea(pos, 2);
	
	}
	
	
}
