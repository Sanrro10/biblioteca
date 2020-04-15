package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.base.SalaTrabajo;

public class TestSalaTrabajo {

	@Test
	public void testCrearsala() {
		SalaTrabajo sala1 = new SalaTrabajo(01, 1, "Piso 1", 5);
		
		int test = 01;
		int num = 1;
		String piso = "Piso 1";
		int personas = 5;
		
		assertTrue(sala1.getCod_sala()==test);
		assertTrue(sala1.getNum_sala()==num);
		assertTrue(sala1.getUbicacion().equals(piso));
		assertTrue(sala1.getNumMaxUsuarios()==personas);
	}

}
