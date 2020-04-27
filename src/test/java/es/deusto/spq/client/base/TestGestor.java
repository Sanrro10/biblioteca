package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.Gestor;

public class TestGestor {

	@Test
	public void testGestor() {
		Gestor gestor1= new Gestor(0, "admin@gmail.com", "admin", "admin", 654327811, "admin");
		
		int test = 0;
		String email = "admin@gmail.com";
		String nombre = "admin";
		String Apellidos = "admin";
		int telefono = 654327811;
		String contrasenya = "admin";
		
		assertTrue(gestor1.getCod_Usuario()==test);
		
		
	}

} 
