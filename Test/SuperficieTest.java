package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Movimiento;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.Tablero;


public class SuperficieTest {

	@Test
	public void test01optimusHumanoideTransitaSinProblemasPorSuperficieRocosa(){
		
			Tablero tab = new Tablero();
			Area arearocosa = new AreaRocosa(13,17,13,17);			// Es un area de 5 x 5
			Movimiento.setTablero(tab);;
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,15);
			Posicion posfinal = new Posicion(15,17);
			
			tab.setAreaDeSuperficie(arearocosa); // El area en las posiciones indicadas por arearocosa se copia tal cual en el tablero.
			
			tab.ubicarMovil(optimus, posinicial);
			
			optimus.mover(posfinal);
			
			Assert.assertTrue(optimus.getPosicion().equals(posfinal));
	}
	
}
