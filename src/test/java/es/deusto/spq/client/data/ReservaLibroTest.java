package es.deusto.spq.client.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ReservaLibroTest {

	private ReservaLibro reservaLibro1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		Date d = null;
		reservaLibro1 = new ReservaLibro();
		reservaLibro1.setCod_Libro(1);
		reservaLibro1.setCod_Reserva_Libro(0);
		reservaLibro1.setEmail("a@a.com");
		reservaLibro1.setEstado_Libro(0);
		reservaLibro1.setFecha_Devolución(d);
		}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testReservaLibro() {
		
		
		assertEquals(0, reservaLibro1.getCod_Reserva_Libro());
		assertEquals("a@a.com", reservaLibro1.getEmail());
		assertEquals(1, reservaLibro1.getCod_Libro());
		assertEquals("a@a.com", reservaLibro1.getEmail());
		assertEquals(0, reservaLibro1.getEstado_Libro());
		
		
	}
}
