package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Autobots;
import Modelo.Bumblebee;
import Modelo.BumblebeeHumanoide;
import Modelo.Optimus;
import Modelo.OptimusAlterno;
import Modelo.OptimusHumanoide;
import Modelo.Ratchet;
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

}
