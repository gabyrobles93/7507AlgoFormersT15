package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Algoformer;
import modelo.Autobots;
import modelo.Decepticons;
import modelo.Equipo;
import modelo.ErrorAreaFueraDeRangoPosible;
import modelo.ErrorCasillerosNoConectadosPorLineaRecta;
import modelo.ErrorVelocidadDelMovilInsuficiente;
import modelo.Megatron;
import modelo.Optimus;
import modelo.Posicion;
import modelo.Tablero;


public class TableroTest {

	
	@Test
	public void test01AgregoAlgoformerAtableroYloBusco() {
		
		Tablero tablero1=new Tablero();
		Algoformer megatron= Megatron.getMegatron();
		Posicion unaPos=new Posicion(1,2);
		tablero1.ubicarMovil(megatron,unaPos);
		
		Assert.assertTrue(tablero1.existeMovil(megatron));
		Assert.assertTrue(megatron.getPosicion()==unaPos);
		
	}
	

	


	

@Test
public void test76ObtengoSubAreaYverificoEstarReferenciandoLosmismosCasilleros(){
	Tablero tablero1 =new Tablero();
	
	
	Equipo decepticons =new Decepticons();
	Megatron.getMegatron().setEquipo(decepticons);
	
	Equipo autobots =new Autobots();
	Optimus.getOptimus().setEquipo(autobots);
	
	Megatron.getMegatron().cambiarModo();
	Algoformer megatron= Megatron.getMegatron();
	Optimus.getOptimus().cambiarModo();
	Algoformer optimus=Optimus.getOptimus();
	Posicion unaPos=new Posicion(2,2);
	Posicion otraPos=new Posicion(5,5);
	tablero1.ubicarMovil(megatron, unaPos);
	tablero1.ubicarMovil(optimus, otraPos);
	Tablero subTablero=tablero1.getArea(unaPos, 2);
	
	Assert.assertTrue(subTablero.existeMovil(megatron));
	Assert.assertFalse(subTablero.existeMovil(optimus));
}
@Test
public void test88getAreaReferenciaHastaDondePuede(){
	Tablero tablero1=new Tablero();
	Posicion pos=new Posicion(3,3);
	Equipo decepticons =new Decepticons();
	Megatron.getMegatron().setEquipo(decepticons);
	Megatron.getMegatron().cambiarModo();
	Megatron mega=Megatron.getMegatron();
	tablero1.ubicarMovil(mega, pos);
	Tablero subtab=tablero1.getArea(pos, 4);
	
	Assert.assertTrue(tablero1.existeMovil(mega));
	Assert.assertTrue(subtab.existeMovil(mega));

	}



	







	
	
}
