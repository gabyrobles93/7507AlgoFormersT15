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
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;

public class MegatronAlternoTest {

	@Test
	public void test01MegatronAlternoAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02MegatronAlternoNoPuedeAtacarDecepticons(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Decepticons decepticons = new Decepticons();
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);	
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer bonecrusher = new RatchetHumanoide();
		bonecrusher.setEquipo(decepticons);
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		megatron.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MegatronAlternoNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus=new MegatronHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		megatron.atacar(optimus);
	}
	
	@Test
	public void test04CambioMegatronAModoAlterno(){
		
		Algoformer mega_hum=new MegatronHumanoide();
		Algoformer mega_alt=new MegatronAlterno();
		
		Assert.assertTrue(mega_hum.equals(mega_alt.cambiarModo()));
	}
		
	@Test
	public void test06MegatronAlternoSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron = new MegatronAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(9,4);
		
		megatron.mover(posFin);
	
		Assert.assertTrue(megatron.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MegatronAlternoTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron = new MegatronAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(10,4);
		
		megatron.mover(posFin);
	
	}
	
	@Test
	public void test08MegatronAlternoEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);


		
		Algoformer optimus = new OptimusHumanoide();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(megatron);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(megatron.getVida()==500);
	}
	
	@Test
	public void test09MegatronAlternoAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(decepticons);
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		optimus.setEquipo(autobots);
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
		
	}
	
	@Test
	public void test10MegatronAlternoEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer megatron = new MegatronAlterno();
		megatron.setEquipo(autobots);
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		optimus.setEquipo(decepticons);
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);
	}
}
