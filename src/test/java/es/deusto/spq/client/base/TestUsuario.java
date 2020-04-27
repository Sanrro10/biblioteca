package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.Usuario;

public class TestUsuario {

	@Test
	public void testUsuario() {
		
		Usuario usuario1 = new Usuario(01, "a@a.com", "a", "a", 654321987, "123");
		
		int cod_Usuario = 01;
		String email = "a@a.com";
		String nombre ="a";
		String apellidos ="a";
		int telefono =654321987;
		String contrasenya = "123";
		
		assertTrue(usuario1.getCod_Usuario()==cod_Usuario);
		assertTrue(usuario1.getEmail()==email);
		assertTrue(usuario1.getNombre()==nombre);
		assertTrue(usuario1.getApellidos()==apellidos);
		assertTrue(usuario1.getTelefono()==telefono);
		assertTrue(usuario1.getContrasenya()==contrasenya);
		
		
		
		
		
	}

}
