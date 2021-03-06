package es.deusto.spq.server.data;

import static org.junit.Assert.*;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



public class SalaTrabajoTest {
	private SalaTrabajo salatrabajo1;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		salatrabajo1 = new SalaTrabajo(1, "Piso 1", 5);
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testReservaSala() {
		
		
		assertEquals(01, salatrabajo1.getCod_sala());
		assertEquals("Piso 1", salatrabajo1.getUbicacion());
		assertEquals(5, salatrabajo1.getNumMaxUsuarios());
		
		
	}
	
	
	
	
	
	
	

}