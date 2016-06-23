package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.Bumblebee;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.Megatron;
import Modelo.Movimiento;
import Modelo.Optimus;
import Modelo.Posicion;

import Modelo.Tablero;


public class OptimusHumaboideTest {

	@Test
	public void test01OptimusHumanoideAtacaEnemigoHumanoide(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Posicion.setTablero(tab);
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();//paso a humanoide
		Algoformer optimus = Optimus.getOptimus();
		
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		
		Megatron.getMegatron().cambiarModo();
		
		Algoformer megatron= Megatron.getMegatron();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==500);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02OptimusHumanoideNoPuedeAtacarAutobots(){
		Optimus.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(optimus, pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee = Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		optimus.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03OptimusHumanoideNoPuedeAtacarDecepticonFueraDeRango(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(megatron, pos2);
		
		optimus.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioOptimusAModoAlterno(){
		Optimus.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Optimus.getOptimus().cambiarModo();
		
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Optimus.getOptimus(), posIni);
		
	
		Assert.assertTrue( Optimus.getOptimus().getDistanciaDeAtaque()==2);
		
		Optimus mega1=Optimus.getOptimus();
		
		Optimus.getOptimus().cambiarModo();
		
		
		
		Assert.assertTrue(Optimus.getOptimus().getDistanciaDeAtaque()==4);//
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06OptimusHumanoideSeMueve(){
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer optimus = Optimus.getOptimus();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(3,4);
		
		optimus.mover(posFin);
	
		Assert.assertTrue(optimus.getPosicion().equals(posFin));
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07OptimusHumanoideTieneLimiteDeVelocidad(){
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Ataque.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();//paso a humanoide
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(4,4);
		
		optimus.mover(posFin);
	
	}
	
	@Test
	public void test08OptimusHumanoideEsAtacadoPorEnemigoHumanoide(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(optimus, pos1);


		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(optimus);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(optimus.getVida()==490);
	}
	
	@Test
	public void test09OptimusHumanoideAtacaEnemigoAlterno(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Optimus.getOptimus().cambiarModo();
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron =Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==500);	
		
	}
	
	@Test
	public void test10OptimusHumanoideEsAtacadoPorEnemigoAlterno(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
	}
	
}
	
	
