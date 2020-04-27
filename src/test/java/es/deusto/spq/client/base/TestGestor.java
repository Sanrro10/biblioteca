package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import es.deusto.spq.client.data.Gestor;

public class TestGestor {

	private Gestor gestor1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		gestor1 = new Gestor("admin@gmail.com", "admin", "admin", 654327811, "admin");
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testGestor() {
		
		
		assertEquals("admin@gmail.com", gestor1.getEmail());	
		assertEquals("admin", gestor1.getNombre());	
		assertEquals("admin", gestor1.getApellidos());	
		assertEquals(654327811, gestor1.getTelefono());	
		assertEquals("admin", gestor1.getContrasenya());	
	}
	
	
	
	
	
	
	
	

} 
