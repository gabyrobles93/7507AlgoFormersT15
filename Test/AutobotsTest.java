package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Autobots;
import Modelo.Bumblebee;
import Modelo.BumblebeeAlterno;
import Modelo.BumblebeeHumanoide;
import Modelo.Juego;
import Modelo.Optimus;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Ratchet;
import Modelo.RatchetAlterno;
import Modelo.RatchetHumanoide;


public class AutobotsTest {
	
	@Test
	public void test01ObtenerOptimusHumanoide(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(optimus==autobots.getOptimus());
		
	}
	
	@Test
	public void test02ObtenerOptimusAlterno(){
		Optimus optimus=new OptimusAlterno();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(optimus==autobots.getOptimus());
		
	}
	
	@Test
	public void test03ObtenerBumblebeeHumanoide(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(bumblebee==autobots.getBumblebee());
		
	}
	
	
	@Test
	public void test04ObtenerBumblebeeAlterno(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeAlterno();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(bumblebee==autobots.getBumblebee());
		
	}
	
	@Test
	public void test05ObtenerRatchetHumanoide(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(ratchet==autobots.getRatchet());
		
	}
	
	@Test
	public void test06ObtenerRatchetAlterno(){
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetAlterno();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(ratchet==autobots.getRatchet());
		
	}
	
	@Test
	public void test07AutobotsComienzaConVidaTotalIgualASumatoriaDeVidasDeIntegrantes() {
		
		Optimus optimus=new OptimusHumanoide();
		Bumblebee bumblebee=new BumblebeeHumanoide();
		Ratchet ratchet=new RatchetHumanoide();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		int sumvidaintegrantes = autobots.getOptimus().getVida()
								+ autobots.getBumblebee().getVida() 
								+ autobots.getRatchet().getVida();
		
		Assert.assertTrue(autobots.getVidaTotal() == sumvidaintegrantes);
	}
	
	

}
