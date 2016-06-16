package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Bonecrusher;

import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Frenzy;

import Modelo.Megatron;

import Modelo.Movimiento;
import Modelo.Optimus;

import Modelo.Tablero;
import Modelo.Posicion;

public class FrenzyHumanoideTest {

	
	@Test
	public void test01FrenzyHumanoideAtacaEnemigoHumanoide(){
		Frenzy.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Optimus.getOptimus().cambiarModo();
		Frenzy.getFrenzy().cambiarModo();
		
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(frenzy,pos1);
		
		Algoformer optimus= Optimus.getOptimus() ;
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		frenzy.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02FrenzyHumanoideNoPuedeAtacarDecepticons(){
		Frenzy.ResetearInstancia();
		Bonecrusher.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer bonecrusher =  Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		frenzy.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03FrenzyHumanoideNoPuedeAtacarAutobotFueraDeRango(){
		Frenzy.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer frenzy=Frenzy.getFrenzy();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus= Megatron.getMegatron();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		frenzy.atacar(optimus);
		
	}
	
	@Test
	public void test04CambioFrenzyAModoAlterno(){
		
		Frenzy.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Frenzy.ResetearInstancia();
		Frenzy.getFrenzy().cambiarModo();//lo pongo en hum
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Frenzy.getFrenzy(), posIni);
		
	
		Assert.assertTrue(Frenzy.getFrenzy().getDistanciaDeAtaque()==5);
		
		Frenzy bone1=Frenzy.getFrenzy();
		
		Frenzy.getFrenzy().cambiarModo();
		
		
		
		Assert.assertTrue(Frenzy.getFrenzy().getDistanciaDeAtaque()==2);//en modo humanoide alcance==3
		
		
		
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06FrenzyHumanoideSeMueve(){
		Frenzy.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(frenzy,posIni);
		Posicion posFin=new Posicion(3,4);
		
		frenzy.mover(posFin);
	
		Assert.assertTrue(frenzy.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07FrenzyHumanoideTieneLimiteDeVelocidad(){
		Frenzy.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(frenzy,posIni);
		Posicion posFin=new Posicion(9,4);
		
		frenzy.mover(posFin);
	
	}
	
	@Test
	public void test08FrenzyHumanoideEsAtacadoPorEnemigoHumanoide(){
		Frenzy.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Frenzy.getFrenzy().cambiarModo();
		
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(frenzy, pos1);

		Optimus.getOptimus().cambiarModo();
		
		Algoformer optimus= Optimus.getOptimus();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(frenzy);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(frenzy.getVida()==350);
	}
	
	@Test
	public void test09FrenzyHumanoideAtacaEnemigoAlterno(){
		Frenzy.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Frenzy.getFrenzy().cambiarModo();
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		frenzy.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test
	public void test10FrenzyHumanoideEsAtacadoPorEnemigoAlterno(){
		Frenzy.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer frenzy = Frenzy.getFrenzy();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(frenzy, pos1);
		
		Algoformer optimus= Optimus.getOptimus();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(frenzy);
		
		Assert.assertTrue(frenzy.getVida()==385);
	}
}
