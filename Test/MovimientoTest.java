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
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		
		Algoformer mega= new MegatronAlterno();
		Posicion pos2=new Posicion(3,4);
		tab.ubicarMovil(mega, pos);

		mega.mover(pos2);
	}
	
	@Test
	public void test02CreoMovimientoVerificoDistancia(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer mega=new MegatronAlterno();
		Posicion pos=new Posicion(1,1);
		
		tab.ubicarMovil(mega, pos);
		
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
	public void test04CreoMovimientoYAvanzoUnCasilleroEnElCaminoSurOeste(){
		
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
	public void test05CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorEste(){
		
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
	public void test06CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorOeste(){
		
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
	public void test07CreoMovimientoYAvanzoUnCasilleroEnElCaminoSur(){
		
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
	public void test08CreoMovimientoYAvanzoUnCasilleroEnElCaminoNorte(){
		
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
	public void test09CreoMovimientoYAvanzoUnCasilleroEnElCaminoEste(){
		
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
	public void test10CreoMovimientoYAvanzoUnCasilleroEnElCaminoOeste(){
		
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
	public void test11ValidarAlcance(){
		
		
		Posicion pos=new Posicion(1,1);
		
		Posicion pos2=new Posicion(20,20);
		
		Tablero tab= new Tablero();
		
		Movimiento.setTablero(tab);
		
		Algoformer mega=new MegatronAlterno();
		
		tab.ubicarMovil(mega, pos);
		
		Movimiento mov=Movimiento.crearMovimiento(mega, pos2);
	}
	@Test(expected=ErrorCasillerOcupado.class)
	public void test12CaminoInterrumpidoMovimientoDiagonalNoreste(){
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
	public void test13CaminoInterrumpidoMovimientoDiagonalNorOeste(){
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
	public void test14CaminoInterrumpidoMovimientoDiagonalSurEste(){
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
	public void test15CaminoInterrumpidoMovimientoDiagonalSurOeste(){
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
	public void test16CaminoInterrumpidoMovimientoVerticalSur(){
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
	public void test17CaminoInterrumpidoMovimientoVerticalNorte(){
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
	public void test18CaminoInterrumpidoMovimientoHorizontalEste(){
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
	public void test19CaminoInterrumpidoMovimientoHorizontalOeste(){
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
