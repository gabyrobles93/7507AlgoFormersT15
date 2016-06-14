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
import Modelo.MegatronAlterno;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Posicion;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;

public class MegatronHumanoideTest{
	
	@Test
	public void test01MegatronHumanoideAtacaEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(megatron,pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02MegatronHumanoideNoPuedeAtacarDecepticons(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer bonecrusher = new BonecrusherHumanoide();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(bonecrusher, pos2);
		
		megatron.atacar(bonecrusher);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03MegatronHumanoideNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus=new OptimusHumanoide();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(optimus, pos2);
		
		megatron.atacar(optimus);
	}
	
	@Test
	public void test04CambioMegatronAModoAlterno(){
		
		Algoformer mega_hum=new MegatronHumanoide();
		Algoformer mega_alt=new MegatronAlterno();
		Assert.assertTrue(mega_alt.equals(mega_hum.cambiarModo()));
	}
		
	@Test
	public void test06MegatronHumanoideSeMueve(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);

		Algoformer megatron = new MegatronHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(1,5);
		
		megatron.mover(posFin);
	
		Assert.assertTrue(megatron.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07MegatronHumanoideTieneLimiteDeVelocidad(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer megatron = new MegatronHumanoide();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(megatron,posIni);
		Posicion posFin=new Posicion(1,6);
		
		megatron.mover(posFin);
	
	}
	
	@Test
	public void test08MegatronHumanoideEsAtacadoPorEnemigoHumanoide(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);


		
		Algoformer optimus = new OptimusHumanoide();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(optimus, pos2);	
		
		optimus.atacar(megatron);
		
		//como megatron tiene vida 550 y optimus 50 de ataque le deben quedar 500
		Assert.assertTrue(megatron.getVida()==500);
	}
	
	@Test
	public void test09MegatronHumanoideAtacaEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1=new Posicion(3,4);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		megatron.atacar(optimus);
		
		Assert.assertTrue(optimus.getVida()==490);
		
	}
	
	@Test
	public void test10MegatronHumanoideEsAtacadoPorEnemigoAlterno(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer megatron = new MegatronHumanoide();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(megatron, pos1);
		
		Algoformer optimus = new OptimusAlterno();
		Posicion pos2=new Posicion(4,2);
		tab.ubicarMovil(optimus, pos2);
		
		
		optimus.atacar(megatron);
		
		Assert.assertTrue(megatron.getVida()==535);
	}
	

	

}
