package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.Solicitud;

/**
 * Clase Test de Assembler SolicitudAssembler
 *@author isanr 
 */
public class SolicitudAssemblerTest {

	Solicitud solicitud1;
	SolicitudDTO solicitudDTO1;
	
	Solicitud solicitud2;
	SolicitudDTO solicitudDTO2;
	
	SolicitudAssembler solicitudAs1;

	@Before
	public void setUp() {
		solicitud1 = new Solicitud();

		solicitud1 = new Solicitud(1,"a","A","G",3);
		solicitudDTO2 = new SolicitudDTO(1,"a","A","G",3);

	}
	
	@Test
	public void EntityToDTOTest() {
		solicitudDTO1 = SolicitudAssembler.getInstance().entityToDTO(solicitud1);
		
		assertEquals(solicitudDTO1.getAutorS(), solicitud1.getAutorS());
		assertEquals(solicitudDTO1.getCantidadS(), solicitud1.getCantidadS());
		assertEquals(solicitudDTO1.getCodigoS(), solicitud1.getCodigoS());
		assertEquals(solicitudDTO1.getGeneroS(), solicitud1.getGeneroS());
		assertEquals(solicitudDTO1.getTituloS(), solicitud1.getTituloS());
	}
	
	@Test
	public void DTOToEntityTest() {
		solicitud2 = SolicitudAssembler.getInstance().DTOtoEntity(solicitudDTO2);
		
		assertEquals(solicitudDTO2.getAutorS(), solicitud2.getAutorS());
		assertEquals(solicitudDTO2.getCantidadS(), solicitud2.getCantidadS());
		assertEquals(solicitudDTO2.getCodigoS(), solicitud2.getCodigoS());
		assertEquals(solicitudDTO2.getGeneroS(), solicitud2.getGeneroS());
		assertEquals(solicitudDTO2.getTituloS(), solicitud2.getTituloS());
	}

}
