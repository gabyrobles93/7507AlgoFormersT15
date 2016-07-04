package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Ataque;
import modelo.Autobots;
import modelo.Bonecrusher;
import modelo.Bumblebee;
import modelo.Decepticons;
import modelo.ErrorDistanciaDeAtaqueInsuficiente;
import modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Movimiento;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Tablero;

public class BonecrusherAlternoTest {
	
	@Test
	public void test01BonecrusherAlternoAtacaEnemigoHumanoide(){
		Bonecrusher.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bonecrusher =  Bonecrusher.getBonecrusher();
		Posicion pos1  =new Posicion(3,3);
		tab.ubicarMovil(bonecrusher,pos1);
		Bumblebee.getBumblebee().cambiarModo();
		
		Algoformer bumblebee= Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BonecrusherAlternoNoPuedeAtacarDecepticons(){
		Bonecrusher.ResetearInstancia();
		Megatron.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bonecrusher = Bonecrusher.getBonecrusher();
		Posicion pos1 = new Posicion(3,3);
		tab.ubicarMovil(bonecrusher, pos1);
		
		Algoformer megatron =  Megatron.getMegatron();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos2);
		
		bonecrusher.atacar(megatron);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BonecrusherAlternoNoPuedeAtacarAutobotFueraDeRango(){
		Bonecrusher.ResetearInstancia();
		Optimus.ResetearInstancia();
		
		Tablero tab=new Tablero();
		
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		Posicion.setTablero(tab);
		
		Bonecrusher.getBonecrusher().cambiarModo();
		
		Algoformer bonecrusher=Bonecrusher.getBonecrusher();
		Posicion pos1 = new Posicion(2,0);
		tab.ubicarMovil(bonecrusher, pos1);
		
		Algoformer optimus=Optimus.getOptimus();
		Posicion pos2=new Posicion(7,0);
		tab.ubicarMovil(optimus, pos2);
		
		bonecrusher.atacar(optimus);
		
	}
	
	@Test
	public void test04CambioBonecrusherAModoAlterno(){
		Bonecrusher.ResetearInstancia();
		
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		
		
		//nace en modo alterno
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil( Megatron.getMegatron(), posIni);
		
		Bonecrusher.getBonecrusher().cambiarModo();
		
		Assert.assertTrue(Bonecrusher.getBonecrusher().distanciaPosible(1));
		Assert.assertFalse(Bonecrusher.getBonecrusher().distanciaPosible(8));
		
		Bonecrusher bone1=Bonecrusher.getBonecrusher();
		
		
		Bonecrusher.getBonecrusher().cambiarModo();
		
		
		
		Assert.assertTrue(Bonecrusher.getBonecrusher().distanciaPosible(8));//en modo altenro alcance1
		// si al cambiar modo me guardan una referencia me podrian hacer trampa
	}
		
	@Test
	public void test05BonecrusherAlternoSeMueve(){
		Bonecrusher.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Posicion.setTablero(tab);
		
		Algoformer bone =  Bonecrusher.getBonecrusher();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bone,posIni);
		Posicion posFin=new Posicion(9,4);
		
		bone.mover(posFin);
	
		Assert.assertTrue(bone.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test06BonecrusherAlternoTieneLimiteDeVelocidad(){
		Bonecrusher.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bone = Bonecrusher.getBonecrusher();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bone, posIni);
		Posicion posFin=new Posicion(10,4);
		
		bone.mover(posFin);
	
	}
	
	@Test
	public void test07BonecrusherAlternoEsAtacadoPorEnemigoHumanoide(){
		Bonecrusher.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);

		Algoformer bonecrusher = Bonecrusher.getBonecrusher();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bonecrusher, pos1);

		Bumblebee.getBumblebee().cambiarModo();
		
		Algoformer bumblebee= Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(bumblebee, pos2);	
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
	}
	
	@Test
	public void test08BonecrusherAlternoAtacaEnemigoAlterno(){
		Bonecrusher.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		Algoformer bonecrusher= Bonecrusher.getBonecrusher();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(bonecrusher, pos1);
		
		Algoformer bumblebee= Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(bumblebee, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
		
	}
	
	@Test
	public void test09BonecrusherAlternoEsAtacadoPorEnemigoAlterno(){
		Bonecrusher.ResetearInstancia();
		Bumblebee.ResetearInstancia();
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Ataque.setTablero(tab);
		
		
		Algoformer bonecrusher= Bonecrusher.getBonecrusher();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bonecrusher, pos1);
		
		Algoformer bumblebee=Bumblebee.getBumblebee();
		Posicion pos2=new Posicion(5,2);
		tab.ubicarMovil(bumblebee, pos2);
		
		
		bumblebee.atacar(bonecrusher);
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 180
		Assert.assertTrue(bonecrusher.getVida()==180);
	}
	


}
