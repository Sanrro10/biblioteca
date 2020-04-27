package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.SalaTrabajo;

public class TestSalaTrabajo {

	@Test
	public void testCrearsala() {
		SalaTrabajo sala1 = new SalaTrabajo(01, "Piso 1", 5);
		
		int test = 01;
		String piso = "Piso 1";
		int personas = 5;
		
		assertTrue(sala1.getCod_sala()==test);
		assertTrue(sala1.getUbicacion().equals(piso));
		assertTrue(sala1.getNumMaxUsuarios()==personas);
	}

}
