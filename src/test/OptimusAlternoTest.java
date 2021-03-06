package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.Equipo;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Tablero;

public class OptimusAlternoTest {
	
	@Test
	public void test01OptimusAlternoAtacaEnemigoHumanoide(){

		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		Megatron.getMegatron().cambiarModo();
		Algoformer megatron=Megatron.getMegatron();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02OptimusAlternoNoPuedeAtacarAutobots(){
		Optimus.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);

	
		
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		Bumblebee.getBumblebee().setEquipo(autobots);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(optimus, pos1);
		Bumblebee.getBumblebee().cambiarModo();
		Algoformer bumblebee =  Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		optimus.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03OptimusAlternoNoPuedeAtacarDecepticonFueraDeRango(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		

		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
		Optimus.getOptimus().cambiarModo();
		
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
		

	
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
		Optimus.getOptimus().cambiarModo();
		
		
		
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Optimus.getOptimus(), posIni);
		
	
		Assert.assertTrue( Optimus.getOptimus().getDistanciaDeAtaque()==2);
		
		Optimus mega1=Optimus.getOptimus();
		
		Optimus.getOptimus().cambiarModo();
		
		
		
		Assert.assertTrue(Optimus.getOptimus().getDistanciaDeAtaque()==4);//en modo humanoide alcance==3
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test06OptimusAlternoSeMueve(){
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer optimus = Optimus.getOptimus();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(6,4);
		
		optimus.mover(posFin);
	
		Assert.assertTrue(optimus.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07OptimusAlternoTieneLimiteDeVelocidad(){
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero(50);
		Movimiento.setTablero(tab);
		Algoformer optimus = Optimus.getOptimus();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(7,4);
		
		optimus.mover(posFin);
	
	}
	
	@Test
	public void test08OptimusAlternoEsAtacadoPorEnemigoHumanoide(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);


		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
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
	public void test09OptimusAlternoAtacaEnemigoAlterno(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);

		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);	
	}
	
	@Test
	public void test10OptimusAlternoEsAtacadoPorEnemigoAlterno(){
		Optimus.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);

		Equipo decepticons=new Decepticons();
		Megatron.getMegatron().setEquipo(decepticons);
		Equipo autobots=new Autobots();
		Optimus.getOptimus().setEquipo(autobots);
		
		Algoformer optimus = Optimus.getOptimus();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron = Megatron.getMegatron();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
	}
	

}
