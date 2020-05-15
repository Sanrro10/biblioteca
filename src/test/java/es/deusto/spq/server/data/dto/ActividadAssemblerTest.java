package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.Actividad;

public class ActividadAssemblerTest {

	Actividad actividad1;
	ActividadDTO actividadDTO1;
	
	Actividad actividad2;
	ActividadDTO actividadDTO2;


	@Before
	public void setUp() {
		actividad1 = new Actividad();

		Actividad actividad1 = new Actividad(1, "12:00-13:30", "Cuentacuentos");
		ActividadDTO actividadDTO2 = new ActividadDTO();
		actividadDTO2.setDia(1);
		actividadDTO2.setHora("12:00-13:30");
		actividadDTO2.setTexto("Cuentacuentos");

	}
	
	@Test
	public void EntityToDTOTest() {
		actividadDTO1 = ActividadAssembler.getInstance().entityToDTO(actividad1);
		
		assertEquals(actividadDTO1.getDia(), actividad1.getDia());
		assertEquals(actividadDTO1.getHora(), actividad1.getHora());
		assertEquals(actividadDTO1.getTexto(), actividad1.getTexto());
	}
	
	@Test
	public void DTOToEntityTest() {
		actividad2 = ActividadAssembler.getInstance().DTOtoEntity(actividadDTO2);
		
		assertEquals(actividadDTO2.getDia(), actividad2.getDia());
		assertEquals(actividadDTO2.getHora(), actividad2.getHora());
		assertEquals(actividadDTO2.getTexto(), actividad2.getTexto());
	}

}
