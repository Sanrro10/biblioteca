package es.deusto.spq.client.data;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ActividadTest {

	private Actividad a1;
	private Actividad a2;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		a1 = new Actividad();
		a2 = new Actividad(1, "12:00-13:30", "Juegos");
		a1.setDia(0);
		a1.setHora("11:00-13:30");
		a1.setTexto("AA");
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testActividad() {
		
		
		assertEquals(1, a2.getDia());
		assertEquals("12:00-13:30", a2.getHora());
		assertEquals("Juegos", a2.getTexto());
		
	}
}
