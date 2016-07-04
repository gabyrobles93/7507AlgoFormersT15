package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bonecrusher;
import modelo.Decepticons;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Tablero;

public class MegatronAlternoTest {

	@Test
	public void test01MegatronAlternoAtacaEnemigoHumanoide(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		
		Optimus.getOptimus().cambiarModo();
		Algoformer optimus= Optimus.getOptimus();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02MegatronAlternoNoPuedeAtacarDecepticons(){
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer bonecrusher =  Bonecrusher.getBonecrusher();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		megatron.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MegatronAlternoNoPuedeAtacarAutobotFueraDeRango(){
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus= Optimus.getOptimus();
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
	public void test06MegatronAlternoSeMueve(){
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer megatron =  Megatron.getMegatron();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(9,4);
		
		megatron.mover(posFin);
	
		Assert.assertTrue(megatron.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MegatronAlternoTieneLimiteDeVelocidad(){
		
		Megatron.ResetearInstancia();
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron =  Megatron.getMegatron();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(10,4);
		
		megatron.mover(posFin);
	
	}
	
	@Test
	public void test08MegatronAlternoEsAtacadoPorEnemigoHumanoide(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);


		Optimus.getOptimus().cambiarModo();
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(megatron);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(megatron.getVida()==500);
	}
	
	@Test
	public void test09MegatronAlternoAtacaEnemigoAlterno(){
		Megatron.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
		
	}
	
	@Test
	public void test10MegatronAlternoEsAtacadoPorEnemigoAlterno(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus =  Optimus.getOptimus();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);
	}
}
