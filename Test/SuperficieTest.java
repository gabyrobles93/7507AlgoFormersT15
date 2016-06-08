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
			Area arearocosa = new AreaRocosa(5,5);			// Area de superficie rocosa de 5 x 5 casilleros
			Movimiento.setTablero(tab);;
			Algoformer optimus = new OptimusHumanoide();
			Posicion posinicial = new Posicion(15,15);
			
			arearocosa.setSuperficieRocosa();
			
			
			
			tab.ubicarMovil(optimus, posinicial);
	}
	
}
