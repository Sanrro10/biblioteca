package es.deusto.spq.client.data;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.data.Usuario;

public class UsuarioTest {
	private Usuario usuario1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		usuario1 = new Usuario("a@a.com", "a", "a", 654321987, "123", false);
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testUsuario() {
		
		
		assertEquals("a@a.com", usuario1.getEmail());
		assertEquals("a", usuario1.getNombre());
		assertEquals("a", usuario1.getApellidos());
		assertEquals(654321987, usuario1.getTelefono());
		assertEquals("123", usuario1.getContrasenya());
		assertEquals(false, usuario1.isGestor());
		
	}
	
	

}