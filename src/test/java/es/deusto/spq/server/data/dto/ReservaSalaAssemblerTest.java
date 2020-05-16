package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.ReservaSala;

/**
 * Clase Test de Assembler ReservaSalaoAssembler
 *@author isanr 
 */
public class ReservaSalaAssemblerTest {

	ReservaSala reservaSala1;
	ReservaSalaDTO reservaSalaDTO1;
	
	ReservaSala reservaSala2;
	ReservaSalaDTO reservaSalaDTO2;
	
	ReservaSalaAssembler reservaSalaAs1;

	@Before
	public void setUp() {
		reservaSala1 = new ReservaSala();
		Date d = new Date();

		reservaSala1 = new ReservaSala();
		reservaSala1.setCalefaccion(true);
		reservaSala1.setCod_Reserva_Sala(0);
		reservaSala1.setCod_Sala(0);
		reservaSala1.setEmail("a@a.com");
		reservaSala1.setFecha(d);
		reservaSalaDTO2 = new ReservaSalaDTO();
		reservaSalaDTO2.setCalefaccion(true);
		reservaSalaDTO2.setCod_Reserva_Sala(0);
		reservaSalaDTO2.setCod_Sala(0);
		reservaSalaDTO2.setEmail("a@a.com");
		reservaSalaDTO2.setFecha(d);

	}
	
	@Test
	public void EntityToDTOTest() {
		reservaSalaDTO1 = ReservaSalaAssembler.getInstance().entityToDTO(reservaSala1);
		
		assertEquals(reservaSalaDTO1.getCod_Reserva_Sala(), reservaSala1.getCod_Reserva_Sala());
		assertEquals(reservaSalaDTO1.getCod_Sala(), reservaSala1.getCod_Sala());
		assertEquals(reservaSalaDTO1.getEmail(), reservaSala1.getEmail());
		assertEquals(reservaSalaDTO1.getFecha(), reservaSala1.getFecha());
		assertEquals(reservaSalaDTO1.getUsuariosExtra(), reservaSala1.getUsuariosExtra());
	}
	
	@Test
	public void DTOToEntityTest() {
		reservaSala2 = ReservaSalaAssembler.getInstance().DTOtoEntity(reservaSalaDTO2);
		
		assertEquals(reservaSalaDTO2.getCod_Reserva_Sala(), reservaSala2.getCod_Reserva_Sala());
		assertEquals(reservaSalaDTO2.getCod_Sala(), reservaSala2.getCod_Sala());
		assertEquals(reservaSalaDTO2.getEmail(), reservaSala2.getEmail());
		assertEquals(reservaSalaDTO2.getFecha(), reservaSala2.getFecha());
		assertEquals(reservaSalaDTO2.getUsuariosExtra(), reservaSala2.getUsuariosExtra());
	}

}
