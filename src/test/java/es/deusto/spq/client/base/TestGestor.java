package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.Gestor;

public class TestGestor {

	@Test
	public void testGestor() {
		Gestor gestor1= new Gestor("admin@gmail.com", "admin", "admin", 654327811, "admin");
		
		String email = "admin@gmail.com";
		String nombre = "admin";
		String apellidos = "admin";
		int telefono = 654327811;
		String contrasenya = "admin";
		
		assertTrue(gestor1.getEmail()==email);
		assertTrue(gestor1.getNombre()==nombre);
		assertTrue(gestor1.getApellidos()==apellidos);
		assertTrue(gestor1.getTelefono()==telefono);
		assertTrue(gestor1.getContrasenya()==contrasenya);
		
		
	}

} 
