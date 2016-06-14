package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;
import Modelo.BumblebeeHumanoide;
import Modelo.Decepticons;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;

public class OptimusHumaboideTest {

	@Test
	public void test01OptimusHumanoideAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = new OptimusHumanoide();
		/*optimus.setEquipo(autobots);*/
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(optimus,pos1);
		
		Algoformer megatron=new MegatronHumanoide();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==500);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02OptimusHumanoideNoPuedeAtacarAutobots(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		
		Algoformer optimus = new OptimusHumanoide();
	/*	optimus.setEquipo(autobots);	*/
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer bumblebee = new BumblebeeHumanoide();
		/*bumblebee.setEquipo(autobots);*/
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bumblebee, pos2);
		
		optimus.atacar(bumblebee);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03OptimusHumanoideNoPuedeAtacarDecepticonFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		
		Algoformer optimus = new OptimusHumanoide();
	/*	optimus.setEquipo(autobots);*/
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron=new MegatronHumanoide();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(megatron, pos2);
		
		optimus.atacar(megatron);	
		
	}
	
	@Test
	public void test04CambioOptimusAModoAlterno(){
		
		Algoformer optimus_hum=new OptimusHumanoide();
		Algoformer optimus_alt=new OptimusAlterno();
		
		Assert.assertTrue(optimus_alt.equals(optimus_hum.cambiarModo()));
	}
		
	@Test
	public void test06OptimusHumanoideSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer optimus = new OptimusHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(3,4);
		
		optimus.mover(posFin);
	
		Assert.assertTrue(optimus.getPosicion().equals(posFin));
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07OptimusHumanoideTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer optimus = new OptimusHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(optimus,posIni);
		Posicion posFin=new Posicion(4,4);
		
		optimus.mover(posFin);
	
	}
	
	@Test
	public void test08OptimusHumanoideEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer optimus = new OptimusHumanoide();
	/*	optimus.setEquipo(autobots);*/
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(optimus, pos1);


		
		Algoformer megatron = new MegatronHumanoide();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(megatron, pos2);	
		
		megatron.atacar(optimus);
		//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
		Assert.assertTrue(optimus.getVida()==490);
	}
	
	@Test
	public void test09OptimusHumanoideAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer optimus = new OptimusHumanoide();
	/*	optimus.setEquipo(autobots);*/
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron = new MegatronAlterno();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(megatron, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==500);	
		
	}
	
	@Test
	public void test10OptimusHumanoideEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Autobots autobots = new Autobots();
		Decepticons decepticons = new Decepticons();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer optimus = new OptimusHumanoide();
	/*	optimus.setEquipo(autobots);*/
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(optimus, pos1);
		
		Algoformer megatron = new MegatronAlterno();
	/*	megatron.setEquipo(decepticons);*/
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(megatron, pos2);
		
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==445);
	}
	
}
	
	
