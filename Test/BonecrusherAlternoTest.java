package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algoformer;
import Modelo.BonecrusherAlterno;
import Modelo.BonecrusherHumanoide;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.ErrorDistanciaDeAtaqueInsuficiente;
import Modelo.ErrorNoSePuedeAtacarIntegranteDeEquipo;
import Modelo.ErrorVelocidadDelMovilInsuficiente;
import Modelo.MegatronHumanoide;
import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Tablero;

public class BonecrusherAlternoTest {
	
	@Test
	public void test01BonecrusherAlternoAtacaEnemigoHumanoide(){
		
		Tablero tab= new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(bonecrusher,pos1);
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(bumblebee,pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
		
	}
	
	@Test(expected=ErrorNoSePuedeAtacarIntegranteDeEquipo.class)
	public void test02BonecrusherAlternoNoPuedeAtacarDecepticons(){
		
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(bonecrusher, pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(3,5);
		tab.ubicarMovil(megatron, pos2);
		
		bonecrusher.atacar(megatron);
		
	}
	
	@Test(expected=ErrorDistanciaDeAtaqueInsuficiente.class)
	public void test03BonecrusherAlternoNoPuedeAtacarAutobotFueraDeRango(){

		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(2,0);
		tab.ubicarMovil(bonecrusher, pos1);
		Algoformer megatron=new MegatronHumanoide();
		Posicion pos2=new Posicion(6,0);
		tab.ubicarMovil(megatron, pos2);
		
		bonecrusher.atacar(megatron);
		
	}
	
	@Test
	public void test04CambioBonecrusherAModoAlterno(){
		
		Algoformer bone_hum=new BonecrusherHumanoide();
		Algoformer bone_alt=new BonecrusherAlterno();
		
		Assert.assertTrue(bone_hum.equals(bone_alt.cambiarModo()));
	}
		
	@Test
	public void test06BonecrusherAlternoSeMueve(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bone = new BonecrusherAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bone,posIni);
		Posicion posFin=new Posicion(9,4);
		
		bone.mover(posFin);
	
		Assert.assertTrue(bone.getPosicion().equals(posFin));
	
	}
	
	@Test(expected=ErrorVelocidadDelMovilInsuficiente.class)
	public void test07BonecrusherAlternoTieneLimiteDeVelocidad(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bone = new BonecrusherAlterno();
		Posicion posIni=new Posicion(1,4);
		tab.ubicarMovil(bone, posIni);
		Posicion posFin=new Posicion(10,4);
		
		bone.mover(posFin);
	
	}
	
	@Test
	public void test08BonecrusherAlternoEsAtacadoPorEnemigoHumanoide(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bonecrusher, pos1);
		Algoformer bumblebee=new BumblebeeHumanoide();
		Posicion pos2=new Posicion(2,3);
		tab.ubicarMovil(bumblebee, pos2);
		
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 40 de ataque le deben quedar 160
		Assert.assertTrue(bonecrusher.getVida()==160);
	}
	
	@Test
	public void test09BonecrusherAlternoAtacaEnemigoAlterno(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(3,3);
		tab.ubicarMovil(bonecrusher, pos1);;
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos2=new Posicion(3,6);
		tab.ubicarMovil(bumblebee, pos2);//Coloco enemigo a maxima distancia alcanzada
		
		bonecrusher.atacar(bumblebee);
		
		//como Bumblebee tiene vida 350 y Bonecrusher 30 de ataque le deben quedar 320
		Assert.assertTrue(bumblebee.getVida()==320);
		
	}
	
	@Test
	public void test10BonecrusherAlternoEsAtacadoPorEnemigoAlterno(){
		Tablero tab=new Tablero();
		Movimiento.setTablero(tab);
		Algoformer bonecrusher=new BonecrusherAlterno();
		Posicion pos1=new Posicion(2,2);
		tab.ubicarMovil(bonecrusher, pos1);
		Algoformer bumblebee=new BumblebeeAlterno();
		Posicion pos2=new Posicion(5,2);
	
		tab.ubicarMovil(bumblebee, pos2);
		bumblebee.atacar(bonecrusher);
		
		//como Bonecrusher tiene vida 200 y Bumblebee 20 de ataque le deben quedar 180
		Assert.assertTrue(bonecrusher.getVida()==180);
	}
	


}
