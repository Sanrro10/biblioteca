package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.deusto.spq.client.data.ReservaSala;

public class TestReservaSala {

	@Test
	public void testReservaSala() {
		ReservaSala reservaSala1 = new ReservaSala(01, 01, 01, null, true);
		
		assertEquals(01, reservaSala1.getCod_Reserva_Sala());
		assertEquals(01, reservaSala1.getCod_Usuario());
		assertEquals(01, reservaSala1.getCod_Sala());
		assertEquals(null, reservaSala1.getFecha());
		assertEquals(true, reservaSala1.isCalefaccion());
		
	}

}
