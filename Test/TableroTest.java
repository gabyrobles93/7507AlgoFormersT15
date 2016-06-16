package Test;

import org.junit.Assert;
import Modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Megatron;

import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorAreaFueraDeRangoPosible;

import Modelo.Optimus;

import Modelo.Posicion;
import Modelo.Tablero;


public class TableroTest {

	
	@Test
	public void test01AgregoAlgoformerAtableroYloBusco() {
		
		Tablero tablero1=new Tablero();
		Algoformer megatron= Megatron.getMegatron();
		Posicion unaPos=new Posicion(1,2);
		tablero1.ubicarMovil(megatron,unaPos);
		
		Assert.assertTrue(tablero1.existeMovil(megatron));
		Assert.assertTrue(megatron.getPosicion()==unaPos);
		
	}
	

	


	

@Test
public void test76ObtengoSubAreaYverificoEstarReferenciandoLosmismosCasilleros(){
	Tablero tablero1 =new Tablero();
	Megatron.getMegatron().cambiarModo();
	Algoformer megatron= Megatron.getMegatron();
	Optimus.getOptimus().cambiarModo();
	Algoformer optimus=Optimus.getOptimus();
	Posicion unaPos=new Posicion(2,2);
	Posicion otraPos=new Posicion(5,5);
	tablero1.ubicarMovil(megatron, unaPos);
	tablero1.ubicarMovil(optimus, otraPos);
	Tablero subTablero=tablero1.getArea(unaPos, 2);
	
	Assert.assertTrue(subTablero.existeMovil(megatron));
	Assert.assertFalse(subTablero.existeMovil(optimus));
}
@Test
public void test88getAreaReferenciaHastaDondePuede(){
	Tablero tablero1=new Tablero();
	Posicion pos=new Posicion(3,3);
	Megatron.getMegatron().cambiarModo();
	Megatron mega=Megatron.getMegatron();
	tablero1.ubicarMovil(mega, pos);
	Tablero subtab=tablero1.getArea(pos, 4);
	
	Assert.assertTrue(tablero1.existeMovil(mega));
	Assert.assertTrue(subtab.existeMovil(mega));

	}



	







	
	
}
