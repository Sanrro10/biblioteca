package es.deusto.spq.client.data;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import es.deusto.spq.client.data.Solicitud;

public class SolicitudTest {

	private Solicitud solicitud1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		solicitud1 = new Solicitud(01, "Solicitud 1", "AA", "Novela historica", 10);
		solicitud1.setAutorS("AA");
		solicitud1.setCantidadS(10);
		solicitud1.setCodigoS(01);
		solicitud1.setGeneroS("Novela historica");
		solicitud1.setTituloS("Solicitud 1");
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testSolicitud() {
		
		
		assertEquals(01, solicitud1.getCodigoS());
		assertEquals("Solicitud 1", solicitud1.getTituloS());
		assertEquals("AA", solicitud1.getAutorS());
		assertEquals( "Novela historica", solicitud1.getGeneroS());
		assertEquals(10, solicitud1.getCantidadS());
		
		
	}
	
	
}

