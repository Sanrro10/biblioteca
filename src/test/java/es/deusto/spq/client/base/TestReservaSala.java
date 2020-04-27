package es.deusto.spq.client.base;

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
		reservaSala1 = new ReservaSala(01, 01, 01, null, true);
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testReservaSala() {
		
		
		assertEquals(01, reservaSala1.getCod_Reserva_Sala());
		assertEquals(01, reservaSala1.getCod_Usuario());
		assertEquals(01, reservaSala1.getCod_Sala());
		assertEquals(null, reservaSala1.getFecha());
		assertEquals(true, reservaSala1.isCalefaccion());
		
		
	}

}
