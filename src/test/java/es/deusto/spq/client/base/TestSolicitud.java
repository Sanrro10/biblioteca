package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.Solicitud;

public class TestSolicitud {

	@Test
	public void test() {
		Solicitud solicitud1 = new Solicitud(01, "Solicitud 1", "Sergio", "Novela historica", 10);
		
		int test = 01;
		String tituloS = "Solicitud 1";
		String autorS = "Sergio";
		String generoS = "Novela historica";
		int cantidadS = 10;
		
		assertTrue(solicitud1.getCodigoS()==test);
		assertTrue(solicitud1.getTituloS().equals(tituloS));
		assertTrue(solicitud1.getAutorS()==autorS);
		assertTrue(solicitud1.getGeneroS()==generoS);
		assertTrue(solicitud1.getCantidadS()==cantidadS);
		
		
	}

}
