package es.deusto.spq.client.data;

import static org.junit.Assert.*;

import java.util.Date;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.data.ReservaSala;

public class TestReservaSala {
	private ReservaSala reservaSala1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		Date d = null;
		reservaSala1 = new ReservaSala(01, "a@a.com", 01, d, true, "");
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testReservaSala() {
		
		
		assertEquals(01, reservaSala1.getCod_Reserva_Sala());
		assertEquals("a@a.com", reservaSala1.getEmail());
		assertEquals(01, reservaSala1.getCod_Sala());
		assertEquals(null, reservaSala1.getFecha());
		assertEquals(true, reservaSala1.isCalefaccion());
		assertEquals("", reservaSala1.getUsuariosExtra());
		
		
	}

}
