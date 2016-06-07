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
import Modelo.ErrorCasillerOcupado;

public class MovimientoTest {

	
	@Test(expected=ErrorCasillerosNoConectadosPorLineaRecta.class)
	public void test01CrearMovimientoApartirDeDosPosicionesNoConectadasPorLineaRectaTiraExcep(){
		Posicion pos=new Posicion(1,1);
		
		Algoformer mega= new MegatronAlterno();
		
		mega.cambiarPosicion(pos);
		
		Posicion pos2=new Posicion(3,4);
		
		Movimiento mov=Movimiento.crearMovimiento(mega,pos2);
	}
	
	@Test
	public void test02CreoMovimientoVerificoDistancia(){
		
		Algoformer mega=new MegatronAlterno();
		Posicion pos=new Posicion(1,1);
		
		mega.cambiarPosicion(pos);
		
		Posicion pos2=new Posicion(3,3);
		
		
		Movimiento mov=Movimiento.crearMovimiento(mega,pos2);
		
		Assert.assertTrue(mov.getDistancia()==2);
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoSurEste(){
		
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
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoSurOeste(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(2,0);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorEste(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(0,2);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorOeste(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(0,0);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoSur(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(2,1);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorte(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(1,0);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoEste(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(1,2);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
		
		mov.Avanzar();
		
		Assert.assertTrue(mega.getPosicion().equals(pos2));
		
		
		
	}
	@Test
	public void test03CreoMovimientoYAvanzoUnCasilleroEnElCaminoOeste(){
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(0,1);
		
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
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoDiagonalNoreste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(2,2);
		
		Posicion pos2=new Posicion(1,3);
		
		Posicion pos3=new Posicion(0,4);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoDiagonalNorOeste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(2,2);
		
		Posicion pos2=new Posicion(1,1);
		
		Posicion pos3=new Posicion(0,0);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoDiagonalSurEste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(1,1);
		
		Posicion pos2=new Posicion(2,2);
		
		Posicion pos3=new Posicion(3,3);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoDiagonalSurOeste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(2,2);
		
		Posicion pos2=new Posicion(3,1);
		
		Posicion pos3=new Posicion(4,0);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoVerticalSur(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(1,1);
		
		Posicion pos2=new Posicion(2,1);
		
		Posicion pos3=new Posicion(3,1);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
		
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoVerticalNorte(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(3,1);
		
		Posicion pos2=new Posicion(2,1);
		
		Posicion pos3=new Posicion(1,1);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
		
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoHorizontalEste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(1,1);
		
		Posicion pos2=new Posicion(1,2);
		
		Posicion pos3=new Posicion(1,3);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test05CaminoInterrumpidoMovimientoHorizontalOeste(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion pos1=new Posicion(1,3);
		
		Posicion pos2=new Posicion(1,2);
		
		Posicion pos3=new Posicion(1,1);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos1);
		
		Algoformer mega2=new MegatronAlterno();
		
		tab.ubicarMovil(mega2, pos2);
		
		Movimiento.crearMovimiento(mega, pos3); //mega2 esta en el medio
		
	}
}
