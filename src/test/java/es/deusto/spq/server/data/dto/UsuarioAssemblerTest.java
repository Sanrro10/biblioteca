package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.Usuario;

/**
 * Clase Test de Assembler UsuarioAssembler
 *@author isanr 
 */
public class UsuarioAssemblerTest {

	Usuario usuario1;
	UsuarioDTO usuarioDTO1;
	
	Usuario usuario2;
	UsuarioDTO usuarioDTO2;
	

	@Before
	public void setUp() {
		usuario1 = new Usuario();

		usuario1 = new Usuario();
		usuario1.setApellidos("a");
		usuario1.setContrasenya("123");
		usuario1.setEmail("a@a.com");
		usuario1.setGestor(false);
		usuario1.setNombre("A");
		usuario1.setTelefono(12345);
		usuarioDTO2 = new UsuarioDTO();
		usuarioDTO2.setApellidos("a");
		usuarioDTO2.setContrasenya("123");
		usuarioDTO2.setEmail("a@a.com");
		usuarioDTO2.setGestor(false);
		usuarioDTO2.setNombre("A");
		usuarioDTO2.setTelefono(12345);

	}
	
	@Test
	public void EntityToDTOTest() {
		usuarioDTO1 = UsuarioAssembler.getInstance().entityToDTO(usuario1);
		
		assertEquals(usuarioDTO1.getApellidos(), usuario1.getApellidos());
		assertEquals(usuarioDTO1.getContrasenya(), usuario1.getContrasenya());
		assertEquals(usuarioDTO1.getEmail(), usuario1.getEmail());
		assertEquals(usuarioDTO1.isGestor(), usuario1.isGestor());
		assertEquals(usuarioDTO1.getNombre(), usuario1.getNombre());
		assertEquals(usuarioDTO1.getTelefono(), usuario1.getTelefono());
	}
	
	@Test
	public void DTOToEntityTest() {
		usuario2 = UsuarioAssembler.getInstance().DTOtoEntity(usuarioDTO2);
		
		assertEquals(usuarioDTO2.getApellidos(), usuario2.getApellidos());
		assertEquals(usuarioDTO2.getContrasenya(), usuario2.getContrasenya());
		assertEquals(usuarioDTO2.getEmail(), usuario2.getEmail());
		assertEquals(usuarioDTO2.isGestor(), usuario2.isGestor());
		assertEquals(usuarioDTO2.getNombre(), usuario2.getNombre());
		assertEquals(usuarioDTO2.getTelefono(), usuario2.getTelefono());
	}

}
