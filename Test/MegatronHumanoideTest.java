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
import Modelo.Megatron;

import Modelo.Movimiento;
import Modelo.Optimus;

import Modelo.Posicion;

import Modelo.Tablero;

public class MegatronHumanoideTest{
	
	@Test
	public void test01MegatronHumanoideAtacaEnemigoHumanoide(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		
		Algoformer optimus= Optimus.getOptimus();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02MegatronHumanoideNoPuedeAtacarDecepticons(){
		Megatron.ResetearInstancia();
		Bonecrusher.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer bonecrusher =Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		megatron.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MegatronHumanoideNoPuedeAtacarAutobotFueraDeRango(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus=Optimus.getOptimus();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		megatron.atacar(optimus);
	}
	
	@Test
	public void test04CambioMegatronAModoAlterno(){
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Megatron.ResetearInstancia();
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Megatron.getMegatron(), posIni);
		
	
		Assert.assertTrue( Megatron.getMegatron().getDistanciaDeAtaque()==2);
		
		Megatron mega1=Megatron.getMegatron();
		
		Megatron.getMegatron().cambiarModo();
		
		
		
		Assert.assertTrue(Megatron.getMegatron().getDistanciaDeAtaque()==3);//en modo humanoide alcance==3
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
		
	}
		
	@Test
	public void test06MegatronHumanoideSeMueve(){
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(1,5);
		
		megatron.mover(posFin);
	
		Assert.assertTrue(megatron.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MegatronHumanoideTieneLimiteDeVelocidad(){
		Megatron.ResetearInstancia();
		
		Megatron.getMegatron().cambiarModo();
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron = Megatron.getMegatron();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(1,6);
		
		megatron.mover(posFin);
	
	}
	
	@Test
	public void test08MegatronHumanoideEsAtacadoPorEnemigoHumanoide(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Optimus.getOptimus().cambiarModo();
		
		Algoformer megatron = Megatron.getMegatron();
		
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);

		
		Algoformer optimus =  Optimus.getOptimus();
		
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(megatron);
		
		//como megatron tiene vida 550 y optimus 50 de ataque le deben quedar 500
		Assert.assertTrue(megatron.getVida()==500);
	}
	
	@Test
	public void test09MegatronHumanoideAtacaEnemigoAlterno(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test
	public void test10MegatronHumanoideEsAtacadoPorEnemigoAlterno(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);
	}
	

	

}
