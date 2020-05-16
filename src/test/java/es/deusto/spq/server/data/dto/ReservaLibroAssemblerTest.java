package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.ReservaLibro;

/**
 * Clase Test de Assembler ReservaLibroAssembler
 *@author isanr 
 */
public class ReservaLibroAssemblerTest {

	ReservaLibro reservaLibro1;
	ReservaLibroDTO reservaLibroDTO1;
	
	ReservaLibro reservaLibro2;
	ReservaLibroDTO reservaLibroDTO2;
	
	ReservaLibroAssembler reservaLibroAs1;

	@Before
	public void setUp() {
		reservaLibro1 = new ReservaLibro();

		Date d = new Date();
		reservaLibro1 = new ReservaLibro(0, "a@a.com", 2, d, 2);
		reservaLibroDTO2 = new ReservaLibroDTO();
		reservaLibroDTO2.setCod_Libro(0);
		reservaLibroDTO2.setCod_Reserva_Libro(2);
		reservaLibroDTO2.setEmail("a@a.com");
		reservaLibroDTO2.setEstado_Libro(2);
		reservaLibroDTO2.setFecha_Devolución(d);

	}
	
	@Test
	public void EntityToDTOTest() {
		reservaLibroDTO1 = ReservaLibroAssembler.getInstance().entityToDTO(reservaLibro1);
		
		assertEquals(reservaLibroDTO1.getCod_Libro(), reservaLibro1.getCod_Libro());
		assertEquals(reservaLibroDTO1.getCod_Reserva_Libro(), reservaLibro1.getCod_Reserva_Libro());
		assertEquals(reservaLibroDTO1.getEmail(), reservaLibro1.getEmail());
		assertEquals(reservaLibroDTO1.getEstado_Libro(), reservaLibro1.getEstado_Libro());
		assertEquals(reservaLibroDTO1.getFecha_Devolución(), reservaLibro1.getFecha_Devolución());
	}
	
	@Test
	public void DTOToEntityTest() {
		reservaLibro2 = ReservaLibroAssembler.getInstance().DTOtoEntity(reservaLibroDTO2);
		
		assertEquals(reservaLibroDTO2.getCod_Libro(), reservaLibro2.getCod_Libro());
		assertEquals(reservaLibroDTO2.getCod_Reserva_Libro(), reservaLibro2.getCod_Reserva_Libro());
		assertEquals(reservaLibroDTO2.getEmail(), reservaLibro2.getEmail());
		assertEquals(reservaLibroDTO2.getEstado_Libro(), reservaLibro2.getEstado_Libro());
		assertEquals(reservaLibroDTO2.getFecha_Devolución(), reservaLibro2.getFecha_Devolución());
	}

}
