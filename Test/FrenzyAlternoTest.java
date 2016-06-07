package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.FrenzyAlterno;
import Modelo.FrenzyHumanoide;
import Modelo.Posicion;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;

public class FrenzyAlternoTest {
		
		@Test
		public void test01FrenzyAlternoAtacaEnemigoHumanoide(){
			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(3,3);
			frenzy.setPosicion(pos1);
			Algoformer ratchet=new RatchetHumanoide();
			Posicion pos2=new Posicion(8,3);
			ratchet.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
			
			frenzy.atacar(ratchet);
			
			//como Ratchet tiene vida 150 y Frenzy 10 de ataque le deben quedar 140
			Assert.assertTrue(ratchet.getVida()==140);
			
		}
		
		@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
		public void test02FrenzyAlternoNoPuedeAtacarDecepticons(){
			
			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(3,3);
			frenzy.setPosicion(pos1);
			Algoformer bone=new BonecrusherHumanoide();
			Posicion pos2=new Posicion(3,8);
			bone.setPosicion(pos2);
			
			frenzy.atacar(bone);
			
		}
		
		@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
		public void test03FrenzyAlternoNoPuedeAtacarAutobotFueraDeRango(){

			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(2,0);
			frenzy.setPosicion(pos1);
			Algoformer ratchet=new RatchetHumanoide();
			Posicion pos2=new Posicion(2,9);
			ratchet.setPosicion(pos2);
			
			frenzy.atacar(ratchet);
		}
		
		@Test
		public void test04CambioFrenzyAModoAlterno(){
			
			Algoformer frenzy_hum=new FrenzyHumanoide();
			Algoformer frenzy_alt=new FrenzyAlterno();
			
			Assert.assertTrue(frenzy_hum.equals(frenzy_alt.cambiarModo()));
		}
			
		@Test
		public void test06FrenzyAlternoSeMueve(){
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posIni=new Posicion(1,4);
			frenzy.setPosicion(posIni);
			Posicion posFin=new Posicion(2,5);
			
			frenzy.mover(posFin);
		
			Assert.assertTrue(frenzy.getPosicion()==posFin);
		
		}
		
		@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
		public void test07FrenzyAlternoTieneLimiteDeVelocidad(){
			Algoformer frenzy = new FrenzyAlterno();
			Posicion posIni=new Posicion(1,4);
			frenzy.setPosicion(posIni);
			Posicion posFin=new Posicion(2,6);
			
			frenzy.mover(posFin);
		
		}
		
		@Test
		public void test08FrenzyAlternoEsAtacadoPorEnemigoHumanoide(){
			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(2,2);
			frenzy.setPosicion(pos1);
			Algoformer ratchet=new RatchetHumanoide();
			Posicion pos2=new Posicion(2,4);
			ratchet.setPosicion(pos2);
			
			ratchet.atacar(frenzy);
			
			//como Frenzy tiene vida 400 y Ratchet 5 de ataque le deben quedar 395
			Assert.assertTrue(frenzy.getVida()==395);
		}
		
		@Test
		public void test09FrenzyAlternoAtacaEnemigoAlterno(){
			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(3,3);
			frenzy.setPosicion(pos1);
			Algoformer ratchet=new RatchetAlterno();
			Posicion pos2=new Posicion(5,6);
			ratchet.setPosicion(pos2);//Coloco enemigo a maxima distancia alcanzada
			
			frenzy.atacar(ratchet);
			
			//como Ratchet tiene vida 150 y Frenzy 10 de ataque le deben quedar 140
			Assert.assertTrue(ratchet.getVida()==140);
			
		}
		
		@Test
		public void test10FrenzyAlternoEsAtacadoPorEnemigoAlterno(){
			Algoformer frenzy=new FrenzyAlterno();
			Posicion pos1=new Posicion(2,2);
			frenzy.setPosicion(pos1);
			Algoformer ratchet=new RatchetAlterno();
			Posicion pos2=new Posicion(2,4);
			ratchet.setPosicion(pos2);
			
			ratchet.atacar(frenzy);
			
			//como Frenzy tiene vida 400 y Ratchet 35 de ataque le deben quedar 365
			Assert.assertTrue(frenzy.getVida()==365);
		}

}
