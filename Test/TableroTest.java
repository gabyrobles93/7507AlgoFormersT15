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
		Assert.assertTrue(tablero1.getCasillero(1,2)==megatron.getPosicion());
	}
	

	
	

	
}
