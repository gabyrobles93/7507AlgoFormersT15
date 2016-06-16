package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Autobots;
import Modelo.Bumblebee;

import Modelo.Optimus;

import Modelo.Ratchet;



public class AutobotsTest {
	
	@Test
	public void test01ObtenerOptimusHumanoide(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(optimus==autobots.getOptimus());
		
	}
	
	@Test
	public void test02ObtenerOptimusAlterno(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(optimus==autobots.getOptimus());
		
	}
	
	@Test
	public void test03ObtenerBumblebeeHumanoide(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(bumblebee==autobots.getBumblebee());
		
	}
	
	
	@Test
	public void test04ObtenerBumblebeeAlterno(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(bumblebee==autobots.getBumblebee());
		
	}
	
	@Test
	public void test05ObtenerRatchetHumanoide(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(ratchet==autobots.getRatchet());
		
	}
	
	@Test
	public void test06ObtenerRatchetAlterno(){
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee=Bumblebee.getBumblebee();
		Ratchet ratchet=Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		Assert.assertTrue(ratchet==autobots.getRatchet());
		
	}
	
	@Test
	public void test07AutobotsComienzaConVidaTotalIgualASumatoriaDeVidasDeIntegrantes() {
		
		Optimus optimus=Optimus.getOptimus();
		Bumblebee bumblebee= Bumblebee.getBumblebee();
		Ratchet ratchet= Ratchet.getRatchet();

		Autobots autobots=new Autobots(optimus,bumblebee,ratchet);
		
		int sumvidaintegrantes = autobots.getOptimus().getVida()
								+ autobots.getBumblebee().getVida() 
								+ autobots.getRatchet().getVida();
		
		Assert.assertTrue(autobots.getVidaTotal() == sumvidaintegrantes);
	}
	
	

}
