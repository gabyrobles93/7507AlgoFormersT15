package Test;

import org.junit.Assert;
import org.junit.Test;

import Modelo.AlgoFormer;
import Modelo.Equipo;
import Modelo.Juego;
import Modelo.MegatronAlterno;
import Modelo.Tablero;

public class AlgoFormerTest {
	
	
	@Test
	public void testCrearTableroYJugadores(){
		Juego Juego1=new Juego();
		Tablero tablero1 = new Tablero();
		Juego1.agregarTablero(tablero1);
		Assert.assertTrue(Juego1.getTablero()==tablero1);
		AlgoFormer megatron=new MegatronAlterno();
		Equipo Decepticons= new Equipo();
		Decepticons.agregarAlgoFormer(megatron);
		Assert.assertTrue(Decepticons.existeAlgoformer(megatron));
		Juego1.agregarEquipo(Decepticons);
		Assert.assertTrue(Juego1.existeEquipo(Decepticons));
		tablero1.ubicarAlgoFormers(Decepticons);
		Assert.assertTrue(tablero1.existeAlgoformer(megatron));
	}
	@Test
	public void testCrearAlgoFormerConEquipoClaseYUbicacion(){
		
	}

}
