package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.Ataque;
import Modelo.Autobots;

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
import Modelo.Posicion;
import Modelo.RatchetHumanoide;
import Modelo.Tablero;

public class FrenzyAlternoTest {
		
		@Test
		public void test01FrenzyAlternoAtacaEnemigoHumanoide(){

			Tablero tab=new Tablero();
			Autobots autobots = new Autobots();
			Decepticons decepticons = new Decepticons();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			
			Algoformer frenzy = new FrenzyAlterno();
			frenzy.setEquipo(decepticons);
			Posicion pos1  =new Posicion(3,3);
			tab.ubicarMovil(frenzy,pos1);
			
			Algoformer optimus=new OptimusHumanoide();
			optimus.setEquipo(autobots);
			Posicion pos2=new Posicion(3,5);
			tab.ubicarMovil(optimus,pos2);//Coloco enemigo a maxima distancia alcanzada
			
			frenzy.atacar(optimus);
			
			Assert.assertTrue(optimus.getVida()==475);
			
		}
		
		@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
		public void test02FrenzyAlternoNoPuedeAtacarDecepticons(){
			
			Tablero tab=new Tablero();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			Decepticons decepticons = new Decepticons();
			
			Algoformer frenzy = new FrenzyAlterno();
			frenzy.setEquipo(decepticons);	
			Posicion pos1 = new Posicion(3,3);
			tab.ubicarMovil(frenzy, pos1);
			
			Algoformer bonecrusher = new RatchetHumanoide();
			bonecrusher.setEquipo(decepticons);
			Posicion pos2=new Posicion(3,5);
			tab.ubicarMovil(bonecrusher, pos2);
			
			frenzy.atacar(bonecrusher);
			
		}
		
		@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
		public void test03FrenzyAlternoNoPuedeAtacarAutobotFueraDeRango(){

			Tablero tab=new Tablero();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			Autobots autobots = new Autobots();
			Decepticons decepticons = new Decepticons();
			
			Algoformer frenzy=new FrenzyAlterno();
			frenzy.setEquipo(decepticons);
			Posicion pos1 = new Posicion(2,0);
			tab.ubicarMovil(frenzy, pos1);
			
			Algoformer optimus=new MegatronHumanoide();
			optimus.setEquipo(autobots);
			Posicion pos2=new Posicion(6,0);
			tab.ubicarMovil(optimus, pos2);
			
			frenzy.atacar(optimus);
		}
		
		@Test
		public void test04CambioFrenzyAModoAlterno(){
			
			Algoformer frenzy_hum=new FrenzyHumanoide();
			Algoformer frenzy_alt=new FrenzyAlterno();
			
			Assert.assertTrue(frenzy_hum.equals(frenzy_alt.cambiarModo()));
		}
			
		@Test
		public void test06FrenzyAlternoSeMueve(){
			
			Tablero tab=new Tablero();
			Movimiento.setTablero(tab);
			Posicion.setTablero(tab);

			Algoformer frenzy = new FrenzyAlterno();
			Posicion posIni=new Posicion(1,4);
			tab.ubicarMovil(frenzy,posIni);
			Posicion posFin=new Posicion(6,4);
			
			frenzy.mover(posFin);
		
			Assert.assertTrue(frenzy.getPosicion().equals(posFin));
		
		}
		
		@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
		public void test07FrenzyAlternoTieneLimiteDeVelocidad(){
			
			Tablero tab=new Tablero();
			Movimiento.setTablero(tab);
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posIni=new Posicion(1,4);
			tab.ubicarMovil(frenzy,posIni);
			Posicion posFin=new Posicion(9,4);
			
			frenzy.mover(posFin);
		
		}
		
		@Test
		public void test08FrenzyAlternoEsAtacadoPorEnemigoHumanoide(){
			
			Tablero tab=new Tablero();
			Autobots autobots = new Autobots();
			Decepticons decepticons = new Decepticons();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);

			Algoformer frenzy = new FrenzyAlterno();
			frenzy.setEquipo(decepticons);
			Posicion pos1=new Posicion(2,2);
			tab.ubicarMovil(frenzy, pos1);


			
			Algoformer optimus=new OptimusHumanoide();
			optimus.setEquipo(autobots);
			Posicion pos2=new Posicion(2,3);
			tab.ubicarMovil(optimus, pos2);	
			
			optimus.atacar(frenzy);
			//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
			Assert.assertTrue(frenzy.getVida()==350);
		}
		
		@Test
		public void test09FrenzyAlternoAtacaEnemigoAlterno(){
			
			Tablero tab=new Tablero();
			Autobots autobots = new Autobots();
			Decepticons decepticons = new Decepticons();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			
			Algoformer frenzy = new FrenzyAlterno();
			frenzy.setEquipo(decepticons);
			Posicion pos1=new Posicion(3,4);
			tab.ubicarMovil(frenzy, pos1);
			
			Algoformer optimus = new OptimusAlterno();
			optimus.setEquipo(autobots);
			Posicion pos2=new Posicion(3,6);
			tab.ubicarMovil(optimus, pos2);//Coloco enemigo a maxima distancia alcanzada
			
			frenzy.atacar(optimus);
			
			Assert.assertTrue(optimus.getVida()==475);
			
		}
		
		@Test
		public void test10FrenzyAlternoEsAtacadoPorEnemigoAlterno(){
			
			Tablero tab=new Tablero();
			Autobots autobots = new Autobots();
			Decepticons decepticons = new Decepticons();
			Movimiento.setTablero(tab);
			Ataque.setTablero(tab);
			
			
			Algoformer frenzy = new FrenzyAlterno();
			frenzy.setEquipo(autobots);
			Posicion pos1=new Posicion(2,2);
			tab.ubicarMovil(frenzy, pos1);
			
			Algoformer optimus=new OptimusAlterno();
			optimus.setEquipo(decepticons);
			Posicion pos2=new Posicion(4,2);
			tab.ubicarMovil(optimus, pos2);
			
			
			optimus.atacar(frenzy);
			
			Assert.assertTrue(frenzy.getVida()==385);
		}

}
