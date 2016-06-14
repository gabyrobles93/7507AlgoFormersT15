package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BonecrusherHumanoide;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;
import Modelo.Posicion;

public class FrenzyHumanoideTest {

	
	@Test
	public void test01FrenzyHumanoideAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy = new FrenzyHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(frenzy,pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		frenzy.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02FrenzyHumanoideNoPuedeAtacarDecepticons(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy = new FrenzyHumanoide();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer bonecrusher = new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		frenzy.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03FrenzyHumanoideNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy=new FrenzyHumanoide();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus=new MegatronHumanoide();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		frenzy.atacar(optimus);
		
	}
	
	@Test
	public void test04CambioFrenzyAModoAlterno(){
		
		Algoformer frenzy_hum=new FrenzyHumanoide();
		Algoformer frenzy_alt=new FrenzyAlterno();
		
		Assert.assertTrue(frenzy_alt.equals(frenzy_hum.cambiarModo()));
	}
		
	@Test
	public void test06FrenzyHumanoideSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer frenzy = new FrenzyHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(frenzy,posIni);
		Posicion posFin=new Posicion(3,4);
		
		frenzy.mover(posFin);
	
		Assert.assertTrue(frenzy.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07FrenzyHumanoideTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer frenzy = new FrenzyHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(frenzy,posIni);
		Posicion posFin=new Posicion(9,4);
		
		frenzy.mover(posFin);
	
	}
	
	@Test
	public void test08FrenzyHumanoideEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer frenzy = new FrenzyHumanoide();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(frenzy, pos1);


		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(frenzy);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(frenzy.getVida()==350);
	}
	
	@Test
	public void test09FrenzyHumanoideAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy = new FrenzyHumanoide();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		frenzy.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test
	public void test10FrenzyHumanoideEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer frenzy = new FrenzyHumanoide();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus=new OptimusAlterno();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(frenzy);
		
		Assert.assertTrue(frenzy.getVida()==385);
	}
}
