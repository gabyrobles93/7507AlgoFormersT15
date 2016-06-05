package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Tablero;

public class MovimientoTest {

	
	@Test(expected=ErrorCasillerosNoConectadosPorLineaRecta.class)
	public void test01CrearMovimientoApartirDeDosPosicionesNoConectadasPorLineaRectaTiraExcep(){
		Posicion pos=new Posicion(1,1);
		
		Algoformer mega= new MegatronAlterno();
		
		mega.mover(pos);
		
		Posicion pos2=new Posicion(3,4);
		
		Movimiento mov=Movimiento.crearMovimiento(mega,pos2);
	}
	
	@Test
	public void test02CreoMovimientoVerificoDistancia(){
		
		Algoformer mega=new MegatronAlterno();
		Posicion pos=new Posicion(1,1);
		
		mega.mover(pos);
		Posicion pos2=new Posicion(3,3);
		
		
		Movimiento mov=Movimiento.crearMovimiento(mega,pos2);
		
		Assert.assertTrue(mov.getDistancia()==2);
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCamino(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(2,2);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test04ValidarAlcance(){
		
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(20,20);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
	}
}
